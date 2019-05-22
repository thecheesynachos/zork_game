package muic.ooc.zork.items;

import muic.ooc.zork.character.Player;
import muic.ooc.zork.gameplay.GameBag;
import muic.ooc.zork.gameplay.Observation;

public class ManaPotion extends FightItem{

	private static final int POTION_AMOUNT = 10;

	public Observation use(GameBag gameBag) {
		Player player = gameBag.getPlayer();
		player.setMana(Math.min(player.getMaxPlayerMana(), player.getMana() + POTION_AMOUNT));
		return new Observation("Drank some mana potion.");
	}

	public boolean canDeplete() {
		return true;
	}

}
