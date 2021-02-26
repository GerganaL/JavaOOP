import java.util.Scanner;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class test {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int queries = in.nextInt();
        long[] output = new long[n];
        IntStream.range(0,queries).forEach(i -> {
            int a = in.nextInt()-1;
            int b = in.nextInt();
            int k = in.nextInt();
            output[a] += k;
            if(b < n) output[b] -= k; });
        AtomicLong sum = new AtomicLong(0);
        System.out.print(LongStream.of(output).map(sum::addAndGet)
                .max().getAsLong());
        in.close();
    }
}
