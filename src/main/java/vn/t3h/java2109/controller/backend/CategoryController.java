package vn.t3h.java2109.controller.backend;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import vn.t3h.java2109.services.CategoryService;

@Controller
@RequestMapping("backend/category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @RequestMapping(value = "list")
    public String home(Model model){

        model.addAttribute("categories",categoryService.getAllCategories());
        return "backend/category/list";
    }
}
