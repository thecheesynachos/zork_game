package muic.ooc.zork.location.levels;

import muic.ooc.zork.character.monsters.BasicMonster;
import muic.ooc.zork.gameplay.Observation;
import muic.ooc.zork.items.*;
import muic.ooc.zork.location.rooms.ForbiddenRoom;
import muic.ooc.zork.location.rooms.FragileRoom;
import muic.ooc.zork.location.rooms.RoomWithLockedDoor;
import muic.ooc.zork.location.rooms.SimpleRoom;

import java.util.Random;

public class LevelTwo extends Level {

	private static final byte[][] WALL_GRID = {
			{1, 0, 1, 1, 1, 1, 1},
			{1, 0, 1, 1, 0, 0, 0},
			{1, 1, 1, 1, 1, 0, 1},
			{0, 0, 0, 1, 1, 1, 1},
			{1, 1, 1, 1, 1, 0, 1},
			{1, 0, 0, 0, 1, 0, 1},
			{1, 0, 1, 1, 1, 0, 1}
	};

	public LevelTwo(){
		super(WALL_GRID[0].length, WALL_GRID.length);
	}

	public Observation getInitialRoomMessage() {
		return new Observation("Welcome to the dungeon. This room oughta get confusing.\n" +
				"Escape from here to pass this level.");
	}

	protected void setRoom() {

		// set up room with walls
		// inverted coordinate because java hates math notations
		for(int x = 0; x < xSize; x++) {
			for (int y = 0; y < ySize; y++) {
				if (WALL_GRID[y][x] == 1) {
					levelSetup[x][y] = new SimpleRoom();
				} else{
					levelSetup[x][y] = new ForbiddenRoom();
				}
			}
		}


		// put special rooms
		levelSetup[6][0] = new RoomWithLockedDoor();
		levelSetup[2][6] = new FragileRoom();

	}

	protected void putItems() {
		// put key in one of the rooms and items in the other
		levelSetup[0][5].putItem(new Dynamite());
		levelSetup[6][6].putItem(new Flint());
		levelSetup[6][3].putItem(new ManaPotion());
		levelSetup[5][0].putItem(new ManaPotion());
		levelSetup[2][1].putItem(new HealthPotion());
		levelSetup[3][6].putItem(new HealthPotion());
		levelSetup[4][2].putItem(new Spinach());
	}

	protected void putMonsters() {
		// put monsters in the rooms
		Random rand = new Random();
		for (int monsterCount = 0; monsterCount < 4; monsterCount++){
			int x, y;
			do {
				x = rand.nextInt(xSize);
				y = rand.nextInt(ySize);
			} while((levelSetup[x][y] instanceof SimpleRoom) && (x == 0 & y == 0) && !levelSetup[x][y].hasItem());
			levelSetup[x][y].putMonster(new BasicMonster());
		}
	}

	public String getCheatCode() {
		return "fishstop";
	}
}
