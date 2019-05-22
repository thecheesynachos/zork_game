package muic.ooc.zork.command.misc;

import muic.ooc.zork.command.AbstractCommandFactory;
import muic.ooc.zork.command.Command;
import muic.ooc.zork.command.walk.WalkDown;
import muic.ooc.zork.command.walk.WalkLeft;
import muic.ooc.zork.command.walk.WalkRight;
import muic.ooc.zork.command.walk.WalkUp;

import java.util.ArrayList;
import java.util.List;

public class MiscCommandFactory extends AbstractCommandFactory {

	private List<Command> commands = new ArrayList<Command>(){{
		add(new Start());
		add(new Credits());
		add(new Exit());
	}};

	public List<Command> getCommands() {
		return commands;
	}

}
