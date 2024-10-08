package com.kevin.emazon.infraestructure.adapter;

import com.kevin.emazon.domain.model.Category;
import com.kevin.emazon.domain.spi.ICategoryPersistentPort;
import com.kevin.emazon.infraestructure.mapper.ICategoryEntityMapper;
import com.kevin.emazon.infraestructure.repositories.CategoryRepository;
import com.kevin.emazon.infraestructure.util.PageableCreator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Component
public class CategoryJpaAdapter implements ICategoryPersistentPort {
    private final ICategoryEntityMapper categoryEntityMapper;
    private final CategoryRepository categoryRepository;


    @Override
    @Transactional(readOnly = true)
    public List<Category> getCategories(String order, Integer pageNumber, Integer pageSize) {
        return categoryRepository.findAll(PageableCreator.createPageable(order, pageNumber, pageSize))
                .map(categoryEntityMapper::toCategory).getContent();
    }

    @Override
    @Transactional
    public void saveCategory(Category category) {
        categoryRepository.save(categoryEntityMapper.toCategoryEntity(category));
    }


    @Override
    @Transactional(readOnly = true)
    public boolean existByNameIgnoreCase(String name){
        return categoryRepository.existsByNameIgnoreCase(name);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Category> findByName(String name) {
        return categoryRepository.findByNameIgnoreCase(name).map(categoryEntityMapper::toCategory);
    }


}
