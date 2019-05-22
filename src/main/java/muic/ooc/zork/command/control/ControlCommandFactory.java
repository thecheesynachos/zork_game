package muic.ooc.zork.command.control;

import muic.ooc.zork.command.AbstractCommandFactory;
import muic.ooc.zork.command.Command;

import java.util.ArrayList;
import java.util.List;

public class ControlCommandFactory extends AbstractCommandFactory {

	private List<Command> commands = new ArrayList<Command>(){{
		add(new Map());
		add(new SeeItems());
		add(new Use());
		add(new Take());
		add(new Stat());
		add(new Cheat());
	}};

	public List<Command> getCommands() {
		return commands;
	}

}
