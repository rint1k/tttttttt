package controllers;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import services.FilesService;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

@Controller
@MultipartConfig
public class FilesController {

    @Autowired
    private FilesService  filesService;

    @RequestMapping("/files")
    public ModelAndView getMainPage() {
        return new ModelAndView("/upload1");
    }

    @RequestMapping(value = "/files/{file-name:.+}", method = RequestMethod.GET)
    public ModelAndView getFile(@PathVariable("file-name") String fileName, HttpServletResponse response) {
        try {
            InputStream is = filesService.getInputStreamByName(fileName);
            IOUtils.copy(is, response.getOutputStream());
            response.flushBuffer();
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
        return null;
    }

    @RequestMapping(value = "/files", method = RequestMethod.POST)
    public ModelAndView uploadFile(@RequestParam("file") MultipartFile multipartFile) {
        filesService.save(multipartFile);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("upload1");
        return modelAndView;
    }
}
