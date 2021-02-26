import java.util.*;

public class cores {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] listFiles = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int numCores = Integer.parseInt(scanner.nextLine());
        int limit = Integer.parseInt(scanner.nextLine());

        List<Integer> parallel = new ArrayList<>();
        List<Integer> noParallel = new ArrayList<>();

        for (int listFile : listFiles) {
            if (listFile % numCores == 0) {
                parallel.add(listFile);
                continue;
            }
            noParallel.add(listFile);
        }

        int minTime = 0;
        while (limit > 0 && !parallel.isEmpty()) {
            minTime += Collections.max(parallel) / numCores;
            parallel.remove(Collections.max(parallel));
            limit -= 1;
        }
        if (!parallel.isEmpty()) {
            minTime += parallel.stream()
                    .mapToInt(Integer::intValue)
                    .sum();
        }
        minTime += noParallel.stream().mapToInt(Integer::intValue).sum();
        System.out.println(minTime);

    }
}
