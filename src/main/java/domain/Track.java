package domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Track {
     private int id;
     private  String title;
     private String autor;
     private String album;
     private String genre;
     private TrackStatus trackStatus;
}