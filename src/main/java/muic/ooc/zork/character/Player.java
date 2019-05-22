package muic.ooc.zork.character;

import muic.ooc.zork.command.fight.Attack;
import muic.ooc.zork.gameplay.AttackObject;
import muic.ooc.zork.gameplay.Observation;
import muic.ooc.zork.items.HealthPotion;
import muic.ooc.zork.items.Item;

import java.util.HashMap;
import java.util.Map;

public class Player extends Character {

	private int xCoord;
	private int yCoord;
	private Map<Class<? extends Item>, Integer> inventory;
	private int inventorySize;
	private static final int MAX_INVENTORY_SIZE = 10;
	private int mana;
	private int blockAmount;
	private int stunTurns;

	// these are initial conditions at the start
	private static final int INIT_MAX_PLAYER_HEALTH = 20;
	private static final int INIT_MAX_PLAYER_MANA = 10;
	private static final int INIT_MAX_PLAYER_ATTACK = 5;
	private static final int INIT_MAX_PLAYER_STUN_AMT = 4;

	// these number may go up as game progresses
	private int maxPlayerHealth;
	private int maxPlayerMana;
	private int maxPlayerAttack;
	private int maxStunTurnAmount;

	// mana amounts
	private static final int MANA_FOR_CRITICAL_ATTACK = 7;
	private static final int MANA_FOR_STUN = 5;

	private static Player player = new Player();

	public Player(){
		super();
		maxPlayerHealth = INIT_MAX_PLAYER_HEALTH;
		maxPlayerMana = INIT_MAX_PLAYER_MANA;
		maxPlayerAttack = INIT_MAX_PLAYER_ATTACK;
		maxStunTurnAmount = INIT_MAX_PLAYER_STUN_AMT;
		health = maxPlayerHealth;
		mana = maxPlayerMana;
		inventory = new HashMap<Class<? extends Item>, Integer>();
		receiveItem(new HealthPotion());
	}

	public void reset(){
		maxPlayerHealth = INIT_MAX_PLAYER_HEALTH;
		maxPlayerMana = INIT_MAX_PLAYER_MANA;
		maxPlayerAttack = INIT_MAX_PLAYER_ATTACK;
		maxStunTurnAmount = INIT_MAX_PLAYER_STUN_AMT;
		health = maxPlayerHealth;
		mana = maxPlayerMana;
		inventory = new HashMap<Class<? extends Item>, Integer>();
		receiveItem(new HealthPotion());
	}

	public void defend() {
		blockAmount = rand.nextInt(maxPlayerAttack / 2) + maxPlayerAttack / 2;
	}

	public AttackObject attack(){
		if(stunTurns == 0) {
			int attackAmount = rand.nextInt(maxPlayerAttack / 2) + maxPlayerAttack / 2;
			return new AttackObject.Builder().damage(attackAmount).build();
		} else{
			stunTurns--;
			return new AttackObject.Builder().build();
		}
	}

	public AttackObject criticalAttack(){
		if(stunTurns == 0) {
			if (mana >= MANA_FOR_CRITICAL_ATTACK) {
				mana -= MANA_FOR_CRITICAL_ATTACK;
				int attackAmount = rand.nextInt(maxPlayerAttack) + maxPlayerAttack;
				return new AttackObject.Builder().damage(attackAmount).build();
			} else{
				return null;
			}
		} else{
			stunTurns--;
			return new AttackObject.Builder().build();
		}
	}

	public AttackObject stun(){
		if(stunTurns == 0) {
			if (mana >= MANA_FOR_STUN) {
				mana -= MANA_FOR_STUN;
				int stunAmount = rand.nextInt(maxStunTurnAmount/2) + maxStunTurnAmount/2;
				return new AttackObject.Builder().stunTurn(stunAmount).build();
			} else{
				return null;
			}
		} else{
			stunTurns--;
			return new AttackObject.Builder().build();
		}
	}

	public void getAttacked(AttackObject ao, Observation ob) {
		if (ao.getStunTurn() > 0){
			stunTurns = ao.getStunTurn();
		}
		int attackAmount = ao.getDamage() - blockAmount;
		if (attackAmount > 0){
			health -= attackAmount;
			if(health <= 0){
				isAlive = false;
			}
		} else{
			ob.addMessage("Your block is strong enough to defend the attack!");
		}
		blockAmount = 0;

	}

	public static Player getPlayer(){
		return player;
	}

	public void place(int xCoord, int yCoord){
		this.xCoord = xCoord;
		this.yCoord = yCoord;
	}

	public int getxCoord() {
		return xCoord;
	}

	public int getyCoord() {
		return yCoord;
	}

	public void walkUp(){
		yCoord--;
	}

	public void walkDown(){
		yCoord++;
	}

	public void walkLeft(){
		xCoord--;
	}

	public void walkRight(){
		xCoord++;
	}

	public void incrementHealth(int healthAmount){
		if(health + healthAmount <= maxPlayerHealth){
			health += healthAmount;
		}
	}

	public void incrementHealth(){
		incrementHealth(1);
	}

	public void incrementMaxHealth(){
		maxPlayerHealth++;
	}

	public void incrementMaxHealth(int increase){
		maxPlayerHealth += increase;
	}

	public void incrementMaxMana(){
		maxPlayerMana++;
	}

	public void incrementMaxMana(int increase){
		maxPlayerMana += increase;
	}

	public void incrementMaxAttack(){
		maxPlayerAttack++;
	}

	public void incrementMana(int manaAmount){
		if(mana + manaAmount <= maxPlayerMana){
			mana += manaAmount;
		}
	}

	public void incrementMana(){
		incrementMana(1);
	}

	public boolean isAlive(){
		return health > 0;
	}

	public boolean hasItem(Class<? extends Item> itemType){
		return inventory.containsKey(itemType) && inventory.get(itemType) > 0;
	}

	public Item retrieveItem(Class<? extends Item> itemType){
		try {
			Item newItem = itemType.getConstructor().newInstance();
			if (newItem.canDeplete()) {
				if (inventory.get(itemType) - 1 > 0) {
					inventory.put(itemType, inventory.get(itemType) - 1);
				} else {
					inventory.remove(itemType);
				}
				inventorySize--;
			}
			return newItem;
		} catch(Exception e){
			return null;
		}
	}

	public Observation receiveItem(Item item){
		if (inventorySize < MAX_INVENTORY_SIZE) {
			Class<? extends Item> itemType = item.getClass();
			if (inventory.containsKey(itemType)) {
				inventory.put(itemType, inventory.get(itemType) + 1);
			} else {
				inventory.put(itemType, 1);
			}
			inventorySize++;
			return new Observation("Picked up a " + itemType.getSimpleName() + ".");
		} else{
			return new Observation("Cannot pick up new item, inventory is already full. Try dropping an item first.");
		}
	}

	public Map<Class<? extends Item>, Integer> getInventory() {
		return inventory;
	}

	public int getMana(){
		return mana;
	}

	public int getMaxPlayerHealth() {
		return maxPlayerHealth;
	}

	public int getMaxPlayerAttack() {
		return maxPlayerAttack;
	}

	public int getMaxPlayerMana() {
		return maxPlayerMana;
	}

	public void setHealth(int newHealth){
		this.health = newHealth;
	}

	public void setMana(int mana) {
		this.mana = mana;
	}

	public void setMaxPlayerAttack(int maxPlayerAttack) {
		this.maxPlayerAttack = maxPlayerAttack;
	}

}
