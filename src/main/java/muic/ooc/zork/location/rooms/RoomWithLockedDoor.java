package muic.ooc.zork.location.rooms;

import muic.ooc.zork.gameplay.GameBag;
import muic.ooc.zork.gameplay.Observation;

public class RoomWithLockedDoor extends Room {

	public boolean canWalkThrough() {
		return true;
	}

	protected String roomMessage() {
		return "There is a strange door in here. It is locked.";
	}

	public Observation roomAction(GameBag gameBag) {
		gameBag.getCurrentLevel().toggleCompleted();
		return new Observation("The door is unlocked!");
	}

}
