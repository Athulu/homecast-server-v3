package homecast.api.repositories;

import homecast.api.models.Video;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VideoRepository extends CrudRepository<Video, Long> {
    List<Video> findAll();

    Optional<Video> findVideoByVideoId(Integer videoId);
}
