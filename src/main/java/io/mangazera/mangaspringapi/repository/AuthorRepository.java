package io.mangazera.mangaspringapi.repository;

import io.mangazera.mangaspringapi.domain.Author;
import io.mangazera.mangaspringapi.domain.Manga;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends MongoRepository<Author, String> {
}
