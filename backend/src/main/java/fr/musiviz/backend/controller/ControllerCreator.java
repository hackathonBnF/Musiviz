package fr.musiviz.backend.controller;

import fr.musiviz.backend.db.entity.AudioRecord;
import fr.musiviz.backend.db.entity.Creator;
import fr.musiviz.backend.db.repository.RepoAudioRecord;
import fr.musiviz.backend.db.repository.RepoCreator;
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
@RequestMapping("/creator")
public class ControllerCreator {
    @Autowired
    RepoAudioRecord repoAudioRecord;

    @Autowired
    RepoCreator repoCreator;

    @RequestMapping("/all")
    public ResponseEntity<List<Creator>> allCreator() {
        List<Creator> list = repoCreator.findAll();

        return ResponseEntity.ok(list);
    }

    @RequestMapping("/getByAudioRecord/{id}")
    public ResponseEntity<List<Creator>> getByAudioRecord(@PathVariable Long id) {

        AudioRecord ar = repoAudioRecord.findOne(id);

        List<Creator> list = repoCreator.getByAudioRecord(ar);

        return ResponseEntity.ok(list);
    }

}
