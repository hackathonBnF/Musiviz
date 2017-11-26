package fr.musiviz.backend.controller;

import fr.musiviz.backend.db.entity.AudioRecord;
import fr.musiviz.backend.db.entity.Image;
import fr.musiviz.backend.db.repository.RepoAudioRecord;
import fr.musiviz.backend.db.repository.RepoImage;
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
@RequestMapping("/image")
public class ControllerImage {
    @Autowired
    RepoImage repoImage;

    @Autowired
    RepoAudioRecord repoAudioRecord;

    @RequestMapping("/all")
    public ResponseEntity<List<Image>> allAudioRecord() {
        List<Image> list = repoImage.findAll();

        return ResponseEntity.ok(list);
    }

    @RequestMapping(value="/getByAudioRecord/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Image>> getByAudioRecord(@PathVariable Long id) {

        AudioRecord audioRecord = repoAudioRecord.findOne(id);
        List<Image> list = repoImage.getByAudioRecord(audioRecord);

        return ResponseEntity.ok(list);
    }

    @RequestMapping(value="/getByArk/{ark}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Image>> getByArk(@PathVariable String ark) {
        List<Image> list = repoImage.getByOriginArk("ark:/12148/" + ark);

        return ResponseEntity.ok(list);
    }
}
