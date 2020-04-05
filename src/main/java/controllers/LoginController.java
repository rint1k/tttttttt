package controllers;

import dto.SignUpDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import services.LoginService;

import javax.servlet.annotation.MultipartConfig;

@Controller
@MultipartConfig
public class LoginController {

    @RequestMapping("/login")
    public ModelAndView login() {
        return new ModelAndView("login");
    }
}
