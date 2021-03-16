package barracksWars.interfaces;

import jdk.jshell.spi.ExecutionControl;

public interface CommandInterpreter {

	Executable interpretCommand(String[] data, String commandName) throws ExecutionControl.NotImplementedException;
}
