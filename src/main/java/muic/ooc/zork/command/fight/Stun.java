package muic.ooc.zork.command.fight;

import muic.ooc.zork.command.Command;
import muic.ooc.zork.gameplay.AttackObject;
import muic.ooc.zork.gameplay.GameBag;
import muic.ooc.zork.gameplay.Observation;

public class Stun implements Command {
	public Observation doCommand(GameBag gameBag) {
		Observation ob = new Observation("You attempt to stun the monster.");
		AttackObject attackObject = gameBag.getPlayer().stun();
		if (attackObject != null) {
			gameBag.getCurrentFight().getFightingMonster().getAttacked(attackObject, ob);
			gameBag.getCurrentFight().toggleTurnCompleted();
		} else{
			ob.addMessage("You need more mana to do this!");
		}
		return ob;
	}

	public String getCommandString() {
		return "stun";
	}
}
