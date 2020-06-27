package basicClient;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Scanner;

@RequiredArgsConstructor
public class subMenuEntry implements menuEntry {

    private final String name;
    private final List<menuEntry> submenus;

    @Override
    public void option() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(name);
        for (;;) {
            System.out.println(printOptions());
            String choice = scanner.nextLine();
            if ("b".equals(choice)) {
                break;
            } else {
                int option = getOptionIndex(choice);
                if (option >= 0) {
                    submenus.get(option).option();
                } else {
                    System.out.println("Invalid Choice");
                }
            }
        }
    }

    private int getOptionIndex(String choice) {
        try {
            int option = Integer.parseInt(choice);
            if (option < submenus.size()) {
                return option;
            } else {
                return -1;
            }
        } catch (NumberFormatException e){
            return -1;
        }
    }

    private String printOptions(){
        StringBuilder sb = new StringBuilder();
        sb.append("b-for go back\n");
        for(int i=0 ; i<submenus.size(); i++){
            sb.append(i).append(" - ").append(submenus.get(i).menuEntryName()).append("\n");
        }
        return sb.toString();

    }

    @Override
    public String menuEntryName(){ return name;}
}
