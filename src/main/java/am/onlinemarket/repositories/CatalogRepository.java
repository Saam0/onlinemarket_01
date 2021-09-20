package am.onlinemarket.repositories;

import am.onlinemarket.models.Catalog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CatalogRepository extends JpaRepository<Catalog, Long> {


    Optional<Catalog> findByType(String type);

    List<Catalog> findBySubType(String type);


    @Query("select distinct t.globalType from Catalog t")
    List<Catalog> findAllMenu();

//    List<Menu>  findDistinctMenuByGlobalType();


}
