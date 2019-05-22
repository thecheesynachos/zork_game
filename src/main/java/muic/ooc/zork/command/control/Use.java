package muic.ooc.zork.command.control;

import muic.ooc.zork.command.Command;
import muic.ooc.zork.gameplay.GameBag;
import muic.ooc.zork.gameplay.Observation;
import muic.ooc.zork.items.Item;

public class Use implements Command {

	public Observation doCommand(GameBag gameBag) {
		Observation ob = null;
		gameBag.notifyObserver(new Observation("What do you want to use?"));
		String input = gameBag.getInputAcceptor().receiveInputAsString().toLowerCase();
		for (Class<? extends Item> itemType: gameBag.getPlayer().getInventory().keySet()){
			if(input.startsWith(itemType.getSimpleName().toLowerCase())){
				ob = gameBag.getPlayer().retrieveItem(itemType).use(gameBag);
				break;
			}
		}
		if (ob == null){
			ob = new Observation("This item does not exist! Are you trying to cheat physics here?");
		}
		return ob;
	}

	public String getCommandString() {
		return "use";
	}

}
