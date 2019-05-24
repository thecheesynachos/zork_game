package muic.ooc.zork.scene;

import muic.ooc.zork.command.misc.MiscCommandFactory;
import muic.ooc.zork.gameplay.GameBag;
import muic.ooc.zork.gameplay.Observation;

public class StartScene extends Scene {

	String asciiIntro =
			" ______           _          ______ _             _   \n" +
			"|___  /          | |         | ___ \\ |           | |  \n" +
			"   / /  ___  _ __| | ____ _  | |_/ / |_   _  __ _| |_ \n" +
			"  / /  / _ \\| '__| |/ / _` | | ___ \\ | | | |/ _` | __|\n" +
			"./ /__| (_) | |  |   < (_| | | |_/ / | |_| | (_| | |_ \n" +
			"\\_____/\\___/|_|  |_|\\_\\__,_| \\____/|_|\\__, |\\__,_|\\__|\n" +
			"                                       __/ |          \n" +
			"                                      |___/           \n";

	public void playScene(GameBag gameBag) {

		gameBag.notifyObserver(new Observation(asciiIntro, Observation.ANSI_YELLOW));
		gameBag.notifyObserver(new Observation("Welcome to the game. You ready?"));
		gameBag.setNextScene(null);

		while(gameBag.getNextScene() == null) {

			gameBag.resetCommandsList();
			gameBag.addCommandsToList(new MiscCommandFactory().getCommands());

			showAndCollectCommand(gameBag);

		}

	}

}
