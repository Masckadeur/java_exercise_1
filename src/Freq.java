import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Freq implements Command {

    @Override
    public String name() {
        return "freq";
    }

    @Override
    public boolean run(Scanner scanner) {

        System.out.println("Entrez le chemin du fichier:");
        try {
            Path path = Paths.get(scanner.nextLine());

            System.out.println(frequence(Files.readString(path)));
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
        return true;
    }

    private String frequence(String content) {
        String[] clean = content.toLowerCase().replaceAll("[.!?'\"\n,;:]", " ")
                .split(" ");

        Map<String, Long> map = Arrays.stream(clean)
                .filter(s -> !s.isBlank())
                .map(s -> s.toLowerCase())
                .collect(Collectors.groupingBy(s -> s, Collectors.counting()));

        Function<Map.Entry<String, Long>, Long> extract = e -> e.getValue();

        String s = map.entrySet().stream()
                .sorted(Comparator.comparing(extract).reversed())
                .limit(3)
                .map(e -> e.getKey())
                .collect(Collectors.joining( " "));
        return s;
    }
}
