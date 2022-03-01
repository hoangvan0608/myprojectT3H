package vn.t3h.java2109.controller.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.t3h.java2109.dto.AccountDTO;
import vn.t3h.java2109.dto.RoleDTO;
import vn.t3h.java2109.services.AccountService;
import vn.t3h.java2109.services.RoleService;

import java.sql.SQLException;
import java.util.List;

@Controller
@RequestMapping("backend/account")
public class AccountController {

    @Autowired
    AccountService accountService;
    @Autowired
    RoleService roleService;

    @RequestMapping(value = "new", method = RequestMethod.GET)
    public String createAccount(Model model) throws SQLException {
        List<RoleDTO> list = roleService.getAllRoles();
        model.addAttribute("roles",list);
        return "backend/account/create";
    }

    @RequestMapping(value = "save", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String saveAcount(RedirectAttributes model, AccountDTO dto)
    {

        boolean result = accountService.saveAccount(dto);
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
        return "redirect:/backend/account/list";
    }


    @RequestMapping(value = "edit/{id}", method = RequestMethod.GET)
    public String editAccount(@PathVariable(name = "id", required = false) Integer id, Model model) throws SQLException {
        AccountDTO dto = accountService.getAccountById(id);
        List<RoleDTO> list = roleService.getAllRoles();
        model.addAttribute("roles",list);
        model.addAttribute("account",dto);
        return "backend/account/edit";
    }

    @RequestMapping(value = "delete/{id}")
    public String deleteAccountById(RedirectAttributes model, @PathVariable Integer id) {

        Boolean result= accountService.deleteAccountById(id);
        if(result)
        {
            model.addFlashAttribute("message", "Xóa thành công!");
        }
        else {
            model.addFlashAttribute("message", "Đã xảy ra lỗi!");
        }
        return "redirect:/backend/account/list";
    }


    @RequestMapping(value = "list")
    public String homeAccount(Model model)
    {
        List<AccountDTO> list = accountService.getAllAccounts();
        model.addAttribute("accounts",list);
        return "backend/account/list";
    }


}
