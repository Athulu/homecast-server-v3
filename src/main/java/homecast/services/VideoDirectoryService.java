package homecast.services;

import homecast.repositories.VideoDirectoryRepository;
import jakarta.persistence.EntityManager;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class VideoDirectoryService {
    private static final Logger LOG = LoggerFactory.getLogger(VideoDirectoryService.class);
    private final EntityManager entityManager;
    private final VideoDirectoryRepository videoDirectoryRepository;
}
