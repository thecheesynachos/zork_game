package muic.ooc.zork.location.levels;

import muic.ooc.zork.character.monsters.BasicMonster;
import muic.ooc.zork.character.monsters.BossMonster;
import muic.ooc.zork.gameplay.Observation;
import muic.ooc.zork.items.HealthPotion;
import muic.ooc.zork.items.Key;
import muic.ooc.zork.items.ManaPotion;
import muic.ooc.zork.items.Spinach;
import muic.ooc.zork.location.rooms.ForbiddenRoom;
import muic.ooc.zork.location.rooms.RoomWithLockedDoor;
import muic.ooc.zork.location.rooms.SimpleRoom;

import java.util.Random;

public class LevelThree extends Level {

	private static final int LEVEL_THREE_SIZE = 6;

	public LevelThree(){
		super(LEVEL_THREE_SIZE, LEVEL_THREE_SIZE);
	}

	public Observation getInitialRoomMessage() {
		return new Observation("This is the last level. Or is it?");
	}

	protected void setRoom() {

		// set up room
		for(int i = 0; i < xSize; i++) {
			for (int j = 0; j < ySize; j++) {
				if (i > xSize/2 && j != ySize/2) {
					levelSetup[i][j] = new ForbiddenRoom();
				} else{
					levelSetup[i][j] = new SimpleRoom();
				}
			}
		}

		// special rooms
		levelSetup[xSize-1][ySize/2] = new RoomWithLockedDoor();

	}

	protected void putItems() {

		// items
		levelSetup[0][1].putItem(new ManaPotion());
		levelSetup[1][4].putItem(new ManaPotion());
		levelSetup[1][3].putItem(new HealthPotion());
		levelSetup[2][4].putItem(new HealthPotion());
		levelSetup[2][2].putItem(new Spinach());
		levelSetup[xSize-2][ySize/2].putItem(new Key());

	}

	protected void putMonsters() {

		// monsters
		levelSetup[xSize-2][ySize/2].putMonster(new BossMonster());
		Random rand = new Random();
		for (int monsterCount = 0; monsterCount < 3; monsterCount++){
			int x = rand.nextInt(xSize/2-1) + 1;
			int y = rand.nextInt(ySize-1) + 1;
			levelSetup[x][y].putMonster(new BasicMonster());
		}

	}

	public String getCheatCode() {
		return "penguins";
	}
}
