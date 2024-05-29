package homecast.controllers;

import homecast.configuration.ServerInfo;
import homecast.dto.ServerVideosDTO;
import homecast.services.VideoService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/video")
@AllArgsConstructor
public class VideoController {
    public final VideoService videoService;
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
}