package muic.ooc.zork.command.misc;

import muic.ooc.zork.command.Command;
import muic.ooc.zork.gameplay.GameBag;
import muic.ooc.zork.gameplay.Observation;
import muic.ooc.zork.gameplay.Sound;

public class Music implements Command {

	public Observation doCommand(GameBag gameBag) {
		Observation ob = Sound.getInstance().toggleSound();
		return ob;
	}

	public String getCommandString() {
		return "music";
	}

}
