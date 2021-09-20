package am.onlinemarket.services.impl;

import am.onlinemarket.models.Catalog;
import am.onlinemarket.repositories.CatalogRepository;
import am.onlinemarket.services.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CatalogServiceImpl implements CatalogService {

    @Autowired
    CatalogRepository catalogRepository;


    @Override
    public Catalog save(Catalog catalog) {

        return null;
    }

    @Override
    public List<Catalog> findAllCatalog() {
        return catalogRepository.findAll();
    }

    @Override
    public Optional<Catalog> findById(Long id) {
        return catalogRepository.findById(id);
    }

    @Override
    public Optional<Catalog> findByType(String type) {
        return catalogRepository.findByType(type);
    }

    @Override
    public List<Catalog> findBySubType(String type) {
        return catalogRepository.findBySubType(type);
    }

    @Override
    public List<Catalog> findByGlobalType() {
        return catalogRepository.findAllMenu();
    }
}
