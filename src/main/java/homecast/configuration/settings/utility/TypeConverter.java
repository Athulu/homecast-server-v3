package homecast.configuration.settings.utility;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.regex.Pattern;

@Component
public class TypeConverter {
    private static final Logger LOG = LoggerFactory.getLogger(TypeConverter.class);
    private static final Pattern INTEGER_PATTERN = Pattern.compile("-?\\d+");
    private static final Pattern BOOLEAN_PATTERN = Pattern.compile("(?i)true|false");

    public static TypeEnum getType(String value) {
        if (INTEGER_PATTERN.matcher(value).matches()) return TypeEnum.INTEGER;
        else if (BOOLEAN_PATTERN.matcher(value).matches()) return TypeEnum.BOOLEAN;
        else return TypeEnum.STRING;
    }
}


