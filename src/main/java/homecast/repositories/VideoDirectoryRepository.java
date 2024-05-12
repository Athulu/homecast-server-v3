package homecast.repositories;

import homecast.models.VideoDirectory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VideoDirectoryRepository extends CrudRepository<VideoDirectory, Long> {
    List<VideoDirectory> findAll();

    Optional<VideoDirectory> findVideoDirectoryByVideoDirectoryId(Long videoDirectoryId);
}
