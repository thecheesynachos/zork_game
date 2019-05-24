package muic.ooc.zork.items;

import muic.ooc.zork.character.Player;
import muic.ooc.zork.gameplay.GameBag;
import muic.ooc.zork.gameplay.Observation;

public class HealthPotion extends FightItem {

	private static final int POTION_AMOUNT = 30;

	public Observation use(GameBag gameBag) {
		Player player = gameBag.getPlayer();
		player.setHealth(Math.min(player.getMaxPlayerHealth(), player.getHealth() + POTION_AMOUNT));
		return new Observation("Drank some health potion.");
	}

	public boolean canDeplete() {
		return true;
	}

}
