package muic.ooc.zork.character.monsters;

import muic.ooc.zork.gameplay.Observation;
import muic.ooc.zork.character.Character;

public class BasicMonster extends Monster {

	private static final int BASIC_MONSTER_MAX_HEALTH = 10;
	private static final int BASIC_MONSTER_MAX_ATTACK = 3;

	public int getMaxHealth() {
		return BASIC_MONSTER_MAX_HEALTH;
	}

	protected int getMaxAttack() {
		return BASIC_MONSTER_MAX_ATTACK;
	}

	public Observation doTurn(Character c) {
		if(stunTurnLeft > 0){
			stunTurnLeft -= 1;
			return new Observation("Monster cannot attack because it is stunned!");
		} else {
			Observation ob = new Observation("The monster decides to attack.");
			basicAttack(c, ob);
			return ob;
		}
	}

}
