package vn.t3h.java2109.services;

import vn.t3h.java2109.dto.CategoryDTO;

import java.util.List;

public interface ICategoryService {
    List<CategoryDTO> getAllCategories();

    void saveCategory(CategoryDTO category);

    CategoryDTO getCategoryById(Integer id);
    void deleteCategoryById(Integer id);
}
