package homecast.api.services;

import homecast.api.repositories.SourceRepository;
import jakarta.persistence.EntityManager;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SourceService {
    private static final Logger LOG = LoggerFactory.getLogger(SourceService.class);
    private final EntityManager entityManager;
    private final SourceRepository sourceRepository;
}
