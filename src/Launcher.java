import java.util.Scanner;

public class Launcher {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println("Bonjour, devinez la commande");

        String cmd = scan.nextLine();
        if (!cmd.equals("quit")) {
            System.out.println("Unknown command");
        }
    }
}
