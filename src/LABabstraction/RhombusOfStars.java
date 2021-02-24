package LABabstraction;

import java.util.Scanner;

public class RhombusOfStars {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());

        printRow(n);
    }

    private static void printRow(int n) {

        for (int r = 1; r <= n; r++) {
            repeatString(n - r, " ");
            repeatString(r, "* ");
            System.out.println();
        }

        for (int r = 1; r <= n; r++) {
            repeatString(r," ");
            repeatString(n - r, "* ");

            System.out.println();
        }
    }

    private static void repeatString(int num, String stringToRepeat) {
        for (int s = 0; s < num; s++) {
            System.out.print(stringToRepeat);
        }
    }
}
