package LABabstraction;

import IOUtils.ConsoleReader;
import IOUtils.InputParser;

public class Main {
    public static void main(String[] args) {

        ConsoleReader reader = new ConsoleReader();
        int [] rectangleInfo = InputParser.parseArray(reader.readLine(), "\\s+");


    }
}
