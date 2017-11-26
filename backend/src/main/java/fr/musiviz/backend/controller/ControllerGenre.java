package fr.musiviz.backend.controller;

import fr.musiviz.backend.db.entity.AudioRecord;
import fr.musiviz.backend.db.entity.Creator;
import fr.musiviz.backend.db.entity.Genre;
import fr.musiviz.backend.db.repository.RepoAudioRecord;
import fr.musiviz.backend.db.repository.RepoGenre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by kemkem on 11/25/17.
 */
@RestController
@RequestMapping("/genre")
public class ControllerGenre {
    @Autowired
    RepoAudioRecord repoAudioRecord;

    @Autowired
    RepoGenre repoGenre;

    @RequestMapping("/all")
    public ResponseEntity<List<Genre>> allGenre() {
        List<Genre> list = repoGenre.findAll();

        return ResponseEntity.ok(list);
    }

    @RequestMapping("/getByAudioRecord/{id}")
    public ResponseEntity<List<Genre>> getByAudioRecord(@PathVariable Long id) {

        AudioRecord ar = repoAudioRecord.findOne(id);

        List<Genre> list = repoGenre.getByAudioRecord(ar);

        return ResponseEntity.ok(list);
    }

}
