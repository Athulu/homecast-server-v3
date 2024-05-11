package homecast.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
public class VideoDirectory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long videoDirectoryId;
    private String path;
    private Boolean isEnabled;
    private LocalDateTime createdAt;
}