package muic.ooc.zork.items;

import muic.ooc.zork.gameplay.GameBag;
import muic.ooc.zork.gameplay.Observation;

public abstract class Item {

	public abstract Observation use(GameBag gameBag);

	public abstract boolean canDeplete();

}
