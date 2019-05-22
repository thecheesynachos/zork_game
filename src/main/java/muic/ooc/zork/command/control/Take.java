package muic.ooc.zork.command.control;

import muic.ooc.zork.command.Command;
import muic.ooc.zork.gameplay.GameBag;
import muic.ooc.zork.gameplay.Observation;
import muic.ooc.zork.items.Item;
import muic.ooc.zork.location.rooms.Room;

public class Take implements Command {

	public Observation doCommand(GameBag gameBag) {
		Room currentRoom = gameBag.getCurrentLevel().getCurrentRoom();
		if (currentRoom.hasItem()){
			Item item = currentRoom.pickItem();
			gameBag.getPlayer().receiveItem(item);
			return new Observation("Picked up " + item.getClass().getSimpleName());
		} else{
			return new Observation("Nothing to pick up here.");
		}
	}

	public String getCommandString() {
		return "take";
	}

}
