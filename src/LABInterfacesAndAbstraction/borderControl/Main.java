package LABInterfacesAndAbstraction.borderControl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Identifiable> ids = new ArrayList<>();
        String input = scanner.nextLine();

        while (!"End".equals(input)) {
            String[] tokens = input.split("\\s+");
            if (tokens.length == 3) {
                ids.add(new Citizen(tokens[0], Integer.parseInt(tokens[1]), tokens[2]));
            } else {
                ids.add(new Robot(tokens[0], tokens[1]));

            }
            input = scanner.nextLine();
        }
        String lastDigits = scanner.nextLine();

        ids.stream().filter(id -> id.getId().endsWith(lastDigits)).forEach(id -> System.out.println(id.getId()));

    }
}
