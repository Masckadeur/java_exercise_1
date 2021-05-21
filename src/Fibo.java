import java.util.Scanner;

public class Fibo implements Command {

    @Override
    public String name() {
        return "fibo";
    }

    @Override
    public boolean run(Scanner scanner) {
        System.out.println("Entrez la valeur n désirée de la suite de fibonacci:");
        String Number = scanner.nextLine();

        int n = Integer.parseInt(Number);
        if (n == 0 || n == 1) {
            System.out.println("fibo(" + n + ") = 1");
        }
        else {
            System.out.println("fibo(" + n + ") = " + fibonacci(n));
        }
        return true;
    }

    private int fibonacci(int n) {
        if (n <= 1) return n;
        else return fibonacci(n-1) + fibonacci(n-2);
    }
}
