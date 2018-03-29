package com.intive.shopme.validation;

import com.intive.shopme.model.Category;
import com.intive.shopme.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.UUID;

public class CategoryValidator implements ConstraintValidator<CategoryCheck, Category> {

    @Autowired
    CategoryService categoryService;

    @Override
    public void initialize(CategoryCheck constraintAnnotation) {
        categoryService = ServiceUtil.getCategoryService();
    }

    @Override
    public boolean isValid(Category value, ConstraintValidatorContext context) {
        UUID id = value.getId();
        return categoryService.getCategoryById(id) != null;
    }
}