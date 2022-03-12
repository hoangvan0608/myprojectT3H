package vn.t3h.java2109.services.Impl;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.t3h.java2109.dto.ProductDTO;
import vn.t3h.java2109.model.ProductEntity;
import vn.t3h.java2109.repository.ProductRepository;
import vn.t3h.java2109.services.IProductService;
import java.util.List;

@Service
public class ProductService implements IProductService {


    @Autowired
    ProductRepository productRepository;

    @Autowired
    ModelMapper modelMapper;


    @Override
    public List<ProductDTO> getAllProducts() {
        List<ProductEntity> list = productRepository.findAll();
        return modelMapper.map(list, new TypeToken<List<ProductDTO>>(){}.getType());
    }

    @Override
    public boolean saveProduct(ProductDTO product) {
        ProductEntity entity = modelMapper.map(product, new TypeToken<ProductEntity>(){}.getType());
        productRepository.save(entity);
        return  true;
    }

    @Override
    public ProductDTO detailsProduct(int id) {
           ProductEntity entity = productRepository.findById(id).get();
           return modelMapper.map(entity, new TypeToken<ProductDTO>(){}.getType());
    }

    @Override
    public void deleteProduct(int product) {
        productRepository.deleteById(product);
    }
}
