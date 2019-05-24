package muic.ooc.zork.location.levels;

import muic.ooc.zork.character.monsters.AdvancedMonster;
import muic.ooc.zork.gameplay.Observation;
import muic.ooc.zork.items.HealthPotion;
import muic.ooc.zork.items.Key;
import muic.ooc.zork.items.ManaPotion;
import muic.ooc.zork.location.rooms.RoomWithLockedDoor;
import muic.ooc.zork.location.rooms.SimpleRoom;

import java.util.Random;

public class Pitfall extends Level {

	private static final int ROOM_SIZE = 5;

	public Pitfall(){
		super(ROOM_SIZE, ROOM_SIZE);
	}

	public Observation getInitialRoomMessage() {
		return new Observation("This does not seem like a good place to be at... Let's find a way out.");
	}

	protected void setRoom() {
		// level landscape
		for(int i = 0; i < xSize; i++) {
			for (int j = 0; j < ySize; j++) {
				levelSetup[i][j] = new SimpleRoom();
			}
		}
		levelSetup[xSize-2][ySize-1] = new RoomWithLockedDoor();
	}

	protected void putItems() {
		// put key in one of the rooms
		levelSetup[0][ySize-1].putItem(new Key());
		levelSetup[1][ySize/2].putItem(new ManaPotion());
		levelSetup[xSize-1][1].putItem(new HealthPotion());
	}

	protected void putMonsters() {
		Random rand = new Random();
		for (int monsterCount = 0; monsterCount < 2; monsterCount++){
			int x, y;
			do {
				x = rand.nextInt(xSize);
				y = rand.nextInt(ySize);
			} while((levelSetup[x][y] instanceof SimpleRoom) && (x == 0 & y == 0));
			levelSetup[x][y].putMonster(new AdvancedMonster());
		}
	}

	public Observation getLevelLandscape(){
		return new Observation("It's too dark here, you can't see your map...");
	}

	public String getCheatCode() {
		return "uwu";
	}

}
