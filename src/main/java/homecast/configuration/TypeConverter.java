package homecast.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.regex.Pattern;

import static homecast.configuration.TypeEnum.*;

@Component
public class TypeConverter {
    private static final Logger LOG = LoggerFactory.getLogger(TypeConverter.class);
    private static final Pattern INTEGER_PATTERN = Pattern.compile("-?\\d+");
    private static final Pattern BOOLEAN_PATTERN = Pattern.compile("(?i)true|false");

    public static TypeEnum getType(String value) {
        if (INTEGER_PATTERN.matcher(value).matches()) return INTEGER;
        else if (BOOLEAN_PATTERN.matcher(value).matches()) return BOOLEAN;
        else return STRING;
    }

    //TODO: konwersja value z bazy danych do odpowiedniego typu
//    public Object convertStringToDestinyType(String value) {
//        try {
//            return Integer.parseInt(value);
//        } catch (NumberFormatException e) {
//            LOG.error(e.getMessage());
//        }
//        if (BOOLEAN_PATTERN.matcher(value).matches()) {
//            return Boolean.valueOf(value);
//        }
//        return value;
//    }
}


