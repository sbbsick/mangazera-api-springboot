package io.mangazera.mangaspringapi.domain;

import io.mangazera.mangaspringapi.dto.MangaDTO;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Data
@Document(collection = "chapters")
public class Chapter implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    @NotBlank
    private String title;

    @NotBlank
    private String mangaId;

    List<String> pages = new ArrayList<>();

    public Chapter() { }

    public Chapter(String id, String title, String mangaId) {
        this.id = id;
        this.title = title;
        this.mangaId = mangaId;
    }
}
