package basicClient;

import logic.UserService;
import lombok.RequiredArgsConstructor;

import java.util.Scanner;

@RequiredArgsConstructor
public class addUser implements menuEntry{

    private final UserService userService;

    @Override
    public void option() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Add Your nickname ,name ,surname separated by ','");
        String command = scanner.nextLine();
        String[] splitted = command.split(",");
        if(splitted.length == 3){
            userService.addUser(splitted[0],splitted[1],splitted[2],null);
        }else if (splitted.length == 4){
            userService.addUser(splitted[0],splitted[1],splitted[2],splitted[3]);
        }else {
            System.out.println("invalid argument");
        }
    }

    @Override
    public String menuEntryName() {
        return "Add User";
    }
}
