package muic.ooc.zork.items;

import muic.ooc.zork.gameplay.GameBag;
import muic.ooc.zork.gameplay.Observation;

public class Spinach extends Item {


	public Observation use(GameBag gameBag) {
		gameBag.getPlayer().incrementMaxHealth();
		gameBag.getPlayer().incrementMaxAttack();
		gameBag.getPlayer().incrementMaxMana();
		gameBag.getPlayer().incrementMana();
		gameBag.getPlayer().incrementHealth();
		return new Observation("And like Popeye, you are now stronger than before!");
	}

	public boolean canDeplete() {
		return true;
	}

}
