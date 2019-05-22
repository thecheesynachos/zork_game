package muic.ooc.zork.command.fight;

import muic.ooc.zork.command.Command;
import muic.ooc.zork.gameplay.AttackObject;
import muic.ooc.zork.gameplay.Observation;
import muic.ooc.zork.gameplay.GameBag;

public class Attack implements Command {

	public Observation doCommand(GameBag gameBag) {
		Observation ob = new Observation("You attack the monster.");
		AttackObject attackObject = gameBag.getPlayer().attack();
		gameBag.getCurrentFight().getFightingMonster().getAttacked(attackObject, ob);
		gameBag.getCurrentFight().toggleTurnCompleted();
		return ob;
	}

	public String getCommandString() {
		return "attack";
	}

}
