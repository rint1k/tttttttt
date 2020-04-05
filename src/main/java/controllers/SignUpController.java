package controllers;

import dto.SignUpDto;
import models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import services.SignUpService;

import javax.servlet.annotation.MultipartConfig;

@Controller
@MultipartConfig
public class SignUpController {
    @Autowired
    private SignUpService signUpService;

    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public ModelAndView getSignUpPage() {
        return new ModelAndView("signUp");
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public ModelAndView postSignUpPage(@RequestParam("username") String username, @RequestParam("email") String email, @RequestParam("password") String password) {
        signUpService.signUp(SignUpDto.builder().email(email).username(username).password(password).build());
        return new ModelAndView("login");
    }
}
