package muic.ooc.zork.gameplay;

import muic.ooc.zork.character.Player;
import muic.ooc.zork.character.monsters.Monster;
import muic.ooc.zork.command.Command;
import muic.ooc.zork.command.fight.FightCommandFactory;

public class Fight {

	private Monster fightingMonster;
	private Player player;
	private boolean isDone;
	private boolean turnCompleted;

	public Fight(Monster monster){
		this.fightingMonster = monster;
		this.player = Player.getPlayer();
		this.isDone = false;
		this.turnCompleted = false;
	}

	public void doFight(GameBag gameBag){

		String fightColour = Observation.ANSI_CYAN;

		Observation ob;
		InputAcceptor inputAcceptor = gameBag.getInputAcceptor();
		ob = new Observation("You met a monster!", fightColour);
		gameBag.notifyObserver(ob);

		while(!isDone){

			turnCompleted = false;

			// Player's turn
			while(!turnCompleted) {

				gameBag.notifyObserver(new Observation(getFightStats()));

				gameBag.resetCommandsList();
				gameBag.addCommandsToList(new FightCommandFactory().getCommands());

				Observation commandsList = gameBag.getCommandsAsString();
				gameBag.notifyObserver(commandsList);

				Command command = inputAcceptor.receiveInput(gameBag);
				if (command != null) {
					ob = command.doCommand(gameBag);
					gameBag.notifyObserver(ob);
				} else {
					gameBag.notifyObserver(new Observation("Invalid input, try again."));
				}

			}

			// Monster's move
			if (fightingMonster.isAlive()) {
				ob = fightingMonster.doTurn(player);
				gameBag.notifyObserver(ob);
				if (!player.isAlive()) {
					isDone = true;
				}
			} else {
				isDone = true;
				gameBag.getCurrentLevel().getCurrentRoom().putMonster(null);
			}

		}
		if (player.isAlive()){
			ob = new Observation("You have defeated the monster!");
			gameBag.notifyObserver(ob);
			player.incrementMaxHealth();
			player.incrementMaxMana();
		} else{
			ob = new Observation("Oof owie, you have died. Isn't that sad.");
			gameBag.notifyObserver(ob);
			gameBag.getCurrentLevel().toggleCompleted();
		}
		gameBag.setCurrentFight(null);
	}

	public boolean isDone() {
		return isDone;
	}

	public Monster getFightingMonster() {
		return fightingMonster;
	}

	public String getFightStats(){
		StringBuilder sb = new StringBuilder();
		sb.append("Your health : ").append(player.getHealth()).append('/').append(player.getMaxPlayerHealth()).append('\n');
		sb.append("Your mana   : ").append(player.getMana()).append('/').append(player.getMaxPlayerMana()).append('\n');
		sb.append("Their health: ").append(fightingMonster.getHealth()).append('/').append(fightingMonster.getMaxHealth());
		return sb.toString();
	}

	public void toggleTurnCompleted(){
		turnCompleted = !turnCompleted;
	}
}
