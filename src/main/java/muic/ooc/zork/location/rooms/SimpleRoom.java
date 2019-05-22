package muic.ooc.zork.location.rooms;

import muic.ooc.zork.gameplay.GameBag;
import muic.ooc.zork.gameplay.Observation;

public class SimpleRoom extends Room{

	private static final boolean CAN_WALK_THROUGH = true;

	public SimpleRoom(){
		super();
	}

	@Override
	public boolean canWalkThrough() {
		return CAN_WALK_THROUGH;
	}

	protected String roomMessage() {
		return null;
	}

	public Observation roomAction(GameBag gameBag) {
		return new Observation("Nothing to do in this room!");
	}

}
