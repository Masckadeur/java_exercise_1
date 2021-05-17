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
            else if (cmd.equals("fibo")) {
                System.out.println("Entrez la valeur n désirée de la suite de fibonacci");
                cmd = scan.nextLine();
                int n = Integer.parseInt(cmd);
                if (n == 0 || n == 1) {
                    System.out.println("fibo(" + cmd + ") = 1");
                }
                else {
                    int a = 1;
                    int b = 1;
                    Integer c = 1;
                    for (int i = 2; i < n; i++) {
                        c = a + b;
                        a = b;
                        b = c;
                    }
                    System.out.println("fibo(" + cmd + ") = " + c.toString());
                }
            }
            else {
            System.out.println("Unknown command");
            }
        }
    }
}