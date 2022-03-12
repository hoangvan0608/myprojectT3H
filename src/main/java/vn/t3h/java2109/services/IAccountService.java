package vn.t3h.java2109.services;

import vn.t3h.java2109.dto.AccountDTO;
import vn.t3h.java2109.dto.form.CreateAccount;
import vn.t3h.java2109.model.AccountEntity;

import java.util.List;

public interface IAccountService {

    List<AccountDTO> getAllAccounts();

    AccountDTO getAccountById(Integer id);

    void save(CreateAccount account);

    void updateAccount(Integer id,AccountDTO account);


    void delete(Integer id);
}
