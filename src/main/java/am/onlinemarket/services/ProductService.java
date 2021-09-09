package am.onlinemarket.services;

import am.onlinemarket.models.Product;
import am.onlinemarket.models.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ProductService {

    Product save(Product product);
    List<Product> findAllProducts();
    Optional<Product> findById(Long id);
    Optional<Product> findByName(String productName);
    Optional<Product> findByCategory(String category);
    boolean deleteProduct(Long id);

}
