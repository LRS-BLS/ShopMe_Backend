package com.intive.shopme.user.registration;

import com.intive.shopme.validator.Validated;
import org.springframework.dao.DataRetrievalFailureException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional
class UserService extends Validated<User> {

    private final UserRepository repository;

    UserService(UserRepository repository) {
        this.repository = repository;
    }

    User createOrUpdate(User user) {
        if (!user.getInvoiceRequest()) {
            user.setInvoice(null);
        }
        validate(user);
        return repository.save(user);
    }

    User get(UUID id) {
        repository.getOne(id);
        return repository.findById(id)
                .orElseThrow(() -> new DataRetrievalFailureException("User with id: " + id + " not found"));
    }

    boolean findIfUserExist(String email) {
        if (repository.findUserByEmail(email) != null) return true;
        else return false;
    }
}
