package muic.ooc.zork.command.control;

import muic.ooc.zork.command.Command;
import muic.ooc.zork.gameplay.GameBag;
import muic.ooc.zork.gameplay.Observation;

public class Cheat implements Command {

	public Observation doCommand(GameBag gameBag) {
		gameBag.notifyObserver(new Observation("Enter the cheat code to proceed"));
		String input = gameBag.getInputAcceptor().receiveInputAsString();
		if (input.equalsIgnoreCase(gameBag.getCurrentLevel().getCheatCode())){
			gameBag.getCurrentLevel().toggleCompleted();
			return new Observation("Level is skipped.");
		} else{
			return new Observation("Hey, hey, hey. That's illegal here.");
		}
	}

	public String getCommandString() {
		return "cheat";
	}

}
