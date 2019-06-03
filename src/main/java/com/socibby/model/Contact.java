package com.socibby.model;

import javax.persistence.*;

@Entity
@Table(name = "CONTACT")
public class Contact {

    @Id
    @SequenceGenerator(
            name = "contact_id_sequence",
            sequenceName = "CONTACT_ID_SEQUENCE",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "contact_id_sequence")
    @Column(name = "ID")
    private Long id;

    @Column(name = "FACEBOOK_USERNAME")
    private String facebookUsername;

    @Column(name = "TWITTER_USERNAME")
    private String twitterUsername;

    @Column(name = "INSTAGRAM_USERNAME")
    private String instagramUsername;

    @Column(name = "YOUTUBE_USERNAME")
    private String youtubeUsername;

    @Column(name = "PHONE_NUMBER1")
    private String phoneNumber1;

    @Column(name = "PHONE_NUMBER2")
    private String phoneNumber2;

    @Column(name = "WEBSITE_LINK")
    private String websiteLink;

    public Contact() {
    }

    public Contact(String facebookUsername, String twitterUsername, String instagramUsername, String youtubeUsername, String phoneNumber1, String phoneNumber2, String websiteLink) {
        this.facebookUsername = facebookUsername;
        this.twitterUsername = twitterUsername;
        this.instagramUsername = instagramUsername;
        this.youtubeUsername = youtubeUsername;
        this.phoneNumber1 = phoneNumber1;
        this.phoneNumber2 = phoneNumber2;
        this.websiteLink = websiteLink;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFacebookUsername() {
        return facebookUsername;
    }

    public void setFacebookUsername(String facebookUsername) {
        this.facebookUsername = facebookUsername;
    }

    public String getTwitterUsername() {
        return twitterUsername;
    }

    public void setTwitterUsername(String twitterUsername) {
        this.twitterUsername = twitterUsername;
    }

    public String getInstagramUsername() {
        return instagramUsername;
    }

    public void setInstagramUsername(String instagramUsername) {
        this.instagramUsername = instagramUsername;
    }

    public String getYoutubeUsername() {
        return youtubeUsername;
    }

    public void setYoutubeUsername(String youtubeUsername) {
        this.youtubeUsername = youtubeUsername;
    }

    public String getPhoneNumber1() {
        return phoneNumber1;
    }

    public void setPhoneNumber1(String phoneNumber1) {
        this.phoneNumber1 = phoneNumber1;
    }

    public String getPhoneNumber2() {
        return phoneNumber2;
    }

    public void setPhoneNumber2(String phoneNumber2) {
        this.phoneNumber2 = phoneNumber2;
    }

    public String getWebsiteLink() {
        return websiteLink;
    }

    public void setWebsiteLink(String websiteLink) {
        this.websiteLink = websiteLink;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "id=" + id +
                ", facebookUsername='" + facebookUsername + '\'' +
                ", twitterUsername='" + twitterUsername + '\'' +
                ", instagramUsername='" + instagramUsername + '\'' +
                ", youtubeUsername='" + youtubeUsername + '\'' +
                ", phoneNumber1='" + phoneNumber1 + '\'' +
                ", phoneNumber2='" + phoneNumber2 + '\'' +
                ", websiteLink='" + websiteLink + '\'' +
                '}';
    }
}
