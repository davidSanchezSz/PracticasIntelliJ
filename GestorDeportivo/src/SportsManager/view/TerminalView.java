package SportsManager.view;

import java.util.Scanner;

public class TerminalView {
    private Scanner scanner = new Scanner(System.in);

    public String[] getCommand() {
        System.out.print(">");
        String[] arguments = scanner.nextLine().split(" ");
        return arguments;
    }

}