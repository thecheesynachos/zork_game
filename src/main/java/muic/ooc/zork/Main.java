package muic.ooc.zork;

import muic.ooc.zork.gameplay.GameBag;

public class Main {

	public static void main(String[] args) {
		GameBag gb = new GameBag();
		while(true){
			gb.getNextScene().playScene(gb);
		}
	}

}
