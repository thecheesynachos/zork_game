package muic.ooc.zork.command.control;

import muic.ooc.zork.command.Command;
import muic.ooc.zork.gameplay.GameBag;
import muic.ooc.zork.gameplay.Observation;

public class Map implements Command {

	public Observation doCommand(GameBag gameBag) {
		return gameBag.getCurrentLevel().getLevelLandscape();
	}

	public String getCommandString() {
		return "map";
	}

}
