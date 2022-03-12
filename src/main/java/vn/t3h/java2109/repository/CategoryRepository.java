package vn.t3h.java2109.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.t3h.java2109.model.CategoryEntity;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Integer> {
}
