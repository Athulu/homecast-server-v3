package homecast.configuration;


import homecast.models.Setting;
import homecast.services.SettingService;
import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static homecast.configuration.FieldTypeEnum.STRING;

@Getter
public enum SettingProperty {
    DATABASE_USERNAME("DATABASE_USERNAME", STRING),
    DATABASE_PASSWORD("DATABASE_PASSWORD", STRING),
    DATABASE_DATASOURCE("DATABASE_DATASOURCE", STRING);

    private static final Logger LOG = LoggerFactory.getLogger(SettingProperty.class);
    private String property;
    private String value;
    private String description;

    SettingProperty(String name, FieldTypeEnum fieldTypeEnum) {
        //TODO: uzupełnić
    }
}
