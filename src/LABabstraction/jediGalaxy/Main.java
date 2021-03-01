package LABabstraction.jediGalaxy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] dimensions = reader.readLine().split("\\s+");
        int row =Integer.parseInt(dimensions[0]);
        int col = Integer.parseInt(dimensions[1]);
        int[][] matrix = createMatrix(row, col);

        String command = reader.readLine();
        getStars(reader,matrix,command);


    }

    private static void getStars(BufferedReader reader, int[][] matrix, String command) throws IOException {
        long sumStars = 0;
        while (!command.equals("Let the Force be with you")) {
            String[] ivoLocation = command.split("\\s+");
            String[] evilLocation = reader.readLine().split("\\s+");

            int rowEvil = Integer.parseInt(evilLocation[0]);
            int colEvil = Integer.parseInt(evilLocation[1]);

            moveEvil(matrix, rowEvil, colEvil);

            int rowIvo = Integer.parseInt(ivoLocation[0]);
            int colIvo =Integer.parseInt(ivoLocation[1]);

            sumStars = moveIvo(matrix, sumStars, rowIvo, colIvo);

            command = reader.readLine();
        }
        System.out.println(sumStars);
    }

    private static long moveIvo(int[][] matrix, long sumStars, int rowIvo, int colIvo) {
        while (rowIvo >= 0 && colIvo < matrix[1].length) {
            if (rowIvo < matrix.length && colIvo >= 0 && colIvo < matrix[0].length) {
                sumStars += matrix[rowIvo][colIvo];
            }
            colIvo++;
            rowIvo--;
        }
        return sumStars;
    }

    private static void moveEvil(int[][] matrix, int rowEvil, int colEvil) {
        while (rowEvil >= 0 && colEvil >= 0) {
            if (rowEvil < matrix.length && colEvil < matrix[0].length) {
                matrix[rowEvil][colEvil] = 0;
            }
            rowEvil--;
            colEvil--;
        }
    }

    private static int[][] createMatrix(int x, int y) {
        int value = 0;
        int[][] matrix = new int[x][y];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                matrix[i][j] = value++;
            }
        }
        return matrix;
    }

}
