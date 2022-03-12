package vn.t3h.java2109.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.t3h.java2109.model.ProductEntity;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {
    Optional<ProductEntity> findById(Integer id);
}
