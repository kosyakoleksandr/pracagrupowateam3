package basicClient;

import logic.UserService;
import lombok.RequiredArgsConstructor;

import java.util.Scanner;

@RequiredArgsConstructor
public class addPlaylistAutor implements menuEntry {

    private final UserService userService;

    @Override
    public void option() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Add Playlist:");
        System.out.println("Type PlaylistName and nickname separated by ','");
        String command = scanner.nextLine();
        String[] splitted = command.split(",");
        if (splitted.length == 2) {
            userService.addPlaylistAutor(splitted[0], splitted[1]);
        } else {
            System.out.println("Invalid arguments");
        }
    }


    @Override
    public String menuEntryName() {
        return "Add Playlist";
    }
}
