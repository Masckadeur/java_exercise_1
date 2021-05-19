import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.nio.file.Files;
import java.util.stream.Stream;

public class Launcher {
    public static void main(String[] args) throws IOException {

        label:
        while(true) {
            System.out.println("Entrez une commande:");
            Scanner scan = new Scanner(System.in);

            String cmd = scan.nextLine();
            switch (cmd) {
                case "quit":
                    break label;
                case "fibo":
                    System.out.println("Entrez la valeur n désirée de la suite de fibonacci:");
                    cmd = scan.nextLine();
                    int n = Integer.parseInt(cmd);
                    if (n == 0 || n == 1) {
                        System.out.println("fibo(" + cmd + ") = 1");
                    } else {
                        int a = 1;
                        int b = 1;
                        int c = 1;
                        for (int i = 2; i < n; i++) {
                            c = a + b;
                            a = b;
                            b = c;
                        }
                        System.out.println("fibo(" + cmd + ") = " + Integer.toString(c));
                    }
                    break;
                case "freq":
                    System.out.println("Entrez le chemin du fichier:");
                    try {
                        Path path = Paths.get(scan.nextLine());

                        String content = Files.readString(path);
                        System.out.println(content + " avant modif");
                        String clean = content.toLowerCase().replaceAll("[.!?'\"]", " ");
                        System.out.println(clean);
                        String[] tab = clean.split(" ");

                    }
                    catch (IOException e) {
                        System.err.println("Unreadable file: IOException " + e.getMessage());
                    }
                    catch (OutOfMemoryError e) {
                        System.err.println("Unreadable file: OutOfMemoryError " + e.getMessage());
                    }
                    catch (SecurityException e) {
                        System.err.println("Unreadable file: SecurityException " + e.getMessage());
                    }
                    break;
                default:
                    System.out.println("Unknown command");
                    break;
            }
        }
    }
}