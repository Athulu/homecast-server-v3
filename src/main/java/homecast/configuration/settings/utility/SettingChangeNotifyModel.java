package homecast.configuration.settings.utility;

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
    @JsonProperty("old_property")
    private String oldProperty;
    @JsonProperty("new_property")
    private String newProperty;
    @JsonProperty("old_value")
    private String oldValue;
    @JsonProperty("new_value")
    private String newValue;
    @JsonProperty("old_description")
    private String oldDescription;
    @JsonProperty("new_description")
    private String newDescription;

    public String toStringOldModel() {
        return "SettingChangeNotifyModel{" +
                "operation='" + operation + '\'' +
                ", oldProperty='" + oldProperty + '\'' +
                ", oldValue='" + oldValue + '\'' +
                ", oldDescription='" + oldDescription + '\'' +
                '}';
    }

    public String toStringNewModel() {
        return "SettingChangeNotifyModel{" +
                "operation='" + operation + '\'' +
                ", newProperty='" + newProperty + '\'' +
                ", newValue='" + newValue + '\'' +
                ", newDescription='" + newDescription + '\'' +
                '}';
    }
}
