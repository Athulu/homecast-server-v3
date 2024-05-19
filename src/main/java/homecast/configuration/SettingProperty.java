package homecast.configuration;


import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

import static homecast.configuration.TypeEnum.*;

public enum SettingProperty {
    DATABASE_USERNAME("DATABASE_USERNAME", STRING),
    DATABASE_PASSWORD("DATABASE_PASSWORD", STRING),
    DATABASE_DATASOURCE("DATABASE_DATASOURCE", STRING);

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
