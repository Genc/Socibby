package com.socibby.repository;

import com.socibby.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private final SessionFactory sessionFactory;

    @Autowired
    public UserRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    // "USER" tablosuna yeni bir kullanıcı kaydı atılıyor.
    public void insertUser(User user) {
        Session session = getCurrentSession();
        session.persist(user);
    }

    // "USER" tablosunda var olan kullanıcının bilgileri güncelleniyor.
    public void updateUser(User user) {
        Session session = getCurrentSession();
        session.merge(user);
    }

    // Id'si parametre olarak gelen kullanıcı nesnesini bize geri döner.
    public User getUserById(Long id) {
        Session session = getCurrentSession();
        User user = session.find(User.class, id);
        return user;
    }

    /*
    Kullanıcı sisteme giriş yaparken veritabanından "USER" tablosunda kullanıcı adı ve şifresi alanları
    kotrol edilir ve parametre gelen gelen değerler eşleşme durumundaysa geri kullanıcı doğrulanır.
     */
    public User validateUser(String username, String password) {
        Session session = getCurrentSession();
        Query query = session.createQuery("SELECT u FROM User u WHERE u.username = :username AND u.password = : password");
        query.setParameter("username", username);
        query.setParameter("password", password);
        return (User) query.uniqueResult();
    }
}
