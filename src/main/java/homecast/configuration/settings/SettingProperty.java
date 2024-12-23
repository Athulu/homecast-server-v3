package homecast.configuration.settings;


import homecast.configuration.settings.utility.TypeEnum;
import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static homecast.configuration.settings.utility.TypeEnum.STRING;

public enum SettingProperty {
    VIDEOS_DIRECTORY("VIDEOS_DIRECTORY", STRING),
    IMAGES_DIRECTORY("IMAGES_DIRECTORY", STRING),
    BASE_DIRECTORY("BASE_DIRECTORY", STRING);

    private static final Logger LOG = LoggerFactory.getLogger(SettingProperty.class);
    @Getter
    private final String property;
    @Getter
    private Object value;

    SettingProperty(String name, TypeEnum fieldTypeEnum) {
        this.property = name;
    }

    private void setValue(String value) {
        this.value = value;
    }

    public static void init(SettingProperty settingProperty, String value) {
        settingProperty.setValue(value);
        LOG.info(settingProperty.getProperty() + "\t:\t" + value);
    }
}
