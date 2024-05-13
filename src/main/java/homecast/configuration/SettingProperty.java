package homecast.configuration;


import homecast.models.Setting;
import homecast.services.SettingService;
import lombok.Getter;

@Getter
public enum SettingProperty {
    DATABASE_USERNAME("DATABASE_USERNAME"),
    DATABASE_PASSWORD("DATABASE_PASSWORD"),
    DATABASE_DATASOURCE("DATABASE_DATASOURCE");

    private String property;
    private String value;
    private String description;

    SettingProperty(String property) {
        for (Setting setting : SettingService.getSettingHashSet()) {
            initSetting(setting);
        }
    }

    private void initSetting(Setting setting) {
        this.property = setting.getProperty();
        this.value = setting.getValue();
        this.description = setting.getDescription();
    }
}
