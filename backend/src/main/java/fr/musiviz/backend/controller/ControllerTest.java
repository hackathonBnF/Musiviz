package fr.musiviz.backend.controller;

import fr.musiviz.backend.db.entity.AudioRecord;
import fr.musiviz.backend.db.entity.Author;
import fr.musiviz.backend.db.repository.RepoAudioRecord;
import fr.musiviz.backend.db.repository.RepoAuthor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by kemkem on 11/25/17.
 */
@RestController
public class ControllerTest {

    @Autowired
    RepoAuthor repoAuthor;

    @Autowired
    RepoAudioRecord repoAudioRecord;

    private String strip(String s) {
        if(s.length() >= 255) {
            return s.substring(0, 255);
        }
        return s;
    }

//    @PostConstruct
//    public void loadData() {
//        URL url = this.getClass().getClassLoader().getResource("audio_record_extract1_100.csv");
//
//        try {
//            FileReader fr = new FileReader(url.getFile());
//            BufferedReader reader = new BufferedReader(fr);
//            List<AudioRecord> list = reader.lines()
//                    .map(l -> l.split("@"))
//                    .map(a -> {
//                        AudioRecord ar = new AudioRecord();
//
//                        ar.setArk(strip(a[0]));
//                        ar.setTitle(strip(a[1]));
//                        ar.setYear(strip(a[2]));
//                        ar.setSubject(strip(a[3]));
//                        ar.setCreators(strip(a[4]));
//                        ar.setDroits(strip(a[5]));
//                        return ar;
//                    })
//                    .collect(Collectors.toList());
//
//            System.out.println("list items " + list.size());
//
//            list.forEach(ar -> {
//                repoAudioRecord.save(ar);
//            });
//
//            System.out.println("Saved");
//
//        } catch (Exception e) {
//            System.err.println("ERROR loading file " + url);
//            System.err.println("Exception " + e.getMessage());
//        }
//    }



    @RequestMapping("/test")
    public ResponseEntity<String> test() {

//        Author a1 = new Author("debussy", "1233");
//        Author a2 = new Author("michel", "1766");
//
//        repoAuthor.save(a1);
//        repoAuthor.save(a2);

        loadData("audio_record_extract1_100.csv");

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

    @RequestMapping("/audiorecord/all")
    public ResponseEntity<List<AudioRecord>> allAudioRecord() {
        List<AudioRecord> list = repoAudioRecord.findAll();

        return ResponseEntity.ok(list);
    }

    @RequestMapping(value="/audiorecord/get/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AudioRecord> getAudioRecord(@PathVariable Long id) {
        AudioRecord audioRecord = repoAudioRecord.findOne(id);

        return ResponseEntity.ok(audioRecord);
    }


    @Value("${mv.csv.base}")
    private String csvBase;




    public void loadData(String filename) {

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

            System.out.println("list items " + list.size());

            list.forEach(ar -> {
                repoAudioRecord.save(ar);
            });

            System.out.println("Saved");
        } catch (IOException e) {
            e.printStackTrace();
        }


//        URL url = this.getClass().getClassLoader().getResource("audio_record_extract1_100.csv");
//
//        try {
//            FileReader fr = new FileReader(url.getFile());
//            BufferedReader reader = new BufferedReader(fr);
//
//
//        } catch (Exception e) {
//            System.err.println("ERROR loading file " + url);
//            System.err.println("Exception " + e.getMessage());
//        }
    }



//    @RequestMapping(value = "loadCsv", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, method = RequestMethod.POST)
//    public ResponseEntity<String> loadCsv(MultipartFile multipartFile) throws Exception {
//        InputStream inputStream = multipartFile.getInputStream();
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
//        this.loadData(bufferedReader);
//        return ResponseEntity.ok("loaded");
//    }

//    private void loadData(BufferedReader bufferedReader) {
//        try {
//
//            List<AudioRecord> list = bufferedReader.lines()
//                    .map(l -> l.split("@"))
//                    .map(a -> {
//                        AudioRecord ar = new AudioRecord();
//
//                        ar.setArk(strip(a[0]));
//                        ar.setTitle(strip(a[1]));
//                        ar.setYear(strip(a[2]));
//                        ar.setSubject(strip(a[3]));
//                        ar.setCreators(strip(a[4]));
//                        ar.setDroits(strip(a[5]));
//                        return ar;
//                    })
//                    .collect(Collectors.toList());
//
//            System.out.println("list items " + list.size());
//
//            list.forEach(ar -> {
//                repoAudioRecord.save(ar);
//            });
//
//            System.out.println("Saved");
//
//        } catch (Exception e) {
//            System.err.println("ERROR loading file");
//            System.err.println("Exception " + e.getMessage());
//        }
//    }

}
