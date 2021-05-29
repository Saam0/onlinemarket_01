package am.onlinemarket.services;

import am.onlinemarket.models.Contact;
import am.onlinemarket.models.User;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface ContactService {

    Contact save(Contact contact);
    Optional<Contact> findById(Long id);

}
