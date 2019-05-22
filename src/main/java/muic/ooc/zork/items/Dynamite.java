package muic.ooc.zork.items;

import muic.ooc.zork.gameplay.GameBag;
import muic.ooc.zork.gameplay.Observation;
import muic.ooc.zork.location.rooms.FragileRoom;

public class Dynamite extends Item {

	public Observation use(GameBag gameBag) {
		Observation ob;
		if (gameBag.getCurrentLevel().getCurrentRoom() instanceof FragileRoom){
			if(gameBag.getPlayer().hasItem(Flint.class)) {
				ob = gameBag.getCurrentLevel().getCurrentRoom().roomAction(gameBag);
			} else{
				ob = new Observation("A bit useless without something to light it with...");
			}
		} else{
			ob = new Observation("It's best we don't use it here...");
		}
		return ob;
	}

	public boolean canDeplete() {
		return false;
	}

}
