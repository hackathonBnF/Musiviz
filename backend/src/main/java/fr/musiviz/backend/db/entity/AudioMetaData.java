package fr.musiviz.backend.db.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

/**
 * Created by kemkem on 11/25/17.
 */
@Entity
public class AudioMetaData {
    private Long id;
    private AudioRecord audioRecord;
    private String bpm;
    private String duration;
    private String noise;
    private String urlSpectrum;

    public AudioMetaData() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @JsonIgnore
    @ManyToOne
    public AudioRecord getAudioRecord() {
        return audioRecord;
    }

    public void setAudioRecord(AudioRecord audioRecord) {
        this.audioRecord = audioRecord;
    }

    public String getBpm() {
        return bpm;
    }

    public void setBpm(String bpm) {
        this.bpm = bpm;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getNoise() {
        return noise;
    }

    public void setNoise(String noise) {
        this.noise = noise;
    }

    public String getUrlSpectrum() {
        return urlSpectrum;
    }

    public void setUrlSpectrum(String urlSpectrum) {
        this.urlSpectrum = urlSpectrum;
    }
}
