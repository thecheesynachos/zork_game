package muic.ooc.zork.command.control;

import muic.ooc.zork.command.Command;
import muic.ooc.zork.gameplay.GameBag;
import muic.ooc.zork.gameplay.Observation;
import muic.ooc.zork.items.Item;

import java.util.Iterator;

public class SeeItems implements Command {

	public Observation doCommand(GameBag gameBag) {
		if(!gameBag.getPlayer().getInventory().isEmpty()) {
			Observation ob = new Observation("You currently have:");
			Iterator<Class<? extends Item>> itemIterator = gameBag.getPlayer().getInventory().keySet().iterator();
			while (itemIterator.hasNext()) {
				Class<? extends Item> item = itemIterator.next();
				ob.addMessage(item.getSimpleName() + ": " + gameBag.getPlayer().getInventory().get(item));
			}
			return ob;
		} else{
			return new Observation("You currently have nothin. Nothin.");
		}
	}

	public String getCommandString() {
		return "items";
	}

}
