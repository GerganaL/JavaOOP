package easterRaces.core;

import easterRaces.core.interfaces.Controller;
import easterRaces.entities.cars.Car;
import easterRaces.entities.cars.MuscleCar;
import easterRaces.entities.cars.SportsCar;
import easterRaces.entities.drivers.Driver;
import easterRaces.entities.drivers.DriverImpl;
import easterRaces.entities.racers.Race;
import easterRaces.entities.racers.RaceImpl;
import easterRaces.repositories.CarRepository;
import easterRaces.repositories.DriverRepository;
import easterRaces.repositories.RaceRepository;
import easterRaces.repositories.interfaces.Repository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static easterRaces.common.ExceptionMessages.*;
import static easterRaces.common.OutputMessages.*;

public class ControllerImpl implements Controller {
    private Repository<Car> carRepository;
    private Repository<Race> raceRepository;
    private Repository<Driver> driverRepository;

    public ControllerImpl(Repository<Car> motorcycleRepository, Repository<Race> raceRepository, Repository<Driver> riderRepository) {
        this.carRepository = new CarRepository();
        this.raceRepository = new RaceRepository();
        this.driverRepository = new DriverRepository();
    }

    @Override
    public String createDriver(String driver) {
        Driver driver1 = new DriverImpl(driver);
        for (Driver driver2 : driverRepository.getAll()) {
            if(driver2.getName().equals(driver)){
                throw new IllegalArgumentException(String.format(DRIVER_EXISTS,driver));
            }
        }
        driverRepository.add(driver1);
        return String.format(DRIVER_CREATED,driver);
    }

    @Override
    public String createCar(String type, String model, int horsePower) {
        Car car = null;
        if(type.equals("Muscle")){
            car = new MuscleCar(model,horsePower);
        }else if(type.equals("Sports")){
            car = new SportsCar(model,horsePower);
        }
        for (Car car1 : carRepository.getAll()) {
            if(car1.getModel().equals(model)){
                throw new IllegalArgumentException(String.format(CAR_EXISTS,model));
            }
        }
        carRepository.add(car);
        return String.format(CAR_CREATED,car.getClass().getSimpleName(),model);
    }

    @Override
    public String addCarToDriver(String driverName, String carModel) {
        Car car = null;
        for (Car car1 : carRepository.getAll()) {
            if(car1.getModel().equals(carModel)){
                car = car1;
            }
        }

        if(car == null){
            throw new IllegalArgumentException(String.format(CAR_NOT_FOUND,carModel));
        }

        for (Driver driver1 : driverRepository.getAll()) {
            if(driver1.getName().equals(driverName)){
                driver1.addCar(car);
                return String.format(CAR_ADDED,driverName,carModel);
            }
        }

        throw new IllegalArgumentException(String.format(DRIVER_NOT_FOUND,driverName));
    }

    @Override
    public String addDriverToRace(String raceName, String driverName) {
        Driver driver = null;

        for (Driver driver1 : driverRepository.getAll()) {
            if(driver1.getName().equals(driverName)){
                driver = driver1;
            }
        }

        if(driver == null){
            throw new IllegalArgumentException(String.format(DRIVER_NOT_FOUND,driverName));
        }

        for (Race race1 : raceRepository.getAll()) {
            if (race1.getName().equals(raceName)) {
                race1.addDriver(driver);
                return String.format(DRIVER_ADDED, driverName, raceName);
            }
        }

        throw new IllegalArgumentException(String.format(RACE_NOT_FOUND,raceName));
    }

    @Override
    public String startRace(String raceName) {
        Race race = null;
        for (Race race1 : raceRepository.getAll()) {
            if(race1.getName().equals(raceName)){
                race = race1;
            }
        }
        if(race == null){
            throw new IllegalArgumentException(String.format(RACE_NOT_FOUND,raceName));
        }
        if(race.getDrivers().size() < 3){
            throw new IllegalArgumentException(String.format(RACE_INVALID,raceName,3));
        }

        Race finalRace = race;
        List<Driver> collect = race.getDrivers().stream().sorted((d1, d2) -> Double.compare(d2.getCar().calculateRacePoints(finalRace.getLaps()), d1.getCar().calculateRacePoints(finalRace.getLaps())))
                .limit(3)
                .collect(Collectors.toList());

        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (Driver driver : collect) {
            if(count == 0){
                sb.append(String.format(DRIVER_FIRST_POSITION,driver.getName(),raceName)).append(System.lineSeparator());
            }else if(count == 1){
                sb.append(String.format(DRIVER_SECOND_POSITION,driver.getName(),raceName)).append(System.lineSeparator());
            }else if(count == 2){
                sb.append(String.format(DRIVER_THIRD_POSITION,driver.getName(),raceName));
            }else {
                break;
            }
            count++;
        }

        return sb.toString();
    }

    @Override
    public String createRace(String name, int laps) {
        Race race = new RaceImpl(name,laps);
        for (Race race1 : raceRepository.getAll()) {
            if(race1.getName().equals(name)){
                throw new IllegalArgumentException(String.format(RACE_EXISTS,name));
            }
        }
        raceRepository.add(race);
        return String.format(RACE_CREATED,name);
    }
}
