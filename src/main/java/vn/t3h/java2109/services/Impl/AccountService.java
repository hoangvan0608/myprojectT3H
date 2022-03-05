package vn.t3h.java2109.services.Impl;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.t3h.java2109.dto.AccountDTO;
import vn.t3h.java2109.model.AccountEntity;
import vn.t3h.java2109.repository.AccountRepository;
import vn.t3h.java2109.services.IAccountService;

import java.util.List;
import java.util.Optional;


@Service
public class AccountService implements IAccountService {

    @Autowired
    AccountRepository accountRepository;
    @Autowired
    ModelMapper modelMapper;

    @Override
    public List<AccountDTO> getAllAccounts() {
        List<AccountEntity> listEntities = accountRepository.findAll();
        List<AccountDTO> listDtos = modelMapper.map(listEntities,
                new TypeToken<List<AccountDTO>>(){}.getType());

        return listDtos;
    }

    @Override
    public AccountDTO getAccountById(Integer id) {
        AccountEntity accountEntity =  accountRepository.findById(id).get();
        AccountDTO accountDTO = modelMapper.map(accountEntity,
                new TypeToken<AccountDTO>(){}.getType());
        return accountDTO;
    }

    @Override
    public void createAccount(AccountDTO account) {

    }

    @Override
    public void updateAccount(int id, AccountDTO account) {

    }
}
