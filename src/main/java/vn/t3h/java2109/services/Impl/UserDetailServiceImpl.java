package vn.t3h.java2109.services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import vn.t3h.java2109.dto.form.UserDetailCustom;
import vn.t3h.java2109.model.AccountEntity;
import vn.t3h.java2109.repository.AccountRepository;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    AccountRepository accountRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AccountEntity userEntity = accountRepository.findFirstByUsername(username);
        if (userEntity == null) {
            throw new UsernameNotFoundException("không tìm thấy user name");
        }
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_" + userEntity.getRole()));


        UserDetailCustom userDetailCustom = new UserDetailCustom(userEntity.getUsername(), userEntity.getPassword(), grantedAuthorities);
        userDetailCustom.setEmail(userEntity.getEmail());
        userDetailCustom.setPhone(userEntity.getPhone());
        userDetailCustom.setId(userEntity.getId());
        return userDetailCustom;
    }
}
