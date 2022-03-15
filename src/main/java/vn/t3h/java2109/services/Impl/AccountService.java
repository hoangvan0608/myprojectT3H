package vn.t3h.java2109.services.Impl;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import vn.t3h.java2109.dto.AccountDTO;
import vn.t3h.java2109.dto.form.CreateAccount;
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
    @Autowired
    PasswordEncoder encoder;

    @Override
    public List<AccountDTO> getAllAccounts() {
        List<AccountEntity> listEntities = accountRepository.findAll();

        return modelMapper.map(listEntities,
                new TypeToken<List<AccountDTO>>(){}.getType());
    }

    @Override
    public AccountDTO getAccountById(Integer id) {
        AccountEntity accountEntity =  accountRepository.findById(id).get();
        return modelMapper.map(accountEntity,
                new TypeToken<AccountDTO>(){}.getType());
    }

    @Override
    public void save(CreateAccount account) {
        account.setPassword(encoder.encode(account.getPassword()));
        accountRepository.save(modelMapper.map(account, new TypeToken<AccountEntity>(){}.getType()));
    }

    @Override
    public void updateAccount(Integer id, AccountDTO account) {
        Optional<AccountEntity> accOpt = accountRepository.findById(id);
        if(accOpt.isPresent())
        {
            AccountEntity accountEntity = accOpt.get();
            accountEntity.setUsername(account.getUsername());
            accountEntity.setEmail(account.getEmail());
            accountEntity.setDes(account.getDes());
            accountEntity.setPhone(account.getPhone());
            accountEntity.setRole(account.getRole());
            accountRepository.save(accountEntity);
        }
    }

    @Override
    public void delete(Integer id) {
        accountRepository.deleteById(id);
    }


}
