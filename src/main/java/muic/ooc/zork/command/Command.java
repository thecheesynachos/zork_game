package muic.ooc.zork.command;

import muic.ooc.zork.gameplay.Observation;
import muic.ooc.zork.gameplay.GameBag;

public interface Command {

	public Observation doCommand(GameBag gameBag);

	public String getCommandString();

}
