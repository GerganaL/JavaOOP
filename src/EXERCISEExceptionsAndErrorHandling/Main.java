package EXERCISEExceptionsAndErrorHandling;

import EXERCISEExceptionsAndErrorHandling.squareRoot.SquareRoot;
import EXERCISEExceptionsAndErrorHandling.validPerson.Person;
import EXERCISEExceptionsAndErrorHandling.validPerson.Student;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
       /* int number = 0;
        try {
            number = Integer.parseInt(scanner.nextLine());
        }catch (NumberFormatException e){
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }finally {
            System.out.println("Good bye");
        }


        SquareRoot squareRoot = new SquareRoot(number);
        System.out.println(squareRoot.sqrt(number));*/
       /* try {

            Person gigi = new Person("gigi", "lulcheva", 23);
            Person noName = new Person("", "lulcheva", 23);
            Person noLastName = new Person("gigi", null, 23);
        }catch (NullPointerException e){
            System.out.println(e.getMessage());
        }

        try {
             Person negativeAge = new Person("gigi","lulcheva",-5);
            Person tooOld = new Person("gigi","lulcheva",130);
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
*/

        Student student = new Student("Chavdar","myemail.com");
        }
    }
