package muic.ooc.zork.items;

import muic.ooc.zork.gameplay.GameBag;
import muic.ooc.zork.gameplay.Observation;
import muic.ooc.zork.location.rooms.RoomWithLockedDoor;

public class Key extends Item {

	public Observation use(GameBag gameBag) {
		Observation ob;
		if (gameBag.getCurrentLevel().getCurrentRoom() instanceof RoomWithLockedDoor){
			ob = gameBag.getCurrentLevel().getCurrentRoom().roomAction(gameBag);
		} else{
			ob = new Observation("Cannot use the key here.");
		}
		return ob;
	}

	public boolean canDeplete() {
		return true;
	}

}
