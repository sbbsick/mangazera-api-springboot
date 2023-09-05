package io.mangazera.mangaspringapi.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.mangazera.mangaspringapi.dto.MangaDTO;
import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Document(collection = "authors")
public class Author implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    @NotBlank
    private String name;

    private String photo;

    @NotBlank
    private Date birthDate;

    @NotBlank
    private Date deathDate;

    @DBRef(lazy = true)
    @JsonIgnore
    List<Manga> mangas = new ArrayList<>();

    List<MangaDTO> mangasDto = new ArrayList<>();

    public Author() { }

    public Author(String id, String name, String photo, Date birthDate, Date deathDate) {
        this.id = id;
        this.name = name;
        this.photo = photo;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
    }


}
