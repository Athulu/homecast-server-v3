package homecast.api.services;

import homecast.api.repositories.ImageRepository;
import jakarta.persistence.EntityManager;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ImageService {
    private static final Logger LOG = LoggerFactory.getLogger(ImageService.class);
    private final EntityManager entityManager;
    private final ImageRepository imageRepository;
}
