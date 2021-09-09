package am.onlinemarket.services.impl;

import am.onlinemarket.models.Supplier;
import am.onlinemarket.repositories.SupplierRepository;
import am.onlinemarket.services.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class SupplierServiceImpl implements SupplierService {

    @Autowired
    SupplierRepository supplierRepository;


    @Override
    public Supplier save(Supplier supplier) {
        return supplierRepository.save(supplier);
    }

    @Override
    public Optional<Supplier> findById(Long id) {
        return supplierRepository.findById(id);
    }

    @Override
    public Optional<Supplier> findByName(String supplierName) {
        return supplierRepository.findBySupplierName(supplierName);
    }

    @Override
    public boolean deleteSupplier(Long id) {
        if (findById(id).isPresent()){
            supplierRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
