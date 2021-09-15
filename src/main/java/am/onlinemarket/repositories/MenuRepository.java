package am.onlinemarket.repositories;

import am.onlinemarket.models.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Long> {


    Optional<Menu> findByType(String type);

    List<Menu> findBySubType(String type);


    @Query("select distinct t.globalType from Menu t")
    List<Menu> findAllMenu();

//    List<Menu>  findDistinctMenuByGlobalType();


}
