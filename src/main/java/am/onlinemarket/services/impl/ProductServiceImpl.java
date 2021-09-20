package am.onlinemarket.services.impl;

import am.onlinemarket.models.Product;
import am.onlinemarket.models.User;
import am.onlinemarket.repositories.ProductRepository;
import am.onlinemarket.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> findAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public Optional<Product> findByName(String productName) {
        return Optional.empty();
    }

    @Override
    public List<Product> findByType(String type) {
        return productRepository.findByCatalog_Type(type);
    }

    @Override
    public boolean deleteProduct(Long id) {
        if (findById(id).isPresent()){
            try {
                productRepository.deleteById(id);
                return true;
            }catch (Exception e){

            }
        }
        return false;
    }

}
