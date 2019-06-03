package com.socibby.repository;

import com.socibby.model.Category;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CategoryRepositoryImpl implements CategoryRepository {

    private final SessionFactory sessionFactory;

    @Autowired
    public CategoryRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    public Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }


    // "CATEGORY" tablosuna yeni bir kategori kaydediliyor.
    public void insertCategory(Category category) {
        Session session = getCurrentSession();
        session.persist(category);
    }

    // "CATEGORY" tablosundaki kategori bilgileri güncelleniyor.
    public void updateCategory(Category category) {
        Session session = getCurrentSession();
        session.merge(category);
    }

    // Kategori ismini parametre olarak alan bu metod, "CATEGORY" tablosunda bu gelen parametre ile ilgili satırı bulup,
    // Bize geriye Kategori nesnesini geri döndürüyor.
    public Category getCategoryByName(String name) {
        Session session = getCurrentSession();
        Query query = session.createQuery("FROM Category category WHERE category.name = :categoryName");
        query.setParameter("categoryName", name);
        return (Category) query.uniqueResult();
    }

    // Veritabanında bulunan tüm kategorileri getirir.
    public List<Category> getAllCategory() {
        Session session = getCurrentSession();
        Query query = session.createQuery("SELECT c FROM Category c");
        return query.list();
    }
}
