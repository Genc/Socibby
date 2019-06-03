package com.socibby.repository;

import com.socibby.model.Organization;
import com.socibby.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrganizationRepositoryImpl implements OrganizationRepository {

    private final SessionFactory sessionFactory;

    @Autowired
    public OrganizationRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }


    // "ORGANIZATION" tablosuna yeni bir organizasyon kaydı atılıyor.
    public void insertOrganization(Organization organization) {
        Session session = getCurrentSession();
        session.persist(organization);
    }

    // "ORGANIZATION" tablosunda ilgili organizasyon bilgileri güncelleniyor.
    public void updateOrganization(Organization organization) {
        Session session = getCurrentSession();
        session.merge(organization);
    }

    // Id'si parametre olarak gelen organizasyon nesnesini bize geri döner.
    public Organization getOrganizationById(Long id) {
        Session session = getCurrentSession();
        Organization organization = session.find(Organization.class, id);
        return organization;
    }

    // Organizasyon kullanıcı adını parametre olarak kabul eden bu metod;
    // "ORGANIZATION" tablosunda ilgili nesneyi bulup bize geri dönüyor.
    public Organization getOrganization(String username) {
        Session session = getCurrentSession();
        Query query = session.createQuery("FROM Organization o WHERE o.username = :organizationUserName");
        query.setParameter("organizationUserName", username);
        return (Organization) query.uniqueResult();
    }

    /*
    Organizasyonun kullanıcı adı ve şifresini parametre olarak alan bu metod;
    "ORGANIZATION" tablosundan username ve password alanlarını kontrol ederek,
    Parametredeki bilgilerle eşlesen kayıtı geri dönderir.
     */
    public Organization validateOrganization(String username, String password) {
        Session session = getCurrentSession();
        Query query = session.createQuery("SELECT o FROM Organization o where o.username = :username AND o.password = :password");
        query.setParameter("username", username);
        query.setParameter("password", password);
        return (Organization) query.uniqueResult();
    }

    /*
     Kullanıcı nesnesini parametre olarak alan bu metod;
     "ORGANIZATION" ve "USER_CATEGORY" tablolarını JOIN'leyerek(birleştirerek) kullanıcının sahip olduğu kategorilere göre ve
     Kullanıcının ilçe ve il bilgilerine göre geriye "ORGANIZATION" Listesi dönüyor.
     */
    public List<Organization> getOrganizationByUser(User user) {
        Session session = getCurrentSession();

        String district = user.getDistrict();
        String city = user.getCity();
        Long id = user.getId();

        Query query = session.createQuery("SELECT o FROM Organization o, User u JOIN u.categorySet uc ON o.category.id = uc.id" +
                " WHERE o.district= : districtName AND o.city= :cityName AND u.id=:userId");
        query.setParameter("districtName", district);
        query.setParameter("cityName", city);
        query.setParameter("userId", id);
        return query.list();
    }

    /*
    Organizasyon nesnesini parametre olarak alıp,
    "ORGANIZATION" ve "CATEGORY" tablolarını joinleyerek ilçe, il, ülke ve ilgili kategoriye ait organizasyonları
    Liste şeklinde bizlere geri döner.
     */
    public List<Organization> getOrganizationByOrganization(Organization organization) {
        Session session = getCurrentSession();

        String district = organization.getDistrict();
        String city = organization.getCity();
        String categoryName = organization.getCategory().getName();

        Query query = session.createQuery("SELECT  o FROM  Organization o JOIN Category c ON o.category.id = c.id " +
                "WHERE o.district= : districtName AND o.city= :cityName AND c.name=: categoryName");

        query.setParameter("districtName", district);
        query.setParameter("cityName", city);
        query.setParameter("categoryName", categoryName);

        return query.list();
    }


    // "ORGANIZATION" ve "CATEGORY" Tablolarını joinleyerek, kategori ismine göre organizasyonları bize liste şekilde geri döner.
    public List<Organization> getOrganizationByCategoryName(String categoryName) {
        Session session = getCurrentSession();
        Query query = session.createQuery("SELECT o FROM Organization o JOIN Category c on o.category.id = c.id WHERE c.name = : categoryName");
        query.setParameter("categoryName", categoryName);
        return query.list();
    }
}
