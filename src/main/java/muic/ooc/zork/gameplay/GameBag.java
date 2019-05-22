package muic.ooc.zork.gameplay;

import muic.ooc.zork.character.Player;
import muic.ooc.zork.character.monsters.Monster;
import muic.ooc.zork.command.Command;
import muic.ooc.zork.gameplay.scene.Scene;
import muic.ooc.zork.gameplay.scene.StartScene;
import muic.ooc.zork.location.levels.Level;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GameBag {

	private Player player;
	private Level currentLevel;
	private List<Command> commandsList;
	private Fight currentFight;
	private InputAcceptor inputAcceptor;
	private Observer observer;
	private Scene nextScene;

	private boolean isWon = false;

	public GameBag() {
		this.player = Player.getPlayer();
		this.currentLevel = null;
		this.commandsList = new ArrayList<Command>();
		this.currentFight = null;
		this.inputAcceptor = new InputAcceptor();
		this.observer = new CommandLinePrinter();
		this.nextScene = new StartScene();
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public Level getCurrentLevel() {
		return currentLevel;
	}

	public void setCurrentLevel(Level currentLevel) {
		this.currentLevel = currentLevel;
	}

	public List<Command> getCommandsList() {
		return commandsList;
	}

	public Observation getCommandsAsString(){
		Observation ob = new Observation("Available commands:");
		StringBuilder sb = new StringBuilder();
		Iterator<Command> it = commandsList.iterator();
		while(it.hasNext()){
			sb.append(it.next().getCommandString());
			if(it.hasNext()){
				sb.append(", ");
			}
		}
		ob.addMessage(sb.toString());
		return ob;
	}

	public void resetCommandsList() {
		this.commandsList = new ArrayList<Command>();
	}

	public void addCommandToList(Command command){
		this.commandsList.add(command);
	}

	public void addCommandsToList(List<Command> commands){
		this.commandsList.addAll(commands);
	}

	public Fight getCurrentFight() {
		return currentFight;
	}

	public void setCurrentFight(Fight fight) {
		this.currentFight = fight;
	}

	public InputAcceptor getInputAcceptor() {
		return inputAcceptor;
	}

	public void setInputAcceptor(InputAcceptor inputAcceptor) {
		this.inputAcceptor = inputAcceptor;
	}

	public Observer getObserver() {
		return observer;
	}

	public void setObserver(Observer observer) {
		this.observer = observer;
	}

	public void notifyObserver(Observation observation){
		observer.presentObservation(observation);
	}

	public Scene getNextScene() {
		return nextScene;
	}

	public void setNextScene(Scene scene){
		this.nextScene = scene;
	}

}
