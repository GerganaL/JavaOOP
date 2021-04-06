package easterRaces.entities.drivers;

import easterRaces.entities.cars.Car;

import java.util.ArrayList;
import java.util.List;

import static easterRaces.common.ExceptionMessages.CAR_INVALID;
import static easterRaces.common.ExceptionMessages.INVALID_NAME;

public  class DriverImpl implements Driver{
    private String name;
    private Car car;
    private int numberOfWins;
    private boolean canParticipate = false;


    public DriverImpl(String name){
       setName(name);
    }

    private void setName(String name) {
        if(name == null || name.trim().isEmpty() || name.trim().length() < 5){
            throw new IllegalArgumentException(String.format(INVALID_NAME,name,5));
        }
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Car getCar() {
        return this.car;
    }

    @Override
    public int getNumberOfWins() {
        return this.numberOfWins;
    }

    @Override
    public void addCar(Car car) {
        if(car == null){
            throw new IllegalArgumentException(CAR_INVALID);
        }
        this.car = car;
        canParticipate = true;
    }

    @Override
    public void winRace() {

    }

    @Override
    public boolean getCanParticipate() {
        return canParticipate;
    }
}
