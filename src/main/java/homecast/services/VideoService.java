package homecast.services;

import homecast.dto.SourceDTO;
import homecast.dto.VideoDTO;
import homecast.models.Video;
import homecast.repositories.VideoRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
@AllArgsConstructor
public class VideoService {
    private static final Logger LOG = LoggerFactory.getLogger(VideoService.class);
    private final VideoRepository videoRepository;

    public List<VideoDTO> getAllVideos(){
        List<VideoDTO> videoDTOList = new LinkedList<>();
        for (Video video : videoRepository.findAll()) {
            videoDTOList.add(VideoDTO.builder()
                    .videoId(video.getVideoId())
                    .videoDirectoryId(video.getVideoDirectory().getVideoDirectoryId())
                    .episode(video.getEpisode())
                    .title(video.getTitle())
                    .thumbnail(video.getImage().getFilename())
                    .duration(video.getDuration())
                    .filename(video.getFilename())
                    .subtitle(video.getSubtitle())
                    .source(SourceDTO.create(video.getSource()))
                    .build());
        }
        LOG.info("Found " + videoDTOList.size() + " videos");
        return videoDTOList;
    }
}
