package logic;

import domain.User;

import java.util.Set;

public interface UserService {

    void addUser(String id, String name, String surname, String playlistId);

    void addPlaylistAutor(String playlistId, String userId);

    User findById(String userId);

    void delete(String userId);

    Set<User> findPlaylistAutor(String playlistId);
}
