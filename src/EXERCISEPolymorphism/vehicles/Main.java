package EXERCISEPolymorphism.vehicles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] carInfo = reader.readLine().split("\\s+");
        Car car = new Car(Double.parseDouble(carInfo[1]), Double.parseDouble(carInfo[2]));
        String[] truckInfo = reader.readLine().split("\\s+");
        Truck truck = new Truck(Double.parseDouble(truckInfo[1]), Double.parseDouble(truckInfo[2]));
        int n = Integer.parseInt(reader.readLine());
        for (int i = 0; i < n; i++) {
            String[] commands = reader.readLine().split("\\s+");
            switch (commands[0]) {
                case "Drive":
                    if (commands[1].equals("Car")) {
                        car.drive(Double.parseDouble(commands[2]));
                    } else {
                        truck.drive(Double.parseDouble(commands[2]));
                    }
                    break;
                case "Refuel":
                    if (commands[1].equals("Car")) {
                        car.refill(Double.parseDouble(commands[2]));
                    } else {
                        truck.refill(Double.parseDouble(commands[2]));
                    }
                    break;
            }
        }
        System.out.println(car.toString());
        System.out.println(truck.toString());
    }
}
