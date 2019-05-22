package muic.ooc.zork.location.rooms;

import muic.ooc.zork.gameplay.GameBag;
import muic.ooc.zork.gameplay.Observation;

public class ForbiddenRoom extends Room {

	public ForbiddenRoom() {
		super();
	}

	public boolean canWalkThrough() {
		return false;
	}

	protected String roomMessage() {
		return null;
	}

	public Observation roomAction(GameBag gameBag) {
		return new Observation("Nothing to do in this room!");
	}

}
