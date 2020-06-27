package domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Data
@Getter
@Setter
public class Playlist {
    private String playlistId;
    private String trackTitle;
    private String trackAuthor;
    private String trackAlbum;

}