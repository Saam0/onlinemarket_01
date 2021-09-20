package am.onlinemarket.services.impl;

import am.onlinemarket.repositories.CartItemRepository;
import am.onlinemarket.services.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartItemServiceImpl implements CartItemService {

    @Autowired
    CartItemRepository cartItemRepository;

 /*   @Override
    public CartItem save(CartItem cartItem) {
        return cartItemServiceRepository.save(cartItem);
    }

    @Override
    public Optional<CartItem> findById(Long id) {
        return cartItemServiceRepository.findById(id);
    }

    @Override
    public Optional<CartItem> findByCartId(Long id) {
        return cartItemServiceRepository.findByCartId(id);
    }
*/

}
