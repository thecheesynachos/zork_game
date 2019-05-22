package muic.ooc.zork.command.misc;

import muic.ooc.zork.command.Command;
import muic.ooc.zork.gameplay.GameBag;
import muic.ooc.zork.gameplay.Observation;

public class Credits implements Command {

	public Observation doCommand(GameBag gameBag) {
		Observation ob = new Observation("Zorka Blyat\n" +
				"OOC Game by thecheesynachos, 2019.");
		return ob;
	}

	public String getCommandString() {
		return "credits";
	}

}
