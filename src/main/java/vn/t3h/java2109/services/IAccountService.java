package vn.t3h.java2109.services;

import vn.t3h.java2109.dto.AccountDTO;

import java.util.List;

public interface IAccountService {

    List<AccountDTO> getAllAccounts();

    AccountDTO getAccountById(Integer id);

    void createAccount(AccountDTO account);

    void updateAccount(int id,AccountDTO account);

}
