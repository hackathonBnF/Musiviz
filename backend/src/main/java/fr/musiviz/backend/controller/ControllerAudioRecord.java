package fr.musiviz.backend.controller;

import fr.musiviz.backend.data.response.ResponseAudioRecord;
import fr.musiviz.backend.data.response.ResponseImageList;
import fr.musiviz.backend.db.entity.AudioRecord;
import fr.musiviz.backend.db.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by kemkem on 11/25/17.
 */
@RestController
@RequestMapping("/audiorecord")
public class ControllerAudioRecord {
    @Autowired
    RepoAudioRecord repoAudioRecord;

    @Autowired
    RepoCreator repoCreator;

    @Autowired
    RepoGenre repoGenre;

    @Autowired
    RepoAudioMetaData repoAudioMetaData;

    @Autowired
    RepoImage repoImage;

    @RequestMapping("/all")
    public ResponseEntity<List<ResponseAudioRecord>> allAudioRecord() {
        List<AudioRecord> list = repoAudioRecord.findAll();

        List<ResponseAudioRecord> res = list.stream()
                .map(ar -> {
                    return mapResponseAudioRecord(ar);
                })
                .collect(Collectors.toList());


        return ResponseEntity.ok(res);
    }

    @RequestMapping(value="/get/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseAudioRecord> getAudioRecord(@PathVariable Long id) {
        AudioRecord audioRecord = repoAudioRecord.findOne(id);

        return ResponseEntity.ok(mapResponseAudioRecord(audioRecord));
    }

    private ResponseAudioRecord mapResponseAudioRecord(AudioRecord audioRecord) {
        //SALE ! pas le temps
        int countImage = repoImage.getByAudioRecord(audioRecord).size();

        ResponseAudioRecord responseAudioRecord = ResponseAudioRecord.init()
                .withAudioRecord(audioRecord)
                .withListCreator(repoCreator.getByAudioRecord(audioRecord))
                .withListGenre(repoGenre.getByAudioRecord(audioRecord))
                .withAudioMetaData(repoAudioMetaData.getByAudioRecord(audioRecord))
                .withImageCount(countImage);

        return responseAudioRecord;
    }

}
