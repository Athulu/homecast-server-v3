package homecast.controllers;

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

    @GetMapping("/all")
    public ResponseEntity<ServerVideosDTO> getVideos() {
        //TODO:
        // set serverUrl
        // set serverName
        return ResponseEntity.ok().body(
                ServerVideosDTO.builder()
                        .serverUrl("serverUrl")
                        .serverName("serverName")
                        .videoDTOList(videoService.getAllVideos())
                        .build()
        );
    }
}