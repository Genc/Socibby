package com.socibby.model;

import javax.persistence.*;

@Entity
@Table(name = "PHOTO")
public class Photo {

    @Id
    @SequenceGenerator(name = "photo_id_sequence", sequenceName = "PHOTO_ID_SEQUENCE", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "photo_id_sequence")
    @Column(name = "ID")
    private Long id;

    @Column(name = "PATH")
    private String path;

    public Photo() {
    }

    public Photo(String path) {
        this.path = path;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return "Photo{" +
                "id=" + id +
                ", path='" + path + '\'' +
                '}';
    }
}
