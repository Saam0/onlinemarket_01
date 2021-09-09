package am.onlinemarket.services.impl;

import am.onlinemarket.models.ProductCategory;
import am.onlinemarket.repositories.ProductCategoryRepository;
import am.onlinemarket.services.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {

    @Autowired
    ProductCategoryRepository productCategoryRepository;



    @Override
    public ProductCategory save(ProductCategory productCategory) {
        return productCategoryRepository.save(productCategory);
    }

    @Override
    public List<ProductCategory> findAllProductCategory() {
        return productCategoryRepository.findAll();
    }

    @Override
    public Optional<ProductCategory> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<ProductCategory> findByName(String productCategory) {
        return Optional.empty();
    }

    @Override
    public boolean deleteProductCategory(Long id) {
        return false;
    }
}
