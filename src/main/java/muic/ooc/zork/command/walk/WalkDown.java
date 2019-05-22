package muic.ooc.zork.command.walk;

import muic.ooc.zork.gameplay.Observation;
import muic.ooc.zork.gameplay.GameBag;
import muic.ooc.zork.command.Command;

public class WalkDown implements Command {

	public Observation doCommand(GameBag gameBag) {
		return gameBag.getCurrentLevel().walkDown();
	}

	public String getCommandString() {
		return "down";
	}
}
