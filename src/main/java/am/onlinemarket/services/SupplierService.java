package am.onlinemarket.services;

import am.onlinemarket.models.Product;
import am.onlinemarket.models.Supplier;
import am.onlinemarket.models.User;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface SupplierService {


    Supplier save(Supplier supplier);
    Optional<Supplier> findById(Long id);
    Optional<Supplier> findByName(String supplierName);
    boolean deleteSupplier(Long id);
}
