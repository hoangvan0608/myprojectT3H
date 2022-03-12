package vn.t3h.java2109.services.Impl;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.t3h.java2109.dto.CategoryDTO;
import vn.t3h.java2109.model.CategoryEntity;
import vn.t3h.java2109.repository.CategoryRepository;
import vn.t3h.java2109.services.ICategoryService;
import java.util.List;


@Service
public class CategoryService implements ICategoryService {

    @Autowired
    CategoryRepository category;
    @Autowired
    ModelMapper model;

    @Override
    public List<CategoryDTO> getAllCategories() {
        List<CategoryEntity> categories = category.findAll();
        return model.map(categories, new TypeToken<List<CategoryDTO>>(){}.getType());
    }

    @Override
    public void saveCategory(CategoryDTO categoryDTO) {
        category.save(model.map(categoryDTO, new TypeToken<CategoryEntity>(){}.getType()));
    }

    @Override
    public CategoryDTO getCategoryById(Integer id) {
        return model.map(category.findById(id).get(),CategoryDTO.class);
    }

    @Override
    public void deleteCategoryById(Integer id) {
        category.deleteById(id);
    }


}
