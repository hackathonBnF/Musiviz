package fr.musiviz.backend.db.entity;

import javax.persistence.*;

/**
 * Created by kemkem on 11/25/17.
 */
@Entity
public class Image {
    private Long id;
    private String url;
    private String originArk;
    private AudioRecord audioRecord;

    public Image() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @ManyToOne
    public AudioRecord getAudioRecord() {
        return audioRecord;
    }

    public void setAudioRecord(AudioRecord audioRecord) {
        this.audioRecord = audioRecord;
    }

    public String getOriginArk() {
        return originArk;
    }

    public void setOriginArk(String originArk) {
        this.originArk = originArk;
    }
}
