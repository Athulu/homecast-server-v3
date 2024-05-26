package homecast.dto;

import homecast.models.Source;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class SourceDTO {
    private String mime;
    private String type;

    public static SourceDTO create(Source source) {
        return new SourceDTO(source.getMime(), source.getType());
    }
}