package logic;

import domain.Playlist;

import java.util.Set;

public interface PlaylistService {

    void addTrack(String trackTitle, String trackAuthor, String trackAlbum);

    void addCreator(String nickname, String playlistId);

    Playlist findById(String playlistId);

    void delete (String playlistId);

    Set<Playlist> findCreator(String playlistId);

}
