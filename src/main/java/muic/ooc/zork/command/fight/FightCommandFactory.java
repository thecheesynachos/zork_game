package muic.ooc.zork.command.fight;

import muic.ooc.zork.command.AbstractCommandFactory;
import muic.ooc.zork.command.Command;
import muic.ooc.zork.command.control.SeeItems;

import java.util.ArrayList;
import java.util.List;

public class FightCommandFactory extends AbstractCommandFactory {

	private List<Command> commands = new ArrayList<Command>(){{
		add(new Attack());
		add(new CriticalHit());
		add(new Block());
		add(new Stun());
		add(new UseInFight());
		add(new SeeItems());
	}};

	public List<Command> getCommands() {
		return commands;
	}

}
