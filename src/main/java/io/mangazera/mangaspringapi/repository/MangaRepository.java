package io.mangazera.mangaspringapi.repository;

import io.mangazera.mangaspringapi.domain.Manga;
import io.mangazera.mangaspringapi.dto.MangaDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MangaRepository extends MongoRepository<Manga, String> {
    Page<Manga>  findByTitleContainingIgnoreCase(Pageable pageable, String title);
}
