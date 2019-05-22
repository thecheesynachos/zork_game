package muic.ooc.zork.command.walk;

import muic.ooc.zork.command.AbstractCommandFactory;
import muic.ooc.zork.command.Command;

import java.util.ArrayList;
import java.util.List;

public class WalkCommandFactory extends AbstractCommandFactory {

	private List<Command> commands = new ArrayList<Command>(){{
		add(new WalkUp());
		add(new WalkDown());
		add(new WalkLeft());
		add(new WalkRight());
	}};

	public List<Command> getCommands() {
		return commands;
	}

}
