package io.mangazera.mangaspringapi.dto;

import io.mangazera.mangaspringapi.domain.Manga;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Data
public class MangaDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private String id;
    private String title;
    private String cover;
    private Boolean isFinished;

    public MangaDTO(Manga manga) {
        this.id = manga.getId();
        this.title = manga.getTitle();
        this.cover = manga.getCover();
        this.isFinished = manga.getIsFinished();
    }

    public static MangaDTO convertMangaIntoMangaDto(Manga manga) {
        return new MangaDTO(manga);
    }

    public static List<MangaDTO> convertMangaListIntoMangaDtoList(List<Manga> mangas) {
        return mangas.stream().map(MangaDTO::new).toList();
    }
}
