package fr.musiviz.backend.db.repository;

import fr.musiviz.backend.db.entity.AudioRecord;
import fr.musiviz.backend.db.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by kemkem on 11/25/17.
 */
@Repository
public interface RepoGenre extends JpaRepository<Genre, Long>{
    List<Genre> getByAudioRecord(AudioRecord record);
}
