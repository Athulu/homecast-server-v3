package homecast.schedule;

import homecast.api.services.SettingService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
@AllArgsConstructor
public class TimerTasks {
    private static final Logger LOG = LoggerFactory.getLogger(TimerTasks.class);
    private final SettingService settingService;

    @Scheduled(fixedRate = 60000)
    public void initializeSettings() {
        LOG.info("settings initialized");
        settingService.initializeSettings();
    }
}
