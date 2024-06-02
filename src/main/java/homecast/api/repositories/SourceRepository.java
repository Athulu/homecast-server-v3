package homecast.api.repositories;

import homecast.api.models.Source;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SourceRepository extends CrudRepository<Source, Long> {
    List<Source> findAll();

    Optional<Source> findSourceBySourceId(Long sourceId);
}
