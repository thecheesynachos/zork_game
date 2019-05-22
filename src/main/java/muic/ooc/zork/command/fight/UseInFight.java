package muic.ooc.zork.command.fight;

import muic.ooc.zork.command.Command;
import muic.ooc.zork.gameplay.GameBag;
import muic.ooc.zork.gameplay.Observation;
import muic.ooc.zork.items.FightItem;
import muic.ooc.zork.items.Item;

import java.util.Iterator;

public class UseInFight implements Command {

	public Observation doCommand(GameBag gameBag) {

		Observation ob = null;
		gameBag.notifyObserver(new Observation("What do you want to use?"));
		String input = gameBag.getInputAcceptor().receiveInputAsString().toLowerCase();
		for (Class<? extends Item> itemType: gameBag.getPlayer().getInventory().keySet()){
			if(input.startsWith(itemType.getSimpleName().toLowerCase())){
				if (FightItem.class.isAssignableFrom(itemType)) {
					ob = gameBag.getPlayer().retrieveItem(itemType).use(gameBag);
					gameBag.getCurrentFight().toggleTurnCompleted();
				} else{
					ob = new Observation("Cannot use this item here!");
				}
				break;
			}
		}
		if (ob == null){
			ob = new Observation("This item does not exist! Bruh!");
		}
		return ob;
	}

	public String getCommandString() {
		return "use";
	}

}
