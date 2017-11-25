package fr.musiviz.backend.db.repository;

import fr.musiviz.backend.db.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by kemkem on 11/25/17.
 */
@Repository
public interface RepoAuthor extends JpaRepository<Author, Long>{
    List<Author> getAuthorByName(String name);
}
