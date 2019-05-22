package muic.ooc.zork.character.monsters;

import muic.ooc.zork.gameplay.Observation;
import muic.ooc.zork.gameplay.AttackObject;
import muic.ooc.zork.character.Character;

public abstract class Monster extends Character {

	protected int stunTurnLeft;
	protected int potionAvailable;

	public abstract Observation doTurn(Character c);

	public Monster(){
		health = getMaxHealth();
	}

	public abstract int getMaxHealth();

	protected abstract int getMaxAttack();

	public void getAttacked(AttackObject ao, Observation ob){
		health -= ao.getDamage();
		if (ao.getStunTurn() > 0) {
			stunTurnLeft += ao.getStunTurn();
			ob.addMessage("The monster has been stunned!");
		}
		if(health <= 0){
			isAlive = false;
		}
	}

	public boolean isAlive() {
		return isAlive;
	}

	public void basicAttack(Character c, Observation ob){
		int attackLevel = rand.nextInt(getMaxAttack()) + 1;
		AttackObject attackObject = new AttackObject.Builder().damage(attackLevel).build();
		c.getAttacked(attackObject, ob);
		ob.addMessage("Monster does basic attack with damage of " + attackLevel);
	}

	protected void usePotion(){
		health = getMaxHealth();
		potionAvailable -= 1;
	}

}
