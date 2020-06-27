package persistence;

import domain.User;

import java.util.Set;

public interface UserDAO {
    User findById(String userId);

    void save(User u);

    void update(User user);

    void delete(String userId);

    Set<User> findPlaylistAutor(String playlistId);
}

