package EXERCISESAbstraction.trafficLights;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] trafficLightStates = scanner.nextLine().split("\\s+");
        int numberOfUpdates = Integer.parseInt(scanner.nextLine());

        List<TrafficLight> trafficLights = new ArrayList<>();

        for (String lightState : trafficLightStates) {
            TrafficLight trafficLight = new TrafficLight(TrafficLightState.valueOf(lightState));
            trafficLights.add(trafficLight);
        }

        for (int i = 0; i < numberOfUpdates; i++) {
            for (TrafficLight light : trafficLights) {
                light.update();
                System.out.print(light.toString());
            }
            System.out.println();
        }
    }
}
