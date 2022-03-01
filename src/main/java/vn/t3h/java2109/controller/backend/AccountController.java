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
import vn.t3h.java2109.services.AccountService;

import java.sql.SQLException;

@Controller
@RequestMapping("backend/account")
public class AccountController {

    @Autowired
    AccountService accountService;

    @RequestMapping(value = "new", method = RequestMethod.GET)
    public String createAccount()
    {
        return "backend/account/create";
    }

    @RequestMapping(value = "save", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String saveAcount(RedirectAttributes model, AccountDTO dto)
    {
        boolean result = accountService.saveAccount(dto);
        return "redirect:/backend/account/list";
    }

    @RequestMapping(value = "update", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String updateAccount(AccountDTO dto)
    {
        boolean result = accountService.updateAccount(dto);
        if(result)
        {
            String abc = "abc";
        }
        return "redirect:/backend/account/list";
    }

    @RequestMapping(value = "edit/{id}", method = RequestMethod.GET)
    public String editAccount(@PathVariable(name = "id", required = false) Integer id, Model model) throws SQLException {
        AccountDTO dto = accountService.getAccountById(id);
        model.addAttribute("account",dto);
        return "backend/account/edit";
    }

    @RequestMapping(value = "list")
    public String homeAccount(RedirectAttributes model)
    {
        return "backend/account/list";
    }
}
