package com.socibby.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "USER")
public class User {

    @Id
    @SequenceGenerator(
            name = "user_id_sequence",
            sequenceName = "USER_ID_SEQUENCE",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_id_sequence")
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME", length = 100)
    @NotBlank(message = "{user.name.notBlank}")
    private String name;

    @Column(name = "SURNAME", length = 100)
    @NotBlank(message = "{user.surname.notBlank}")
    private String surname;

    @Column(name = "USERNAME", length = 50)
    @NotBlank(message = "{user.username.notBlank}")
    private String username;

    @Column(name = "PASSWORD")
    @NotBlank(message = "{user.password.notBlank}")
    private String password;

    @Column(name = "EMAIL")
    @NotBlank(message = "{user.email.notBlank}")
    private String email;

    @Column(name = "DISTRICT")
    @NotBlank(message = "{user.district.notBlank}")
    private String district;

    @Column(name = "CITY")
    @NotBlank(message = "{user.city.notBlank}")
    private String city;

    @Column(name = "COUNTRY")
    @NotBlank(message = "{user.country.notBlank}")
    private String country;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "PHOTO_ID", foreignKey = @ForeignKey(name = "FK_USER_PHOTO"))
    private Photo photo;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "USER_CATEGORY",
            joinColumns = @JoinColumn(name = "USER_ID"),
            inverseJoinColumns = @JoinColumn(name = "CATEGORY_ID")
    )
    @NotEmpty(message = "{user.category.notBlank}")
    private Set<Category> categorySet = new LinkedHashSet<Category>();

    public User() {
    }

    public User(String name, String surname, String username, String password, String email, String district, String city, String country) {
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.password = password;
        this.email = email;
        this.district = district;
        this.city = city;
        this.country = country;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Photo getPhoto() {
        return photo;
    }

    public void setPhoto(Photo photo) {
        this.photo = photo;
    }

    public Set<Category> getCategorySet() {
        return categorySet;
    }

    public void setCategorySet(Set<Category> categorySet) {
        this.categorySet = categorySet;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", district='" + district + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", photo=" + photo +
                ", categorySet=" + categorySet +
                '}';
    }
}

