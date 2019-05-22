package muic.ooc.zork.location.rooms;

import muic.ooc.zork.gameplay.GameBag;
import muic.ooc.zork.gameplay.Observation;

public class FragileRoom extends Room {

	public boolean canWalkThrough() {
		return true;
	}

	protected String roomMessage() {
		return "The floor in this room seems a bit weak, maybe we can blow it up or something...";
	}

	public Observation roomAction(GameBag gameBag) {
		gameBag.getCurrentLevel().toggleCompleted();
		return new Observation("BOOM! The floor breaks! But now you fell. To somewhere far below...");
	}

}
