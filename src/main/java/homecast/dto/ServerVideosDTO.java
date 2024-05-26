package homecast.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

import java.util.List;

@Builder
public class ServerVideosDTO {
    @JsonProperty("server_url")
    private String serverUrl;
    @JsonProperty("server_name")
    private String serverName;
    @JsonProperty("videos")
    private List<VideoDTO> videoDTOList;
}
