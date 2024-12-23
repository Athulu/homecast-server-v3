package homecast.api.controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/settings")
@AllArgsConstructor
public class SettingsController {

    @PostMapping("/reload")
    public ResponseEntity<String> reloadSettings() {
        return ResponseEntity.ok().body("settings reloaded");
    }
}
