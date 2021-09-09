package am.onlinemarket.services;

import am.onlinemarket.models.Product;
import am.onlinemarket.models.ProductCategory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ProductCategoryService {


    ProductCategory save(ProductCategory productCategory);
    List<ProductCategory> findAllProductCategory();
    Optional<ProductCategory> findById(Long id);
    Optional<ProductCategory> findByName(String productCategory);
    boolean deleteProductCategory(Long id);
}
