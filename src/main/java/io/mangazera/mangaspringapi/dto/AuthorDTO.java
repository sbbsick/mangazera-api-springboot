package io.mangazera.mangaspringapi.dto;

import io.mangazera.mangaspringapi.domain.Author;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
public class AuthorDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private String id;
    private String name;
    private String photo;

    public AuthorDTO(Author author) {
        this.id = author.getId();
        this.name = author.getName();
    }
}
