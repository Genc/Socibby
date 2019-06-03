package com.socibby.service;

import com.socibby.model.Category;
import com.socibby.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public void insertCategory(Category category) {
        categoryRepository.insertCategory(category);
    }

    public void updateCategory(Category category) {
        categoryRepository.updateCategory(category);
    }

    public Category getCategoryByName(String name) {
        return categoryRepository.getCategoryByName(name);
    }

    public List<Category> getAllCategory() {
        return categoryRepository.getAllCategory();
    }
}
