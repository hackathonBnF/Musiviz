package fr.musiviz.backend.controller;

import fr.musiviz.backend.db.entity.AudioRecord;
import fr.musiviz.backend.db.repository.RepoAudioRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by kemkem on 11/25/17.
 */
@RestController
@RequestMapping("/audiorecord")
public class ControllerAudioRecord {
    @Autowired
    RepoAudioRecord repoAudioRecord;

    @RequestMapping("/all")
    public ResponseEntity<List<AudioRecord>> allAudioRecord() {
        List<AudioRecord> list = repoAudioRecord.findAll();

        return ResponseEntity.ok(list);
    }

    @RequestMapping(value="/get/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AudioRecord> getAudioRecord(@PathVariable Long id) {
        AudioRecord audioRecord = repoAudioRecord.findOne(id);

        return ResponseEntity.ok(audioRecord);
    }
}
