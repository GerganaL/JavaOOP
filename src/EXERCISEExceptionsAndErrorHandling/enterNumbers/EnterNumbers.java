package EXERCISEExceptionsAndErrorHandling.enterNumbers;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class EnterNumbers {
    private int start;
    private int end;

    public EnterNumbers() {
    }

    private void setEnd(int end, int start) {
        if (end < start || end > 100) {
            throw new IllegalArgumentException("End number must be < start number and < 100");
        } else {
            this.end = end;
        }
    }

    private void setStart(int start, int end) {
        if (start < 1 || start > end) {
            throw new IllegalArgumentException("Start number must be > 1 and < end number.");
        } else {
            this.start = start;
        }
    }


    public void printNumbers(int start, int end) {
        this.setStart(start,end);
        this.setEnd(end,start);
        List<Integer> numbers = IntStream.rangeClosed(start, end).boxed().collect(Collectors.toList());
        numbers.forEach(System.out::println);
    }


}
