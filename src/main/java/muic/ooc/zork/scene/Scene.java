package muic.ooc.zork.scene;

import muic.ooc.zork.command.Command;
import muic.ooc.zork.gameplay.GameBag;
import muic.ooc.zork.gameplay.InputAcceptor;
import muic.ooc.zork.gameplay.Observation;

public abstract class Scene {

	public abstract void playScene(GameBag gameBag);

	protected void showAndCollectCommand(GameBag gameBag){

		Observation commandsList = gameBag.getCommandsAsString();
		gameBag.notifyObserver(commandsList);

		InputAcceptor inputAcceptor = gameBag.getInputAcceptor();
		Command command = inputAcceptor.receiveInput(gameBag);
		Observation output = inputAcceptor.processCommand(command, gameBag);
		gameBag.notifyObserver(output);

	}

}
