package io.mangazera.mangaspringapi.service;

import io.mangazera.mangaspringapi.domain.Author;
import io.mangazera.mangaspringapi.domain.Manga;
import io.mangazera.mangaspringapi.exception.notfound.NotFoundException;
import io.mangazera.mangaspringapi.repository.AuthorRepository;
import io.mangazera.mangaspringapi.repository.MangaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthorService {
    private final AuthorRepository authorRepository;

    public Page<Author> findAll(Pageable pageable) {
        return authorRepository.findAll(pageable);
    }

    public Page<Author> findByNameContaining(Pageable pageable, String name) {
        return authorRepository.findByNameContainingIgnoreCase(pageable, name);
    }

    public Author findById(String id) {
        return authorRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Author with ID: %s not found".formatted(id)));
    }
}
