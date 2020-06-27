package logic;

import domain.User;
import lombok.RequiredArgsConstructor;
import persistence.UserDAO;

import java.util.Set;

@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserDAO userDAO;

    @Override
    public void addUser(String id, String name, String surname, String playlistId) {
        User playlist = playlistId == null ? null : userDAO.findById(playlistId);
        User u = new User(id, name, surname, playlist);
        userDAO.save(u);
    }

    public void addPlaylistAutor(String playlistId, String userId) {
        User user = userDAO.findById(userId);
        User playlist = userDAO.findById(playlistId);
        user.setPlaylist(playlist);
        userDAO.update(user);
    }

    @Override
    public User findById(String userId) {
        return userDAO.findById(userId);
    }

    @Override
    public void delete(String playlist) {
        userDAO.delete(playlist);

    }
    @Override
    public Set<User> findPlaylistAutor(String playlistId) {
        return userDAO.findPlaylistAutor(playlistId);
    }
}
