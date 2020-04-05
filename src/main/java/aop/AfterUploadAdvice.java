package aop;


import freemarker.cache.FileTemplateLoader;
import freemarker.cache.MultiTemplateLoader;
import freemarker.cache.TemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
import models.FileInfo;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.env.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Properties;

@Aspect
@Component
@PropertySource("classpath:application.properties")
public class AfterUploadAdvice {
    @Autowired
    Environment environment;

    @After(value = "execution(* services.FilesServiceImpl.save(..))")
    public void send() {
        System.out.println("WTF is going wrong?");
    }

    @AfterReturning(value = "execution(* services.FilesServiceImpl.save(..))", returning = "fileInfo")
    public void sendFileLinkToEmail(Object fileInfo) {
        System.out.println("Пишем письмо");
        Properties props = new Properties();
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        FileInfo f = (FileInfo) fileInfo;

        String email = environment.getProperty("email");
        String password = environment.getProperty("password");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(email, password);
                    }
                });
        Message message = new MimeMessage(session);

        try {
            message.setFrom(new InternetAddress(email));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(f.getUploadUser()));
            message.setSubject("You uploaded file");

            Configuration cfg = new Configuration(Configuration.VERSION_2_3_29);
            cfg.setClassForTemplateLoading(AfterUploadAdvice.class, "/jsp/");
            cfg.setDefaultEncoding("UTF-8");
            cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);

            Template template = cfg.getTemplate("confirmation.ftl");
            HashMap<String, String> root = new HashMap<>();
            root.put("email", "http://localhost:8080/Samatter/files/" + f.getStorageFileName());

            StringWriter stringWriter = new StringWriter();
            template.process(root, stringWriter);

            message.setContent(stringWriter.toString(), "text/html; charset=utf-8");

            Transport.send(message);
            System.out.println("Письмо с ссылкой на файл было отправлено" + f.getUploadUser());
        } catch (MessagingException e) {
            throw new IllegalStateException(e);
        } catch (IOException | TemplateException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
