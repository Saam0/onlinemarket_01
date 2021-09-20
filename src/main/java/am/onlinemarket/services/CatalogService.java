package am.onlinemarket.services;

import am.onlinemarket.models.Catalog;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface CatalogService {

    Catalog save(Catalog catalog);
    List<Catalog> findAllCatalog();
    Optional<Catalog> findById(Long id);
    Optional<Catalog> findByType(String type);
    List<Catalog> findBySubType(String type);
    List<Catalog> findByGlobalType();
}
