package muic.ooc.zork.command.walk;

import muic.ooc.zork.gameplay.Observation;
import muic.ooc.zork.gameplay.GameBag;
import muic.ooc.zork.command.Command;

public class WalkRight implements Command {

	public Observation doCommand(GameBag gameBag) {
		return gameBag.getCurrentLevel().walkRight();
	}

	public String getCommandString() {
		return "right";
	}
}
