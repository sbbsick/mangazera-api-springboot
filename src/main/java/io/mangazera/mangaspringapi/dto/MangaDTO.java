package io.mangazera.mangaspringapi.dto;

import io.mangazera.mangaspringapi.domain.Manga;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
public class MangaDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private String id;
    private String title;
    private String cover;

    public MangaDTO(Manga manga) {
        this.id = manga.getId();
        this.title = manga.getTitle();
        this.cover = manga.getCover();
    }

    public static MangaDTO convertMangaIntoMangaDto(Manga manga) {
        return new MangaDTO(manga);
    }
}
