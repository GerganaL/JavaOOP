package EXERCISEPolymorphism.vehiclesExtencsion;

import java.text.DecimalFormat;

public class Bus extends Vehicle {
    private  boolean isEmpty;
    public Bus(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
        isEmpty = false;
    }

    public boolean isEmpty(){
        return isEmpty;
    }

    public void setEmpty(boolean empty){
        isEmpty = empty;
    }


    @Override
    public void drive(double distance) {

        double fuelCost =0;
        if(isEmpty) {
            fuelCost = super.getFuelConsumption() * distance;
        }else {
            fuelCost = (super.getFuelConsumption() + 1.4) * distance;
        }

        if(fuelCost > super.getFuelQuantity()) {
            System.out.println("Bus needs refueling");
        }else {
            super.setFuelQuantity(super.getFuelQuantity() - fuelCost);
            DecimalFormat decimalFormat = new DecimalFormat("###.##");
            System.out.printf("Bus travelled %s km%n", decimalFormat.format(distance));
        }

    }

    @Override
    public void refill(double quantity) {
        if(quantity <= 0){
            System.out.println("Fuel must be a positive number");
        }else {
            if(quantity + super.getFuelQuantity() <= super.getTankCapacity()) {
                super.setFuelQuantity(super.getFuelQuantity() + quantity);
            }else {
                System.out.println("Cannot fit fuel in tank");
            }
        }
    }

    @Override
    public String toString() {
        return String.format("Bus: %s", super.toString());
    }
}
