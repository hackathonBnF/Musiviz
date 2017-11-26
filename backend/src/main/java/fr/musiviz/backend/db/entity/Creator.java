package fr.musiviz.backend.db.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

/**
 * Created by kemkem on 11/25/17.
 */
@Entity
public class Creator {
    private Long id;
    private AudioRecord audioRecord;
    private String name;
    private String date;
    private String role;

    public Creator() {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
