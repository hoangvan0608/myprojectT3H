package vn.t3h.java2109.controller.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.t3h.java2109.dto.CategoryDTO;
import vn.t3h.java2109.dto.ProductDTO;
import vn.t3h.java2109.services.Impl.CategoryService;
import vn.t3h.java2109.services.Impl.ProductService;

import java.sql.*;
import java.util.List;

@Controller
@RequestMapping("/backend/product")

public class ProductController {

    @Autowired
    ProductService productService;
    @Autowired
    CategoryService categoryService;

     //Vào trang create
    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String createProduct(Model model) throws SQLException {
        return "/backend/product/create";
    }



    @ModelAttribute("category")
    public List<CategoryDTO> getAllCategories()
    {
        return categoryService.getAllCategories();
    }



    // Thực hiện lệnh khi submit
    @RequestMapping(value = "/save",method = RequestMethod.POST,  consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String createProduct(RedirectAttributes model, ProductDTO dto) throws SQLException {
        boolean result = productService.saveProduct(dto);
        if(result)
        {
            if(dto.getId() == null)
            {
                model.addFlashAttribute("message", "Tạo mới thành công!");
            }
            else {
                model.addFlashAttribute("message", "Sửa thành công!");
            }
        }
        else {
            model.addFlashAttribute("message", "Thao tác thất bại!");
        }
        return "redirect:/backend/product/list";
    }

//
//
    // Vào trang sửa product
    @RequestMapping(value = "edit/{id}")
    public String editProduct(Model model, @PathVariable Integer id) {
        try {
            ProductDTO product = productService.detailsProduct(id);
            model.addAttribute("product", product);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "backend/product/edit";
    }
//
//    @RequestMapping(value = "delete/{id}")
//    public String deleteProduct(RedirectAttributes model, @PathVariable Integer id) {
//
//        Boolean result= product.deleteProduct(id);
//        if(result)
//        {
//            model.addFlashAttribute("message", "Xóa thành công!");
//        }
//        else {
//            model.addFlashAttribute("message", "Đã xảy ra lỗi!");
//        }
//        return "redirect:/backend/product/list";
//    }


    @RequestMapping(value = "/list")
    public String homeProduct1(Model model) {
        List<ProductDTO> productDTOList = productService.getAllProducts();
        model.addAttribute("products", productDTOList);
        return "backend/product/list";
    }

}
