package homecast.configuration.settings.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SettingChangeNotifyModel {
    @JsonProperty("operation")
    private String operation;
    @JsonProperty("property")
    private String property;
    @JsonProperty("value")
    private String value;
    @JsonProperty("description")
    private String description;

    @Override
    public String toString() {
        return "property=" + property + ", value=" + value + ", description=" + description;
    }
}
