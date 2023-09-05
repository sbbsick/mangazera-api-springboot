package io.mangazera.mangaspringapi.service;

import io.mangazera.mangaspringapi.domain.Manga;
import io.mangazera.mangaspringapi.dto.MangaDTO;
import io.mangazera.mangaspringapi.exception.badrequest.BadRequestException;
import io.mangazera.mangaspringapi.exception.notfound.NotFoundException;
import io.mangazera.mangaspringapi.repository.MangaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MangaService {
    private final MangaRepository mangaRepository;


    public Page<Manga> findAllButOnlyReturnIdNameAndCover(Pageable pageable) {
        return mangaRepository.findAll(pageable);
    }

    public Page<Manga> findByTitleContaining(Pageable pageable, String title) {
        return mangaRepository.findByTitleContainingIgnoreCase(pageable, title);
    }

    public Manga findById(String id) {
        return mangaRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Manga with ID: %s not found".formatted(id)));
    }

    @Transactional
    public Manga insert(Manga manga) {
        if(manga.getId() != null) {
            throw new BadRequestException("When creating a new manga the ID must be null");
        }
        return mangaRepository.insert(manga);
    }

    //ToDo -> Implementar update e delete
    //ToDo -> Tratar exceções
}
