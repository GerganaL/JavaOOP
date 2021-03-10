package EXERCISEPolymorphism.vehiclesExtencsion;

import java.text.DecimalFormat;

public class Truck extends Vehicle {
    public Truck(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
    }

    @Override
    public void drive(double distance) {
        double fuelCost = (super.getFuelConsumption() + 1.6) * distance;
        if (fuelCost <= super.getFuelQuantity()) {
            super.setFuelQuantity(super.getFuelQuantity() - fuelCost);

            DecimalFormat decimalFormat = new DecimalFormat("###.##");
            System.out.printf("Truck travelled %s km%n", decimalFormat.format(distance));
        } else {
            System.out.println("Truck needs refueling");
        }
    }

    @Override
    public void refill(double quantity) {
        if(quantity <= 0){
            System.out.println("Fuel must be a positive number");
        }else {
            if(quantity + super.getFuelQuantity() <= super.getTankCapacity()) {
                super.setFuelQuantity(super.getFuelQuantity() + quantity * 0.95);
            }else {
                System.out.println("Cannot fit fuel in tank");
            }
        }
    }

    @Override
    public String toString() {
        return String.format("Truck: %s", super.toString());
    }
}
