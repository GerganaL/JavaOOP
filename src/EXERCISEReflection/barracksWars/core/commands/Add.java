package EXERCISEReflection.barracksWars.core.commands;

import EXERCISEReflection.barracksWars.interfaces.Executable;
import EXERCISEReflection.barracksWars.interfaces.Repository;
import EXERCISEReflection.barracksWars.interfaces.Unit;
import EXERCISEReflection.barracksWars.interfaces.UnitFactory;
import jdk.jshell.spi.ExecutionControl;


public class Add implements Executable {

    public Add(){

    }


    private String[] data;
    Repository repository;
    UnitFactory unitFactory;
    public Add(String[] data, Repository repository, UnitFactory unitFactory) {
        this.data = data;
        this.repository = repository;
        this.unitFactory = unitFactory;
    }

    @Override
    public String execute() throws ExecutionControl.NotImplementedException {
        String unitType = data[1];
        Unit unitToAdd = unitFactory.createUnit(unitType);
        repository.addUnit(unitToAdd);
        return unitType + " added!";
    }
}
