package com.socibby.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "ORGANIZATION")
public class Organization {

    @Id
    @SequenceGenerator(
            name = "organization_id_sequence",
            sequenceName = "ORG_ID_SEQUENCE",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "organization_id_sequence")
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME")
    @NotBlank(message = "{organization.name.notBlank}")
    private String name;

    @Column(name = "USERNAME")
    @NotBlank(message = "{organization.username.notBlank}")
    private String username;

    @Column(name = "PASSWORD")
    @NotBlank(message = "{organization.password.notBlank}")
    private String password;

    @Column(name = "EMAIL")
    @NotBlank(message = "{organization.email.notBlank}")
    private String email;

    @Column(name = "ABOUT", columnDefinition = "TEXT")
    @NotBlank(message = "{organization.about.notBlank}")
    private String about;

    @Column(name = "AUTHORIZED_PERSON")
    @NotBlank(message = "{organization.authorizedPerson.notBlank}")
    private String authorizedPerson;

    @Column(name = "ADDRESS_DESCRIPTION")
    @NotBlank(message = "{organization.addressDescription.notBlank}")
    private String addressDescription;

    @Column(name = "DISTRICT")
    @NotBlank(message = "{organization.district.notBlank}")
    private String district;

    @Column(name = "CITY")
    @NotBlank(message = "{organization.city.notBlank}")
    private String city;

    @Column(name = "COUNTRY")
    @NotBlank(message = "{organization.country.notBlank}")
    private String country;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "CONTACT_ID", foreignKey = @ForeignKey(name = "FK_ORG_CONTACT"))
    private Contact contact;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            joinColumns = @JoinColumn(name = "ORGANIZATION_ID"),
            inverseJoinColumns = @JoinColumn(name = "PHOTO_ID")
    )
    private Set<Photo> photoSet = new LinkedHashSet<Photo>();

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "CATEGORY_ID", foreignKey = @ForeignKey(name = "FK_ORG_CATEGORY"))
    private Category category;

    public Organization() {
    }

    public Organization(String name, String username, String password, String email, String about, String authorizedPerson, String addressDescription, String district, String city, String country) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.email = email;
        this.about = about;
        this.authorizedPerson = authorizedPerson;
        this.addressDescription = addressDescription;
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

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getAuthorizedPerson() {
        return authorizedPerson;
    }

    public void setAuthorizedPerson(String authorizedPerson) {
        this.authorizedPerson = authorizedPerson;
    }

    public String getAddressDescription() {
        return addressDescription;
    }

    public void setAddressDescription(String addressDescription) {
        this.addressDescription = addressDescription;
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

    public Set<Photo> getPhotoSet() {
        return photoSet;
    }

    public void setPhotoSet(Set<Photo> photoSet) {
        this.photoSet = photoSet;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    @Override
    public String toString() {
        return "Organization{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", about='" + about + '\'' +
                ", authorizedPerson='" + authorizedPerson + '\'' +
                ", addressDescription='" + addressDescription + '\'' +
                ", district='" + district + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", contact=" + contact +
                ", photoSet=" + photoSet +
                ", category=" + category +
                '}';
    }
}
