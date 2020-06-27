package basicClient;

import domain.User;
import logic.UserService;
import lombok.RequiredArgsConstructor;

import java.util.Scanner;

@RequiredArgsConstructor
public class findUserByNickname implements menuEntry{
    private final UserService userService;

    @Override
    public void option() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Find User by Nickname:");
        System.out.println("Type user nickname you like to find");
        String command =scanner.nextLine();
        User user = userService.findById(command);
    }

    @Override
    public String menuEntryName() {
        return null;
    }
}
