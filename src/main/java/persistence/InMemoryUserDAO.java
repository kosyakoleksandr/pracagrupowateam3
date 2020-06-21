package persistence;

import domain.User;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class InMemoryUserDAO implements UserDAO{

    private Map<String, User> users = new HashMap<>();

    @Override
    public User findById(String userId) {
        return users.get(userId);
    }

    @Override
    public void save(User u) { users.put(u.getId(), u);
    }

    @Override
    public void update(User u) { users.put(u.getId(), u);

    }

    @Override
    public void delete(String userId) { users.remove(userId);

    }

    @Override
    public Set<User> findPlaylistAutor(String playlistId) {
        return users.values().stream()
                .filter(u -> u.getPlaylist() != null && u.getPlaylist().getId().equals(playlistId))
                .collect(Collectors.toSet());
    }
}
