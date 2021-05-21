import java.util.*;

public class Launcher {
    public static void main(String[] args){

        List<Command> commands = new ArrayList<>();
        commands.add(new Quit());
        commands.add(new Fibo());
        commands.add(new Freq());

        boolean QuitCommand = true;
        Scanner scan = new Scanner(System.in);

        while(QuitCommand) {
            System.out.println("Entrez une commande:");
            String userInput = scan.nextLine();

            boolean CommandFound = false;

            for (Command command : commands) {
                if (command.name().equals(userInput)) {
                    CommandFound = true;
                    QuitCommand = command.run(scan);
                }
            }

            if (!CommandFound)
                System.out.println("Unknown command");
        }
    }
}