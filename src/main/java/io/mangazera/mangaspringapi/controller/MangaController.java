package io.mangazera.mangaspringapi.controller;

import io.mangazera.mangaspringapi.domain.Manga;
import io.mangazera.mangaspringapi.dto.AuthorDTO;
import io.mangazera.mangaspringapi.dto.MangaDTO;
import io.mangazera.mangaspringapi.service.MangaService;
import io.mangazera.mangaspringapi.util.URL;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/mangas")
public class MangaController {

    private final MangaService mangaService;

    @GetMapping
    public ResponseEntity<Page<MangaDTO>> findAllMangaDto(Pageable pageable) {
        Page<Manga> mangas = mangaService.findAllButOnlyReturnIdNameAndCover(pageable);
        return ResponseEntity.ok().body(mangas.map(MangaDTO::convertMangaIntoMangaDto));
    }

    @GetMapping(path = "/search/{title}")
    public ResponseEntity<Page<MangaDTO>> findByTitleContaining(Pageable pageable, @PathVariable String title) {
        title = URL.decodeParam(title);
        Page<Manga> mangas = mangaService.findByTitleContaining(pageable, title);
        return ResponseEntity.ok().body(mangas.map(MangaDTO::convertMangaIntoMangaDto));
    }

    @GetMapping(path = "/id/{id}")
    public ResponseEntity<Manga> findById(@PathVariable String id) {
        return ResponseEntity.ok().body(mangaService.findById(id));
    }

    @PostMapping(path = "/insert")
    public ResponseEntity<MangaDTO> insert(@RequestBody Manga manga) {
        manga = mangaService.insert(manga);
        MangaDTO mangaDto = MangaDTO.convertMangaIntoMangaDto(manga);
        return ResponseEntity.status(HttpStatus.CREATED).body(mangaDto);
    }
}
