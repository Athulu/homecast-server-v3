package homecast.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder(builderClassName = "Builder", access = AccessLevel.PUBLIC)
@NoArgsConstructor
@AllArgsConstructor
public class VideoDTO {
    @JsonProperty("video_id")
    private Long videoId;
    @JsonProperty("video_directory_id")
    private Long videoDirectoryId;
    @JsonProperty("episode")
    private String episode;
    @JsonProperty("title")
    private String title;
    @JsonProperty("subtitle")
    private String subtitle;
    @JsonProperty("thumbnail")
    private String thumbnail;
    @JsonProperty("duration")
    private Integer duration;
    @JsonProperty("filename")
    private String filename;
    @JsonProperty("source")
    private SourceDTO source;
}
