package am.onlinemarket.services.impl;

import am.onlinemarket.exceptions.UserAlreadyExistException;
import am.onlinemarket.models.Role;
import am.onlinemarket.models.User;
import am.onlinemarket.repositories.ContactRepository;
import am.onlinemarket.repositories.RoleRepository;
import am.onlinemarket.repositories.UserRepository;
import am.onlinemarket.services.UserService;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Date;
import java.util.Optional;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    ContactRepository contactRepository;


//    @Autowired
//    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public User save(User user) {

        if (findByEmail(user.getEmail()).isPresent()){
            throw new UserAlreadyExistException("There is an account with that email address: " + user.getEmail());
        }

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setStatus(true);
        user.setRegDate(new Date());
        user.setRoles(roleRepository.findByRoleName("ROLE_USER"));

        return userRepository.save(user);
    }

//    private boolean emailExists(String email){
//        return userRepository.findByEmail(email)!=null;
//    }


        @Override
    public Optional<User> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public Optional<User> findByLogin(String email) {
        return Optional.empty();
    }

    @Override
    public boolean deleteUser(Long id) {
        return false;
    }
}
