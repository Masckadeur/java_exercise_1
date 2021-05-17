import java.util.Scanner;

public class Launcher {
    public static void main(String[] args) {

        System.out.println("Bonjour, devinez la commande");

        while(true) {
            Scanner scan = new Scanner(System.in);

            String cmd = scan.nextLine();
            if (cmd.equals("quit")) {
                break;
            }
            System.out.println("Unknown command");
        }
    }
}