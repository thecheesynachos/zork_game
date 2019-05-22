package muic.ooc.zork.command.fight;

import muic.ooc.zork.command.Command;
import muic.ooc.zork.gameplay.GameBag;
import muic.ooc.zork.gameplay.Observation;

public class Block implements Command {

	public Observation doCommand(GameBag gameBag) {
		gameBag.getPlayer().defend();
		gameBag.getCurrentFight().toggleTurnCompleted();
		return new Observation("You block!");
	}

	public String getCommandString() {
		return "block";
	}
}
