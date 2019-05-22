package muic.ooc.zork.character;

import muic.ooc.zork.gameplay.AttackObject;
import muic.ooc.zork.gameplay.Observation;

import java.util.Random;

public abstract class Character {

	protected Random rand = new Random();
	protected int health;
	protected boolean isAlive;

	public Character(){
		isAlive = true;
	}

	public abstract void getAttacked(AttackObject ao, Observation ob);

	public int getHealth() {
		return health;
	}
}
