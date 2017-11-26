package fr.musiviz.backend.controller;

import fr.musiviz.backend.db.entity.AudioMetaData;
import fr.musiviz.backend.db.entity.AudioRecord;
import fr.musiviz.backend.db.entity.Creator;
import fr.musiviz.backend.db.repository.RepoAudioMetaData;
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
@RequestMapping("/metadata")
public class ControllerAudioMetaData {
    @Autowired
    RepoAudioRecord repoAudioRecord;

    @Autowired
    RepoAudioMetaData audioMetaData;

    @RequestMapping("/all")
    public ResponseEntity<List<AudioMetaData>> allCreator() {
        List<AudioMetaData> list = audioMetaData.findAll();

        return ResponseEntity.ok(list);
    }

    @RequestMapping("/getByAudioRecord/{id}")
    public ResponseEntity<AudioMetaData> getByAudioRecord(@PathVariable Long id) {

        AudioRecord ar = repoAudioRecord.findOne(id);

        AudioMetaData mt = audioMetaData.getByAudioRecord(ar);

        return ResponseEntity.ok(mt);
    }

}
