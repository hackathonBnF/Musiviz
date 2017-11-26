package fr.musiviz.backend.db.repository;

import fr.musiviz.backend.db.entity.AudioMetaData;
import fr.musiviz.backend.db.entity.AudioRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by kemkem on 11/25/17.
 */
@Repository
public interface RepoAudioMetaData extends JpaRepository<AudioMetaData, Long>{
    AudioMetaData getByAudioRecord(AudioRecord audioRecord);
}
