package fr.musiviz.backend.data.response;

import fr.musiviz.backend.db.entity.AudioMetaData;
import fr.musiviz.backend.db.entity.AudioRecord;
import fr.musiviz.backend.db.entity.Creator;
import fr.musiviz.backend.db.entity.Genre;

import java.util.List;

/**
 * Created by kemkem on 11/26/17.
 */
public class ResponseAudioRecord {
    private AudioRecord audioRecord;
    private List<Creator> listCreator;
    private List<Genre> listGenre;
    private AudioMetaData audioMetaData;
    private int imageCount;

    public static ResponseAudioRecord init() {
        return new ResponseAudioRecord();
    }


    public AudioRecord getAudioRecord() {
        return audioRecord;
    }

    public ResponseAudioRecord withAudioRecord(AudioRecord audioRecord) {
        this.audioRecord = audioRecord;
        return this;
    }

    public List<Creator> getListCreator() {
        return listCreator;
    }

    public ResponseAudioRecord withListCreator(List<Creator> listCreator) {
        this.listCreator = listCreator;
        return this;
    }

    public List<Genre> getListGenre() {
        return listGenre;
    }

    public ResponseAudioRecord withListGenre(List<Genre> listGenre) {
        this.listGenre = listGenre;
        return this;
    }

    public AudioMetaData getAudioMetaData() {
        return audioMetaData;
    }

    public ResponseAudioRecord withAudioMetaData(AudioMetaData audioMetaData) {
        this.audioMetaData = audioMetaData;
        return this;
    }

    public int getImageCount() {
        return imageCount;
    }

    public ResponseAudioRecord withImageCount(int imageCount) {
        this.imageCount = imageCount;
        return this;
    }
}
