package basicClient;

import domain.User;
import logic.UserService;
import logic.UserServiceImpl;
import persistence.DBUserDAO;
import persistence.UserDAO;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class runner {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("spotify");
        UserDAO userDAO = new DBUserDAO(emf);

        UserService userService = new UserServiceImpl(userDAO);

        addUser addUser = new addUser(userService);
        deleteUser deleteUser = new deleteUser(userService);
        findUserByNickname findUserByNickname = new findUserByNickname(userService);
        List<menuEntry> userSubmenus = Stream.of(addUser,
                deleteUser,
                findUserByNickname).collect(Collectors.toList());

        subMenuEntry userMenu = new subMenuEntry("User", userSubmenus);

        subMenuEntry mainMenu = new subMenuEntry("Main Menu",
                Stream.of(userMenu).collect(Collectors.toList()));

        mainMenu.option();
    }
}
