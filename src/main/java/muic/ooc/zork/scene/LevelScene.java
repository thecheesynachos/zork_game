package muic.ooc.zork.scene;

import muic.ooc.zork.command.control.ControlCommandFactory;
import muic.ooc.zork.command.walk.WalkCommandFactory;
import muic.ooc.zork.gameplay.GameBag;
import muic.ooc.zork.gameplay.Observation;
import muic.ooc.zork.location.levels.*;

public class LevelScene extends Scene {

	@Override
	public void playScene(GameBag gameBag){

		Level currentLevel = LevelIterator.nextLevel();
		currentLevel.resetPlayer();

		gameBag.setCurrentLevel(currentLevel);
		gameBag.notifyObserver(currentLevel.getInitialRoomMessage());

		while (!currentLevel.isCompleted() && gameBag.getPlayer().isAlive()) {

			gameBag.resetCommandsList();
			gameBag.addCommandsToList(new WalkCommandFactory().getCommands());
			gameBag.addCommandsToList(new ControlCommandFactory().getCommands());

			showAndCollectCommand(gameBag);

			if (currentLevel.getCurrentRoom().hasMonster() && !currentLevel.isCompleted()) {
				Fight fight = new Fight(gameBag.getCurrentLevel().getCurrentRoom().getMonster());
				gameBag.setCurrentFight(fight);
				fight.doFight(gameBag);
			}

		}

		if(gameBag.getPlayer().isAlive()){
			Observation ob = new Observation.Builder()
					.addString("Level has been completed!")
					.addString("The password for this checkpoint is: " + currentLevel.getCheatCode())
					.setColour(Observation.ANSI_GREEN).build();
			gameBag.notifyObserver(ob);
			if (LevelIterator.hasNextLevel()){
				gameBag.getPlayer().incrementMaxHealth(5);
				gameBag.getPlayer().incrementMaxMana(5);
				gameBag.getPlayer().incrementHealth(5);
				gameBag.getPlayer().incrementMana(5);
				gameBag.getPlayer().incrementMaxAttack();
				gameBag.notifyObserver(new Observation("Enter anything to go to the next level."));
				String in = gameBag.getInputAcceptor().receiveInputAsString();
				gameBag.setNextScene(new LevelScene());
			} else{
				gameBag.setNextScene(new WinnerScene());
			}
		} else{
			gameBag.setNextScene(new GameOverScene());
		}

	}


}
