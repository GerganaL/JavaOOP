package EXERCISEReflection.barracksWars.core.commands;

import EXERCISEReflection.barracksWars.interfaces.Executable;
import EXERCISEReflection.barracksWars.interfaces.Repository;


public class Report implements Executable {

    public Report(){

    }

    Repository repository;
    public Report(Repository repository) {
       this.repository = repository;
    }

    @Override
    public String execute() {
        return repository.getStatistics();
    }

}
