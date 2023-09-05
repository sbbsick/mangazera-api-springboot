package io.mangazera.mangaspringapi.dto;

import io.mangazera.mangaspringapi.domain.Author;
import lombok.Data;

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
    private Date birthDate;
    private Date deathDate;

    List<MangaDTO> mangas = new ArrayList<>();

    public AuthorDTO(Author author) {
        this.id = author.getId();
        this.name = author.getName();
        this.photo = author.getPhoto();
        this.birthDate = author.getBirthDate();
        this.deathDate = author.getDeathDate();
        this.mangas = MangaDTO.convertMangaListIntoMangaDtoList(author.getMangas());
    }

    public static AuthorDTO convertAuthorIntoAuthorDto(Author author) {
        return new AuthorDTO(author);
    }


}
