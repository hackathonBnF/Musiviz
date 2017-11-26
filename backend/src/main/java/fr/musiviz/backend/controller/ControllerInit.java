package fr.musiviz.backend.controller;

import fr.musiviz.backend.db.entity.*;
import fr.musiviz.backend.db.repository.*;
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
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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

    @Autowired
    RepoCreator repoCreator;

    @Autowired
    RepoGenre repoGenre;

    @Autowired
    RepoAudioMetaData repoAudioMetaData;

    @Value("${mv.csv.base}")
    private String csvBase;

    @Value("${mv.spectrum.url}")
    private String spectrumUrlBase;

    private String strip(String s) {
        if(s.length() >= 255) {
            s = s.substring(0, 255);
        }
        return s.replaceAll("\\\\", "");
    }

    @PostConstruct
    public void init() {
        System.out.println("--- INIT ---");
        //loadDataAudioRecord("audio_record_extract1_100.csv");
        loadDataAudioRecord("audio_record_extract2.csv");
        loadDataImage("image_extract1_6arks_hd.csv");
        loadDataMetaData("metadata_extract2.csv");

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

                        String ark = strip(a[0]);

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

                //add creator reference
                Arrays.asList(ar.getCreators().split("\\|")).forEach(c -> {

                    Pattern p = Pattern.compile("(.+)(\\(.+\\))\\.(.+)");
                    Matcher m = p.matcher(c);

                    if(m.matches()) {
                        String name = m.group(1);
                        String date = m.group(2);
                        String role = m.group(3);

                        Creator creator = new Creator();
                        creator.setAudioRecord(ar);
                        creator.setName(name);
                        creator.setRole(role);
                        creator.setDate(date);
                        repoCreator.save(creator);
                    }

                });

                //add genre reference
                Arrays.asList(ar.getSubject().split("\\|")).forEach(c -> {

                    Genre genre = new Genre();
                    genre.setAudioRecord(ar);
                    genre.setName(c);

                    repoGenre.save(genre);

                });

                //add audio meta
//                AudioMetaData amt = new AudioMetaData();
//                amt.setAudioRecord(ar);
//                amt.setBpm(Integer.toString(ThreadLocalRandom.current().nextInt(50, 150)));
//                amt.setNoise(Integer.toString(ThreadLocalRandom.current().nextInt(15, 99)));
//                amt.setDuration(Integer.toString(ThreadLocalRandom.current().nextInt(80, 400)));
//                amt.setUrlSpectrum("http://www.mp3-tech.org/tests/pm/RefCdAudioS.gif");
//                repoAudioMetaData.save(amt);
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
                        String title = a[2];
                        if(title.startsWith("http://commons.wikimedia.org")) {
                            i.setTitle("");
                        } else {
                            i.setTitle(a[2]);
                        }

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

    public void loadDataMetaData(String filename) {

        System.out.println("> Load csv " + filename);

        Path path = Paths.get(csvBase, filename);

        try (BufferedReader reader = Files.newBufferedReader(path)) {
            List<AudioMetaData> list = reader.lines()
                    .map(l -> l.split(","))
                    .map(a -> {

                        String ark = a[0];
                        String arkShort = ark.replaceAll("ark:/12148/", "");
                        AudioRecord ar = repoAudioRecord.findByArk(ark);

                        AudioMetaData amt = new AudioMetaData();
                        amt.setAudioRecord(ar);
                        amt.setBpm(a[1]);
                        amt.setNoise(Integer.toString(ThreadLocalRandom.current().nextInt(15, 99)));
                        amt.setDuration(a[2]);
                        amt.setUrlSpectrum(spectrumUrlBase + "/" + arkShort + ".jpg");
                        repoAudioMetaData.save(amt);

                        return amt;
                    })
                    .collect(Collectors.toList());

            System.out.println("Items to load " + list.size());

            list.forEach(i -> {
                repoAudioMetaData.save(i);
            });

            System.out.println("Loaded");
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("ERROR " + e.getMessage());
        }
    }
}
