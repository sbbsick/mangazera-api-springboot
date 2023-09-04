package io.mangazera.mangaspringapi.domain;
import io.mangazera.mangaspringapi.dto.AuthorDTO;
import io.mangazera.mangaspringapi.dto.MangaDTO;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Document(collection = "mangas")
public class Manga implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    @NotBlank
    private String title;

    @NotBlank
    private String cover;

    @NotBlank
    private String description;

    @NotBlank
    private Integer chaptersTotal;

    @NotBlank
    private Date releaseDate;

    private Date finishDate;

    @NotBlank
    private Boolean isFinished;

    @DBRef(lazy = true)
    List<Author> authors = new ArrayList<>();

    @DBRef(lazy = true)
    List<Chapter> chapters = new ArrayList<>();

    public Manga() { }

    public Manga(String id, String title, String cover, String description, Integer chaptersTotal, Date releaseDate, Date finishDate, Boolean isFinished) {
        this.id = id;
        this.title = title;
        this.cover = cover;
        this.description = description;
        this.chaptersTotal = chaptersTotal;
        this.releaseDate = releaseDate;
        this.finishDate = finishDate;
        this.isFinished = isFinished;
    }


}
