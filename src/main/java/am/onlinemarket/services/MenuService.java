package am.onlinemarket.services;

import am.onlinemarket.models.Menu;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface MenuService {

    Menu save(Menu menu);
    List<Menu> findAllMenu();
    Optional<Menu> findById(Long id);
    Optional<Menu> findByType(String type);
    List<Menu> findBySubType(String type);
    List<Menu> findByGlobalType();
}
