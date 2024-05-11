package homecast.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Video {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long videoId;
    private String filename;
    private String title;
    private String episode;
    private String subtitle;
    private Integer duration;
    private LocalDateTime createdAt;
    private LocalDateTime lastUsedAt;
    @OneToOne
    @JoinColumn(name = "image_id")
    private Image image;
    @ManyToOne
    @JoinColumn(name = "video_directory_id")
    private VideoDirectory videoDirectory;
    @ManyToOne
    @JoinColumn(name = "source_id")
    private Source source;
}
