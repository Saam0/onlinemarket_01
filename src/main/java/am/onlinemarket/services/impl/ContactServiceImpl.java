package am.onlinemarket.services.impl;

import am.onlinemarket.models.Contact;
import am.onlinemarket.repositories.ContactRepository;
import am.onlinemarket.services.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    ContactRepository contactRepository;



    @Override
    public Contact save(Contact contact) {

        return contactRepository.save(contact);
    }

    @Override
    public Optional<Contact> findById(Long id) {
        return Optional.empty();
    }
}
