package controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.annotation.MultipartConfig;

@Controller
@MultipartConfig
public class MainController {

    @RequestMapping("/")
    public ModelAndView getMain() {
        return new ModelAndView("file");
    }
}
