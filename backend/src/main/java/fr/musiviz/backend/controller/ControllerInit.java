package fr.musiviz.backend.controller;

import fr.musiviz.backend.db.entity.AudioRecord;
import fr.musiviz.backend.db.repository.RepoAudioRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by kemkem on 11/25/17.
 */
@RestController
@RequestMapping("/init")
public class ControllerInit {

    @Autowired
    RepoAudioRecord repoAudioRecord;

    @Value("${mv.csv.base}")
    private String csvBase;

    private String strip(String s) {
        if(s.length() >= 255) {
            return s.substring(0, 255);
        }
        return s;
    }

    @PostConstruct
    public void init() {
        System.out.println("--- INIT ---");
        loadDataAudioRecord("audio_record_extract1_100.csv");
    }

    public void loadDataAudioRecord(String filename) {

        System.out.println("> Load csv " + filename);

        Path path = Paths.get(csvBase, filename);

        try (BufferedReader reader = Files.newBufferedReader(path)) {
            List<AudioRecord> list = reader.lines()
                    .map(l -> l.split("@"))
                    .map(a -> {
                        AudioRecord ar = new AudioRecord();

                        ar.setArk(strip(a[0]));
                        ar.setTitle(strip(a[1]));
                        ar.setYear(strip(a[2]));
                        ar.setSubject(strip(a[3]));
                        ar.setCreators(strip(a[4]));
                        ar.setDroits(strip(a[5]));
                        return ar;
                    })
                    .collect(Collectors.toList());

            System.out.println("Items to load " + list.size());

            list.forEach(ar -> {
                repoAudioRecord.save(ar);
            });

            System.out.println("Loaded");
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("ERROR " + e.getMessage());
        }
    }
}
