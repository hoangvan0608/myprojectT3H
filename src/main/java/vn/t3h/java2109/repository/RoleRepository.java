package vn.t3h.java2109.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.t3h.java2109.model.RoleEntity;

public interface RoleRepository extends JpaRepository<RoleEntity, Integer> {
}
