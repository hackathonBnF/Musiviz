package fr.musiviz.backend.controller;

import fr.musiviz.backend.db.entity.Author;
import fr.musiviz.backend.db.repository.RepoAuthor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by kemkem on 11/25/17.
 */
@RestController
public class ControllerTest {

    @Autowired
    RepoAuthor repoAuthor;

    @RequestMapping("/test")
    public ResponseEntity<String> test() {

        Author a1 = new Author("debussy", "1233");
        Author a2 = new Author("michel", "1766");

        repoAuthor.save(a1);
        repoAuthor.save(a2);

        return ResponseEntity.ok("hello musiviz");
    }

    @RequestMapping("/author/all")
    public ResponseEntity<List<Author>> authorAll() {

        List<Author> list = repoAuthor.findAll();

        return ResponseEntity.ok(list);
    }

    @RequestMapping("/author/{name}")
    public ResponseEntity<List<Author>> author(@PathVariable String name) {

        List<Author> list = repoAuthor.getAuthorByName(name);

        return ResponseEntity.ok(list);
    }


}
