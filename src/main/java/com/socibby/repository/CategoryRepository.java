package com.socibby.repository;

import com.socibby.model.Category;

import java.util.List;

public interface CategoryRepository {

    void insertCategory(Category category);

    void updateCategory(Category category);

    Category getCategoryByName(String name);

    List<Category> getAllCategory();

}
