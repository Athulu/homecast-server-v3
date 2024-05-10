package homecast.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Video {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long videoID;
    private String fileName;
    private String episode;
    private String title;
    @Column(length = 8192)
    private String subtitle;
    private String thumb;
    private String image480x270;
    private String image780x1200;
    private Integer duration;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "sourceID", unique = true)
    private Source sources;

    public Video(String fileName, String episode, String title, String subtitle, String thumb, String image480x270, String image780x1200, Integer duration, Source sources) {
        this.fileName = fileName;
        this.episode = episode;
        this.title = title;
        this.subtitle = subtitle;
        this.thumb = thumb;
        this.image480x270 = image480x270;
        this.image780x1200 = image780x1200;
        this.duration = duration;
        this.sources = sources;
    }
}
