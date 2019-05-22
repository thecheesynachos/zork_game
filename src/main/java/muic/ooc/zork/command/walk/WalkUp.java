package muic.ooc.zork.command.walk;

import muic.ooc.zork.gameplay.Observation;
import muic.ooc.zork.gameplay.GameBag;
import muic.ooc.zork.command.Command;

public class WalkUp implements Command {

	public Observation doCommand(GameBag gameBag) {
		return gameBag.getCurrentLevel().walkUp();
	}

	public String getCommandString() {
		return "up";
	}
}
