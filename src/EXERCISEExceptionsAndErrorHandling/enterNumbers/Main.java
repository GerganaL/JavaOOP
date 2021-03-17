package EXERCISEExceptionsAndErrorHandling.enterNumbers;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


    while (true) {
        try {
            int start = Integer.parseInt(scanner.nextLine());
            int end = Integer.parseInt(scanner.nextLine());
            EnterNumbers enterNumbers = new EnterNumbers();
            enterNumbers.printNumbers(start, end);
            return;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            System.out.println("Please enter start and end number again");
        }
    }


    }
}
