package muic.ooc.zork.gameplay.scene;

import muic.ooc.zork.gameplay.GameBag;
import muic.ooc.zork.gameplay.Observation;
import muic.ooc.zork.location.levels.LevelIterator;

public class WinnerScene extends Scene {

	public void playScene(GameBag gameBag) {
		gameBag.notifyObserver(new Observation("Congratulations! You finished the game! " +
				"\nEnter anything to return to main menu."));
		gameBag.getPlayer().reset();
		LevelIterator.reset();
		String in = gameBag.getInputAcceptor().receiveInputAsString();
		gameBag.setNextScene(new StartScene());
	}

}
