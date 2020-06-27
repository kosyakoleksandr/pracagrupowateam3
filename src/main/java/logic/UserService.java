package logic;

import domain.User;

import java.util.Set;

public interface UserService {

    void addUser(String nickname, String name, String surname, String playlistId);

    void addPlaylistAutor(String playlistId, String nickname);

    User findById(String nickname);

    void delete(String playlist);

    Set<User> findPlaylistAutor(String playlistId);
}
