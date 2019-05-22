package muic.ooc.zork.items;

import muic.ooc.zork.gameplay.GameBag;
import muic.ooc.zork.gameplay.Observation;

public class Flint extends Item {

	public Observation use(GameBag gameBag) {
		return new Observation("What to use the flint with? Hmmm...");
	}

	public boolean canDeplete() {
		return false;
	}

}
