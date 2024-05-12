package homecast.services;

import homecast.repositories.VideoRepository;
import jakarta.persistence.EntityManager;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class VideoService {
    private static final Logger LOG = LoggerFactory.getLogger(VideoService.class);
    private final EntityManager entityManager;
    private final VideoRepository videoRepository;
}
