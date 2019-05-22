package muic.ooc.zork.command.misc;

import muic.ooc.zork.command.Command;
import muic.ooc.zork.gameplay.GameBag;
import muic.ooc.zork.gameplay.Observation;
import muic.ooc.zork.gameplay.scene.LevelScene;

public class Start implements Command {

	public Observation doCommand(GameBag gameBag) {
		gameBag.setNextScene(new LevelScene());
		return new Observation("Let's-a-go.");
	}

	public String getCommandString() {
		return "start";
	}

}
