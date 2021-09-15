package am.onlinemarket.services.impl;

import am.onlinemarket.models.Menu;
import am.onlinemarket.repositories.MenuRepository;
import am.onlinemarket.services.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    MenuRepository menuRepository;


    @Override
    public Menu save(Menu menu) {

        return null;
    }

    @Override
    public List<Menu> findAllMenu() {
        return menuRepository.findAll();
    }

    @Override
    public Optional<Menu> findById(Long id) {
        return menuRepository.findById(id);
    }

    @Override
    public Optional<Menu> findByType(String type) {
        return menuRepository.findByType(type);
    }

    @Override
    public List<Menu> findBySubType(String type) {
        return menuRepository.findBySubType(type);
    }

    @Override
    public List<Menu> findByGlobalType() {
        return menuRepository.findAllMenu();
    }
}
