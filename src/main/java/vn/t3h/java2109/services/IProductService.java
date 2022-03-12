package vn.t3h.java2109.services;

import vn.t3h.java2109.dto.ProductDTO;

import java.util.List;

public interface IProductService {
    List<ProductDTO> getAllProducts();

    boolean saveProduct(ProductDTO product);

    ProductDTO detailsProduct(int id);

    void deleteProduct(int product);
}
