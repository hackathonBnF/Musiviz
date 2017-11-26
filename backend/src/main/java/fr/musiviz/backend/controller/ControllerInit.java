package fr.musiviz.backend.controller;

import fr.musiviz.backend.db.entity.AudioRecord;
import fr.musiviz.backend.db.entity.Image;
import fr.musiviz.backend.db.repository.RepoAudioRecord;
import fr.musiviz.backend.db.repository.RepoImage;
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

    @Autowired
    RepoImage repoImage;

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
        //loadDataAudioRecord("audio_record_extract1_100.csv");
        loadDataAudioRecord("audio_record_extract1_6arks.csv");
        loadDataImage("image_extract1_6arks.csv");

//        AudioRecord ar = repoAudioRecord.findOne(new Long(26));
//
//        Image i1 = new Image();
//        i1.setAudioRecord(ar);
//        i1.setUrl("https://pics.me.me/bach-bach-bach-bach-bach-bach-bach-bach-11306906.png");
//
//        Image i2 = new Image();
//        i2.setAudioRecord(ar);
//        i2.setUrl("https://i.imgur.com/ciE6VdN.jpg");
//
//        repoImage.save(i1);
//        repoImage.save(i2);
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
                        ar.setCreators(strip(a[5]));
                        ar.setDroits(strip(a[6]));
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

    public void loadDataImage(String filename) {

        System.out.println("> Load csv " + filename);

        Path path = Paths.get(csvBase, filename);

        try (BufferedReader reader = Files.newBufferedReader(path)) {
            List<Image> list = reader.lines()
                    .map(l -> l.split(","))
                    .map(a -> {

                        String ark = a[0].replaceAll("http://gallica.bnf.fr/", "");
                        AudioRecord ar = repoAudioRecord.findByArk(ark);

                        Image i = new Image();

                        i.setAudioRecord(ar);
                        i.setUrl(a[1]);
                        i.setOriginArk(ark);

                        return i;
                    })
                    .collect(Collectors.toList());

            System.out.println("Items to load " + list.size());

            list.forEach(i -> {
                repoImage.save(i);
            });

            System.out.println("Loaded");
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("ERROR " + e.getMessage());
        }
    }
}
