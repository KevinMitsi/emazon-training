package com.kevin.emazon.domain.api;

import com.kevin.emazon.domain.model.Category;


import java.util.Optional;


public interface ICategoryServicePort {
    Iterable<Category> getCategories();
    Optional<Category> getCategory(Long id);
    void saveCategory(Category category);
    void deleteCategory(Long id);
}
