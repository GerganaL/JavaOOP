package EXERCISEInterfacesAndAbstraction.collectionHiararchy;


import java.util.*;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String[] input = scan.nextLine().split("\\s+");
        int n = Integer.parseInt(scan.nextLine());
        AddCollection addCollection = new AddCollection();
        AddRemoveCollection addRemoveCollection = new AddRemoveCollection();
        MyListImpl myListImpl = new MyListImpl();
        Arrays.stream(input).forEach(e -> System.out.printf("%d ", addCollection.add(e)));
        System.out.println();
        Arrays.stream(input).forEach(e -> System.out.printf("%d ", addRemoveCollection.add(e)));
        System.out.println();
        Arrays.stream(input).forEach(e -> System.out.printf("%d ", myListImpl.add(e)));
        System.out.println();
        IntStream.range(0, n).forEach(i -> System.out.printf("%s ", addRemoveCollection.remove()));
        System.out.println();
        IntStream.range(0, n).forEach(i -> System.out.printf("%s ", myListImpl.remove()));

    }
}
