package vn.t3h.java2109.controller.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.t3h.java2109.controller.frontend.FrontEndHomeController;
import vn.t3h.java2109.dto.CategoryDTO;
import vn.t3h.java2109.dto.ProductDTO;
import vn.t3h.java2109.services.CategoryService;
import vn.t3h.java2109.services.ProductService;
import vn.t3h.java2109.utils.DbUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/backend/product")

public class ProductController {

    @Autowired
    ProductService product;
    CategoryService categoryService;

    // Vào trang create
    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String createProduct(Model model) throws SQLException {
        List<CategoryDTO> list = new ArrayList<>();
        list = getAllCategories();
        model.addAttribute("category",list);
        return "/backend/product/create";
    }



    // Thực hiện lệnh khi submit
    @RequestMapping(value = "/save",method = RequestMethod.POST,  consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String createProduct(RedirectAttributes model, @ModelAttribute ProductDTO dto) throws SQLException {
        boolean result = product.saveProduct(dto);
        if(result)
        {
            model.addFlashAttribute("message", "Tạo mới thành công!");
        }
        else {
            model.addFlashAttribute("message", "Thao tác thất bại!");
        }
        return "redirect:/backend/product/list";
    }



    // Vào trang sửa product
    @RequestMapping(value = "edit/{id}")
    public String edit(Model model, @PathVariable Integer id) {
        try {
            model.addAttribute("product", product.detail(id));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "backend/product/edit";
    }


    @RequestMapping(value = "/list")
    public String homeProduct1(Model model, @RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "3") Integer perpage) throws SQLException {
        List<ProductDTO> productDTOList = product.getAllProduct();
        model.addAttribute("products",productDTOList);
        return "backend/product/list";
    }


    public static Boolean insertProductToDatabase(ProductDTO dto) throws SQLException {
        Connection conn = DbUtils.getConnection();
        Boolean check = false;
        try
        {
            String sql = "INSERT INTO `myshop`.`product` (`img`, `price`, `des`) VALUES (?,?,?);";
            PreparedStatement pr = conn.prepareStatement(sql);
            pr.setString(1,dto.getImg());
            pr.setDouble(2,dto.getPrice());
            pr.setString(3,dto.getName());
            int row = pr.executeUpdate();
            if(row !=0)
            {
                check = true;
            }
            pr.close();
        }
        catch (Exception e)
        {

        }
        finally {
            if(conn != null){
                conn.close();
            }
        }
        return check;
    }

    public static List<CategoryDTO> getAllCategories() throws SQLException {
        List<CategoryDTO> list = new ArrayList<CategoryDTO>();
        Connection connection = DbUtils.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet =  statement.executeQuery("Select * from category");
        while (resultSet.next())
        {
            String name = resultSet.getString(2);
            CategoryDTO dto = new CategoryDTO(name);
            list.add(dto);
        }
        return list;
    }

}
