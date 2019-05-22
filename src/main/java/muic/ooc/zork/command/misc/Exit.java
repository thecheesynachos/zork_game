package muic.ooc.zork.command.misc;

import muic.ooc.zork.command.Command;
import muic.ooc.zork.gameplay.GameBag;
import muic.ooc.zork.gameplay.Observation;

public class Exit implements Command {


	public Observation doCommand(GameBag gameBag) {
		System.exit(0);
		return null;
	}

	public String getCommandString() {
		return "exit";
	}

}
