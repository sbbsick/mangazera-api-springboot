package io.mangazera.mangaspringapi.controller;

import io.mangazera.mangaspringapi.domain.Author;
import io.mangazera.mangaspringapi.domain.Manga;
import io.mangazera.mangaspringapi.dto.AuthorDTO;
import io.mangazera.mangaspringapi.dto.MangaDTO;
import io.mangazera.mangaspringapi.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/authors")
public class AuthorController {

    private final AuthorService authorService;

    @GetMapping
    public ResponseEntity<Page<Author>> findAll(Pageable pageable) {
        Page<Author> authors = authorService.findAll(pageable);

        for (Author author : authors) {
            author.setMangasDto(MangaDTO.convertMangaListIntoMangaDtoList(author.getMangas()));
        }

        return ResponseEntity.ok().body(authors);
    }

    @GetMapping(path = "/id/{id}")
    public ResponseEntity<Author> findById(@PathVariable String id) {
        Author author = authorService.findById(id);
        author.setMangasDto(MangaDTO.convertMangaListIntoMangaDtoList(author.getMangas()));
        return ResponseEntity.ok().body(author);
    }

    @GetMapping(path = "/search/{name}")
    public ResponseEntity<Page<AuthorDTO>> findByNameContaining(Pageable pageable, @PathVariable String name) {
        Page<Author> authors = authorService.findByNameContaining(pageable, name);
        return ResponseEntity.ok().body(authors.map(AuthorDTO::convertAuthorIntoAuthorDto));
    }
}
