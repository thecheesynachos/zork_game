package muic.ooc.zork.character.monsters;

import muic.ooc.zork.character.Character;
import muic.ooc.zork.gameplay.AttackObject;
import muic.ooc.zork.gameplay.Observation;

public class BossMonster extends Monster {

	private static final int BOSS_MAX_HEALTH = 40;
	private static final int BOSS_MAX_ATTACK = 9;
	private static final double BOSS_STUN_PROB = 0.15;
	private static final int BOSS_CRITICAL_LEVEL = 10;
	private static final int BOSS_STUN_TURNS = 1;

	public BossMonster(){
		super();
		this.potionAvailable = 2;
	}

	public Observation doTurn(Character c) {
		if(stunTurnLeft > 0){
			stunTurnLeft -= 1;
			return new Observation("Monster cannot attack because it is stunned!");
		} else {
			Observation ob;
			if(health <= BOSS_CRITICAL_LEVEL && potionAvailable > 0){
				usePotion();
				return new Observation("Monster uses potion to restore its health.");
			} else if (rand.nextDouble() < BOSS_STUN_PROB){
				ob = new Observation("Monster stuns you! Your attacks will be useless in the next turn!");
				AttackObject ao = new AttackObject.Builder().stunTurn(BOSS_STUN_TURNS).build();
				c.getAttacked(ao, ob);
				return ob;
			} else {
				ob = new Observation("Big boi attacks.");
				basicAttack(c, ob);
				return ob;
			}
		}
	}

	public int getMaxHealth() {
		return BOSS_MAX_HEALTH;
	}

	protected int getMaxAttack() {
		return BOSS_MAX_ATTACK;
	}

}
