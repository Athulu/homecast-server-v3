package homecast;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.stereotype.Controller
@RequestMapping("/endpoint")
@AllArgsConstructor
public class TestController {

    @GetMapping("/test")
    public String getVideos() {
        return "test";
    }
}