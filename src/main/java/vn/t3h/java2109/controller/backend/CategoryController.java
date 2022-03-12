package vn.t3h.java2109.controller.backend;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.t3h.java2109.dto.CategoryDTO;
import vn.t3h.java2109.services.Impl.CategoryService;

import java.util.List;

@Controller
@RequestMapping("backend/category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping("list")
    public String homeCategory(Model model) {
        List<CategoryDTO> list = categoryService.getAllCategories();
        model.addAttribute("categories",list);
        return "backend/category/list";
    }

    @GetMapping("create")
    public String createCategory()
    {
        return "backend/category/create";
    }

    @PostMapping("save")
    public String saveCategory(RedirectAttributes model ,CategoryDTO category)
    {
        try{
            categoryService.saveCategory(category);
            if(category.getId() == null)
            {
                model.addFlashAttribute("message","Tạo mới thành công!");
            }
            else{
                model.addFlashAttribute("message","Sửa thành công!");
            }
        }
        catch (Exception e){
            e.printStackTrace();
            model.addFlashAttribute("message","Thao tác thất bại");
        }
        return "redirect:/backend/category/list";
    }
    @GetMapping("edit/{id}")
    public String editProduct(@PathVariable(name = "id") Integer id, Model model)
    {
        CategoryDTO categoryDTO = categoryService.getCategoryById(id);
        model.addAttribute("category",categoryDTO);
        return "backend/category/edit";
    }

    @GetMapping("delete/{id}")
    public String deleteProduct(@PathVariable(name = "id") Integer id, RedirectAttributes model)
    {
        categoryService.deleteCategoryById(id);
        return "redirect:/backend/category/list";
    }
}
