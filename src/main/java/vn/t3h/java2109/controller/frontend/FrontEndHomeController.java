package vn.t3h.java2109.controller.frontend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import vn.t3h.java2109.services.Impl.ProductService;

import java.sql.*;

@Controller
public class FrontEndHomeController {

    @Autowired
    ProductService productService;

    @RequestMapping(value = {"/","home"})
    public String homePage(Model model) throws SQLException {
        model.addAttribute("products",productService.findAll(1,100,""));
        return "frontend/home";
    }

}
