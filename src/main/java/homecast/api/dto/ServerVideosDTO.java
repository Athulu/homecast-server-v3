package homecast.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder(builderClassName = "Builder", access = AccessLevel.PUBLIC)
@AllArgsConstructor
@NoArgsConstructor
public class ServerVideosDTO {
    @JsonProperty("server_url")
    private String serverUrl;
    @JsonProperty("server_name")
    private String serverName;
    @JsonProperty("videos")
    private List<VideoDTO> videoDTOList;
}
