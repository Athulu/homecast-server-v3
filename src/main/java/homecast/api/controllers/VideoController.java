package homecast.api.controllers;

import homecast.configuration.ServerInfo;
import homecast.api.dto.ServerVideosDTO;
import homecast.api.services.VideoDirectoryService;
import homecast.api.services.VideoService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/video")
@AllArgsConstructor
public class VideoController {
    public final VideoService videoService;
    public final VideoDirectoryService videoDirectoryService;
    public final ServerInfo serverInfo;

    @GetMapping("/all")
    public ResponseEntity<ServerVideosDTO> getVideos() {
        return ResponseEntity.ok().body(
                ServerVideosDTO.builder()
                        .serverUrl(serverInfo.getServerUrl())
                        .serverName(serverInfo.getHostName())
                        .videoDTOList(videoService.getAllVideos())
                        .build()
        );
    }

    @PutMapping("/add/path")
    public ResponseEntity<String> addPath(@RequestBody String path) {
        videoDirectoryService.addVideoDirectory(path);
        return ResponseEntity.ok().build();
    }
}