package com.devsuperior.movieflix.dto;

import com.devsuperior.movieflix.entities.Genre;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class GenreDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private long id;
    private String name;

    public GenreDTO() {
    }

    public GenreDTO(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public GenreDTO(Genre genre) {
        id = genre.getId();
        name = genre.getName();
    }
}
