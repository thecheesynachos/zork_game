package muic.ooc.zork.character.monsters;

import muic.ooc.zork.gameplay.Observation;
import muic.ooc.zork.gameplay.AttackObject;
import muic.ooc.zork.character.Character;

public class AdvancedMonster extends Monster {

	private static final int ADVANCED_MONSTER_MAX_HEALTH = 20;
	private static final int ADVANCED_MONSTER_MAX_ATTACK = 5;
	private static final int ADVANCED_MONSTER_CRITICAL_LEVEL = 5;
	private static final double HALF_ATTACK_PROBABILITY = 0.1;

	public AdvancedMonster(){
		super();
		this.potionAvailable = 1;
	}

	public int getMaxHealth() {
		return ADVANCED_MONSTER_MAX_HEALTH;
	}

	protected int getMaxAttack() {
		return ADVANCED_MONSTER_MAX_ATTACK;
	}

	public Observation doTurn(Character c) {
		if(stunTurnLeft > 0){
			stunTurnLeft -= 1;
			return new Observation("Monster cannot attack because it is stunned!");
		} else {
			if(health <= ADVANCED_MONSTER_CRITICAL_LEVEL && potionAvailable > 0){
				usePotion();
				return new Observation("Monster uses potion to restore its health.");
			} else if (rand.nextDouble() < HALF_ATTACK_PROBABILITY){
				Observation ob = new Observation("Monster divides your health by a half!");
				AttackObject ao = new AttackObject.Builder().damage(c.getHealth()/2).build();
				c.getAttacked(ao, ob);
				return ob;
			} else {
				Observation ob = new Observation("Big boi attacks.");
				basicAttack(c, ob);
				return ob;
			}
		}
	}

}
