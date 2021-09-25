package am.onlinemarket.services.impl;

import am.onlinemarket.models.CartItem;
import am.onlinemarket.repositories.CartItemRepository;
import am.onlinemarket.services.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CartItemServiceImpl implements CartItemService {

    @Autowired
    CartItemRepository cartItemRepository;

    @Override
    public CartItem save(CartItem cartItem) {
        return cartItemRepository.save(cartItem);
    }

    @Override
    public Optional<CartItem> findById(Long id) {
        return cartItemRepository.findById(id);
    }

//    @Override
//    public Optional<CartItem> findByCartItemId(Long id) {
//        return cartItemRepository.findByCartItemId(id);
//    }

}
