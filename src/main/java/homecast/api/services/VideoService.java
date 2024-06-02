package homecast.api.services;

import homecast.api.dto.SourceDTO;
import homecast.api.dto.VideoDTO;
import homecast.api.models.Video;
import homecast.api.models.VideoDirectory;
import homecast.api.repositories.VideoRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.DirectoryIteratorException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

@Service
@AllArgsConstructor
public class VideoService {
    private static final Logger LOG = LoggerFactory.getLogger(VideoService.class);
    private final VideoRepository videoRepository;
    private final VideoDirectoryService videoDirectoryService;

    public static void main(String[] args) {
        Path dirPath = Paths.get("C:\\HomeCast\\mp4\\");

        try (Stream<Path> paths = Files.walk(dirPath, 1)) {
            List<String> fileNames = paths
                    .filter(Files::isRegularFile)
                    .map(Path::getFileName)
                    .map(Path::toString)
                    .toList();
            fileNames.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void updateVideosData() {
        List<VideoDirectory> videoDirectoryList = videoDirectoryService.getEnabledVideoDirectoryList();
        List<Video> videoList = new LinkedList<>();
        for (VideoDirectory videoDirectory : videoDirectoryList) {
            getVideoNamesForDirectory(videoDirectory);
        }
    }

    private List<String> getVideoNamesForDirectory(VideoDirectory videoDirectory) {
        List<String> videoNameList = new LinkedList<>();
        Path dirPath = Paths.get(videoDirectory.getPath());
        try (Stream<Path> paths = Files.walk(dirPath, 1)) {
            videoNameList = paths
                    .filter(Files::isRegularFile)
                    .map(Path::getFileName)
                    .map(Path::toString)
                    .toList();

            videoNameList.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return videoNameList;
    }

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
