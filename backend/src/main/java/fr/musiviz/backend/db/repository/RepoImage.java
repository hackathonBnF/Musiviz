package fr.musiviz.backend.db.repository;

import fr.musiviz.backend.db.entity.AudioRecord;
import fr.musiviz.backend.db.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by kemkem on 11/25/17.
 */
@Repository
public interface RepoImage extends JpaRepository<Image, Long>{
    List<Image> getByAudioRecord(AudioRecord audioRecord);
    List<Image> getByOriginArk(String originArk);
}
