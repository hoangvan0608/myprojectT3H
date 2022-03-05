package vn.t3h.java2109.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.t3h.java2109.model.AccountEntity;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<AccountEntity, Integer> {
    Optional<AccountEntity> findById(Integer id);
}
