package homecast.services;

import homecast.models.Setting;
import homecast.repositories.SettingRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
@AllArgsConstructor
public class SettingService {
    private static final Logger LOG = LoggerFactory.getLogger(SettingService.class);
    private final SettingRepository settingRepository;

    public HashSet<Setting> getAllSettings() {
        return new HashSet<>(settingRepository.findAll());
    }
}
