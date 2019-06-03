package com.socibby.service;

import com.socibby.model.Category;

import java.util.List;

public interface CategoryService {

    void insertCategory(Category category);

    void updateCategory(Category category);

    Category getCategoryByName(String name);

    List<Category> getAllCategory();
}
