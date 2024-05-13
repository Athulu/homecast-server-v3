package homecast.services;

import homecast.models.Setting;
import homecast.repositories.SettingRepository;
import jakarta.persistence.EntityManager;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
@AllArgsConstructor
public class SettingService {
    private static final Logger LOG = LoggerFactory.getLogger(SettingService.class);
    private final EntityManager entityManager;
    private final SettingRepository settingRepository;
    private static HashSet<Setting> settingHashSet = new HashSet<>();

    public void initializeSettings(){
        LOG.info("Initializing settings");
        settingHashSet = new HashSet<>(settingRepository.findAll());
    }

    public static HashSet<Setting> getSettingHashSet(){
        return settingHashSet;
    }
}
