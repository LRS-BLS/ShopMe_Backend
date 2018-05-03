package com.intive.shopme.category;

import com.intive.shopme.common.Validated;
import com.intive.shopme.model.db.DbCategory;
import com.intive.shopme.validation.AlreadyExistException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
class CategoryService extends Validated<DbCategory> {

    private final CategoryRepository repository;

    public CategoryService(CategoryRepository repository) {
        this.repository = repository;
    }

    List<DbCategory> getAll() {
        return repository.findAll();
    }

    DbCategory create(DbCategory dbCategory) {
        checkExistence(dbCategory);
        validate(dbCategory);
        return repository.save(dbCategory);
    }

    boolean checkCategoryExistenceByName(String name) {
        return repository.existsByName(name);
    }

    private void checkExistence(DbCategory dbCategory) {
        var foundByName = repository.findByName(dbCategory.getName());
        if (foundByName != null) {
            throw new AlreadyExistException(foundByName + " - name already exist");
        }
    }
}
