package io.mangazera.mangaspringapi.dto;

import io.mangazera.mangaspringapi.domain.Author;
import lombok.Data;
import org.springframework.data.domain.Page;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class AuthorDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private String id;
    private String name;
    private String photo;

    public AuthorDTO() { }

    public AuthorDTO(Author author) {
        this.id = author.getId();
        this.name = author.getName();
        this.photo = author.getPhoto();
    }

    public static AuthorDTO convertAuthorIntoAuthorDto(Author author) {
        return new AuthorDTO(author);
    }

}
