package LABabstraction.geometry;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int [] coordinates = readArray(scanner);
        Rectangle rectangle = createRectangle(coordinates);

        int n = Integer.parseInt(scanner.nextLine());
        while (n-- > 0){
            int [] points = readArray(scanner);
            System.out.println(rectangle.contains(points[0],points[1]));
        }

    }
    public static Rectangle createRectangle(int[] coordinates){
        Point bottomLeft = createPont(coordinates[0],coordinates[1]);
        Point topRight = createPont(coordinates[2],coordinates[3]);
        return new Rectangle(bottomLeft,topRight);
    }
    public static Point createPont(int x, int y) {
        return  new Point(x,y);
    }

    private static int[] readArray(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
    }
}
