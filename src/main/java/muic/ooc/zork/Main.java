package muic.ooc.zork;

import muic.ooc.zork.gameplay.GameBag;
import muic.ooc.zork.gameplay.Sound;

public class Main {

	public static void main(String[] args) {
		GameBag gb = new GameBag();
		Sound.getInstance().start();
		while(true){
			gb.getNextScene().playScene(gb);
		}
	}

}
