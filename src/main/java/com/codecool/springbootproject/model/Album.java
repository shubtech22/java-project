package com.codecool.springbootproject.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", updatable=false, nullable=false)
    private int id;

    @Column(name="name")
    private String name;

    @Column(name="description")
    private String description;

    @OneToMany(mappedBy="album", cascade= CascadeType.ALL, orphanRemoval=true)
    private Set<SongAlbum> songAlbum;

    public Album(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Album() {
    }
}
