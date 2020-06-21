package logic;

import domain.User;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    @Override
    public void addUser(String id, String name, String surname) {
        User playlist = userId == null ? null : userDAO.findById(userId);
        User user = new User(id, name, surname, playlist);
        userDAO.save(user);
    }

    @Override
    public User findById(String userId) {
        return userDAO.findById(userId);
    }

    @Override
    public void delete(String userId) {
        userDAO.delete(userId);

    }
}
