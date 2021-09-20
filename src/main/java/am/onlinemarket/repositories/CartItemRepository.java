package am.onlinemarket.repositories;

import am.onlinemarket.models.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Long> {

//    Optional<CartItem> findByCartId(Long id);
}
