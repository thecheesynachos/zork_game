package muic.ooc.zork.gameplay.scene;

import muic.ooc.zork.gameplay.GameBag;
import muic.ooc.zork.gameplay.Observation;
import muic.ooc.zork.location.levels.LevelIterator;

public class GameOverScene extends Scene {

	public void playScene(GameBag gameBag) {
		gameBag.notifyObserver(new Observation("Game over. \nEnter anything to return to main menu.",
				Observation.ANSI_RED));
		gameBag.getPlayer().reset();
		LevelIterator.reset();
		String in = gameBag.getInputAcceptor().receiveInputAsString();
		gameBag.setNextScene(new StartScene());
	}

}
