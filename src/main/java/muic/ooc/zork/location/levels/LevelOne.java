package muic.ooc.zork.location.levels;

import muic.ooc.zork.character.monsters.BasicMonster;
import muic.ooc.zork.gameplay.Observation;
import muic.ooc.zork.items.HealthPotion;
import muic.ooc.zork.items.Key;
import muic.ooc.zork.items.ManaPotion;
import muic.ooc.zork.items.Spinach;
import muic.ooc.zork.location.rooms.ForbiddenRoom;
import muic.ooc.zork.location.rooms.RoomWithLockedDoor;
import muic.ooc.zork.location.rooms.SimpleRoom;

import java.util.Random;

public class LevelOne extends Level {

	private static final int LEVEL_ONE_SIZE = 5;

	public LevelOne(){
		super(LEVEL_ONE_SIZE, LEVEL_ONE_SIZE);
	}

	protected void setRoom() {
		// set up room
		for(int i = 0; i < xSize; i++) {
			for (int j = 0; j < ySize; j++) {
				levelSetup[i][j] = new SimpleRoom();
			}
		}

		// set up walls

		for (int y = 0; y < ySize-1; y++){
			levelSetup[xSize/2][y] = new ForbiddenRoom();
		}

		// put room with escape door
		levelSetup[xSize-1][0] = new RoomWithLockedDoor();
	}

	protected void putItems() {

		// put key in one of the rooms and items in the other
		levelSetup[xSize-1][ySize-1].putItem(new Key());
		levelSetup[xSize/2 + 1][ySize/2].putItem(new ManaPotion());
		levelSetup[xSize-1][1].putItem(new HealthPotion());
		levelSetup[xSize-2][ySize-2].putItem(new Spinach());

	}

	protected void putMonsters() {

		// put monsters in the rooms
		Random rand = new Random();
		for (int y = 1; y < ySize; y++){
			int x;
			do {
				x = rand.nextInt(xSize);
			} while(!(levelSetup[x][y] instanceof SimpleRoom));
			levelSetup[x][y].putMonster(new BasicMonster());
		}

	}

	public Observation getInitialRoomMessage() {
		return new Observation("Welcome to the first level. Find the key, unlock the door to get to the next stage!");
	}

	public String getCheatCode() {
		return "gigadot";
	}
}
