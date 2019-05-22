package muic.ooc.zork.command.control;

import muic.ooc.zork.command.Command;
import muic.ooc.zork.gameplay.GameBag;
import muic.ooc.zork.gameplay.Observation;

public class Stat implements Command {

	public Observation doCommand(GameBag gameBag) {
		StringBuilder sb = new StringBuilder();
		sb.append("Current health: ").append(gameBag.getPlayer().getHealth()).append('/').append(gameBag.getPlayer().getMaxPlayerHealth()).append('\n');
		sb.append("Current mana  : ").append(gameBag.getPlayer().getMana()).append('/').append(gameBag.getPlayer().getMaxPlayerHealth()).append('\n');
		sb.append("Current attack: ").append(gameBag.getPlayer().getMaxPlayerAttack());
		return new Observation(sb.toString());
	}

	public String getCommandString() {
		return "stats";
	}
}
