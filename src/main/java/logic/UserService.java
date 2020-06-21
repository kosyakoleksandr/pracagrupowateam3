package logic;

import domain.User;

public interface UserService {
    void addUser(String name, String id, String surname);

    User findById(String userId);

    void delete(String userId);

}
