package muic.ooc.zork.command.fight;

import muic.ooc.zork.command.Command;
import muic.ooc.zork.gameplay.AttackObject;
import muic.ooc.zork.gameplay.GameBag;
import muic.ooc.zork.gameplay.Observation;

public class CriticalHit implements Command {

	public Observation doCommand(GameBag gameBag) {
		Observation ob = new Observation("You attempt to do a critical attack.");
		AttackObject attackObject = gameBag.getPlayer().criticalAttack();
		if (attackObject != null) {
			gameBag.getCurrentFight().getFightingMonster().getAttacked(attackObject, ob);
			gameBag.getCurrentFight().toggleTurnCompleted();
		} else{
			ob.addMessage("You do not have enough mana for this!");
		}
		return ob;
	}

	public String getCommandString() {
		return "criticalhit";
	}

}
