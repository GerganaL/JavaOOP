package LABabstraction.greedyTimes;

import java.io.BufferedReader;
import java.util.Scanner;

public class ConsoleReader {
    private BufferedReader reader;

    private Scanner scanner;

    public
    ConsoleReader (){
        this.scanner = new Scanner (System.in);
    }
    public String readLine(){
        return this.scanner.nextLine ();
    }
}
