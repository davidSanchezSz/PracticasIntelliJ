package tennisManager.view;

import java.util.Scanner;

public class TerminalView {
    private Scanner scanner = new Scanner(System.in);

    public String[] getArguments() {
        System.out.print(">");
        String[] arguments = scanner.nextLine().split(" ");
        return arguments;
    }

    public void showMessage(String message){
        System.out.println(message);
    }
}
