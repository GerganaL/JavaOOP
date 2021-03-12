package EXERCISEPolymorphism.word;

public class Initialization {
    public static CommandInterface buildCommandInterface(StringBuilder text) {
      //  return new CommandImpl(text);
        CommandInterface commandInterface = new CommandImpl(text);
        commandInterface.init();
        return commandInterface;
    }
}
