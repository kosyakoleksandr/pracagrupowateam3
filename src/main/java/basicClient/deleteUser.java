package basicClient;

import domain.User;
import logic.UserService;
import lombok.RequiredArgsConstructor;

import java.util.Scanner;

@RequiredArgsConstructor
public class deleteUser implements menuEntry{

    private final UserService userService;

    @Override
    public void option() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Delete:");
        System.out.println("Type nickname to delete it");
        String command = scanner.nextLine();
        userService.delete(command);
        System.out.println("I hope you will get back to our application soon ;)");
    }

    @Override
    public String menuEntryName() {
        return "Delete user ";
    }
}
