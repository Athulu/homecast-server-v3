package homecast.api.services;

import homecast.configuration.settings.SettingProperty;
import homecast.api.models.Setting;
import homecast.api.repositories.SettingRepository;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class SettingService {
    private static final Logger LOG = LoggerFactory.getLogger(SettingService.class);
    private final SettingRepository settingRepository;

    public List<Setting> getAllSettingList() {
        return settingRepository.findAll();
    }

    public HashMap<String, String> getAllSettingHashMap() {
        return new HashMap<>(getAllSettingList().stream()
                .collect(Collectors.toMap(Setting::getProperty, Setting::getValue)));
    }

    @PostConstruct
    public void initializeSettings() {
        LOG.info("START initialize settings");
        for (SettingProperty settingProperty : SettingProperty.values()) {
            SettingProperty.init(settingProperty, getAllSettingHashMap().get(settingProperty.name()));
        }
        LOG.info("END initialize settings");
    }
    public void initializeSetting(String property, String value) {
        SettingProperty.init(SettingProperty.valueOf(property), value);
    }
}
