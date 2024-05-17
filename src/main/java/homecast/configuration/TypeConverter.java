package homecast.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.regex.Pattern;

public class TypeConverter {
    private static final Logger LOG = LoggerFactory.getLogger(TypeConverter.class);
    private static final Pattern INTEGER_PATTERN = Pattern.compile("-?\\d+");
    private static final Pattern BOOLEAN_PATTERN = Pattern.compile("(?i)true|false");

    public static Object convertStringToAppropriateType(String value) {
        if (INTEGER_PATTERN.matcher(value).matches()) {
            try {
                return Integer.parseInt(value);
            } catch (NumberFormatException e) {
                LOG.error(e.getMessage());
            }
        }

        if (BOOLEAN_PATTERN.matcher(value).matches()) {
            return Boolean.valueOf(value);
        }

        return value;
    }
}
