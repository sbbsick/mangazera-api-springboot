package io.mangazera.mangaspringapi.controller;

import io.mangazera.mangaspringapi.domain.Author;
import io.mangazera.mangaspringapi.dto.AuthorDTO;
import io.mangazera.mangaspringapi.service.AuthorService;
import io.mangazera.mangaspringapi.util.URL;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/authors")
public class AuthorController {

    private final AuthorService authorService;

    @GetMapping
    public ResponseEntity<Page<AuthorDTO>> findAllMangaDto(Pageable pageable) {
        Page<Author> authors = authorService.findAll(pageable);
        return ResponseEntity.ok().body(authors.map(AuthorDTO::convertAuthorIntoAuthorDto));
    }

    @GetMapping(path = "/search/{name}")
    public ResponseEntity<Page<AuthorDTO>> findByTitleContaining(Pageable pageable, @PathVariable String name) {
        name = URL.decodeParam(name);
        Page<Author> authors = authorService.findByNameContaining(pageable, name);
        return ResponseEntity.ok().body(authors.map(AuthorDTO::convertAuthorIntoAuthorDto));
    }

    @GetMapping(path = "/id/{id}")
    public ResponseEntity<AuthorDTO> findById(@PathVariable String id) {
        return ResponseEntity.ok().body(AuthorDTO.convertAuthorIntoAuthorDto(authorService.findById(id)));
    }
}
