package com.socibby.configuration;

import com.socibby.model.Category;
import com.socibby.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class InitializeSampleData implements ApplicationListener<ContextRefreshedEvent> {

    private CategoryService categoryService;

    @Autowired
    public InitializeSampleData(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {

        Category category1 = new Category("Sanat");
        Category category2 = new Category("Spor");
        Category category3 = new Category("Dans");
        Category category4 = new Category("Teknoloji");
        Category category5 = new Category("Fotoğrafçılık");
        Category category6 = new Category("Üretim");
        Category category7 = new Category("Oyun");
        Category category8 = new Category("Müzik");


        categoryService.insertCategory(category1);
        categoryService.insertCategory(category2);
        categoryService.insertCategory(category3);
        categoryService.insertCategory(category4);
        categoryService.insertCategory(category5);
        categoryService.insertCategory(category6);
        categoryService.insertCategory(category7);
        categoryService.insertCategory(category8);


    }


}
