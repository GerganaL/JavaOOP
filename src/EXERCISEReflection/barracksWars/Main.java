package EXERCISEReflection.barracksWars;

import EXERCISEReflection.barracksWars.core.Engine;
import EXERCISEReflection.barracksWars.core.factories.CommandModel;
import EXERCISEReflection.barracksWars.core.factories.UnitFactoryImpl;
import EXERCISEReflection.barracksWars.data.UnitRepository;
import EXERCISEReflection.barracksWars.interfaces.CommandInterpreter;
import EXERCISEReflection.barracksWars.interfaces.Repository;
import EXERCISEReflection.barracksWars.interfaces.Runnable;
import EXERCISEReflection.barracksWars.interfaces.UnitFactory;

public class Main {

    public static void main(String[] args) {
        Repository repository = new UnitRepository();
        UnitFactory unitFactory = new UnitFactoryImpl();

        CommandInterpreter commandInterpreter = new CommandModel(repository,unitFactory);

        Runnable engine = new Engine(commandInterpreter);
        engine.run();
    }
}
