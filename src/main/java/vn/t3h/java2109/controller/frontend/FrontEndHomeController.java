package vn.t3h.java2109.controller.frontend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import vn.t3h.java2109.dto.ProductDTO;
import vn.t3h.java2109.services.ProductService;
import vn.t3h.java2109.utils.DbUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Controller
public class FrontEndHomeController {

    @Autowired
    ProductService productService;

    @RequestMapping(value = {"/","home"})
    public String homePage(Model model) throws SQLException {
        List<ProductDTO> productDTOList = productService.getAllProduct();
        model.addAttribute("products",productDTOList);
        return "frontend/home";
    }

}
