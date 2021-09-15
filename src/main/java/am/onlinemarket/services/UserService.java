package am.onlinemarket.services;


import am.onlinemarket.models.User;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface UserService {

    User save(User user);
    Optional<User> findById(Long id);
    Optional<User> findByEmail(String email);
    Optional<User> findByLogin(String email);
    boolean deleteUser(Long id);


}
