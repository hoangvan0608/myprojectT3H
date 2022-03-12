package vn.t3h.java2109.controller.backend;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

    @RequestMapping(value = "_admin/login")
    public String homePage(){
        return "backend/login";
    }
}
