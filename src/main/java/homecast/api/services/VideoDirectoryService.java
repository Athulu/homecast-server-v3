package homecast.api.services;

import homecast.api.models.VideoDirectory;
import homecast.api.repositories.VideoDirectoryRepository;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class VideoDirectoryService {
    private static final Logger LOG = LoggerFactory.getLogger(VideoDirectoryService.class);
    private final EntityManager entityManager;
    private final VideoDirectoryRepository videoDirectoryRepository;

    public List<VideoDirectory> getEnabledVideoDirectoryList() {
        return videoDirectoryRepository.findAllByIsEnabled(true);
    }

    @Transactional
    public void addVideoDirectory(String path) {
        entityManager.persist(
                VideoDirectory.builder()
                        .path(path)
                        .isEnabled(true)
                        .createdAt(LocalDateTime.now())
                        .build()
        );
    }
}
