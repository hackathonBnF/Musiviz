package fr.musiviz.backend.db.repository;

import fr.musiviz.backend.db.entity.AudioRecord;
import fr.musiviz.backend.db.entity.Creator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by kemkem on 11/25/17.
 */
@Repository
public interface RepoCreator extends JpaRepository<Creator, Long>{
    List<Creator> getByAudioRecord(AudioRecord record);
}
