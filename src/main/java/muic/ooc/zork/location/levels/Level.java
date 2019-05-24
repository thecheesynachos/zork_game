package muic.ooc.zork.location.levels;

import muic.ooc.zork.gameplay.Observation;
import muic.ooc.zork.character.Player;
import muic.ooc.zork.location.rooms.Room;

public abstract class Level {

	protected int xSize;
	protected int ySize;
	private static final int X_START = 0;
	private static final int Y_START = 0;
	protected Room[][] levelSetup;
	protected boolean[][] roomVisited;
	protected Player player;
	protected boolean completed;

	public Level(int xSize, int ySize){
		this.xSize = xSize;
		this.ySize = ySize;
		levelSetup = new Room[xSize][ySize];
		setLevel();
		roomVisited = new boolean[xSize][ySize];
		player = Player.getPlayer();
		player.place(X_START, Y_START);
		roomVisited[0][0] = true;
	}

	public Observation getLevelLandscape(){
		StringBuilder levelString = new StringBuilder();
		for(int i = 0; i < ySize; i++){
			for(int j = 0; j < xSize; j++){
				if(player.getyCoord() == i && player.getxCoord() == j){
					levelString.append('X');
				} else if(roomVisited[j][i]) {
					levelString.append('O');
				} else {
					levelString.append('.');
				}
				levelString.append(' ');
			}
			levelString.append('\n');
		}
		return new Observation(levelString.toString());
	}

	public abstract Observation getInitialRoomMessage();

	private void setLevel(){
		setRoom();
		putItems();
		putMonsters();
	}

	protected abstract void setRoom();

	protected abstract void putItems();

	protected abstract void putMonsters();

	public Observation walkUp(){
		if(player.getyCoord() > 0 && levelSetup[player.getxCoord()][player.getyCoord()-1].canWalkThrough()){
			player.walkUp();
			roomVisited[player.getxCoord()][player.getyCoord()] = true;
			return new Observation("Walking up.", Observation.ANSI_CYAN)
					.concatObservation(levelSetup[player.getxCoord()][player.getyCoord()].getRoomMessage());
		} else{
			return new Observation("Cannot walk up from here.");
		}
	}

	public Observation walkDown(){
		if(player.getyCoord() < ySize-1 && levelSetup[player.getxCoord()][player.getyCoord()+1].canWalkThrough()){
			player.walkDown();
			roomVisited[player.getxCoord()][player.getyCoord()] = true;
			return new Observation("Walking down.", Observation.ANSI_CYAN)
					.concatObservation(levelSetup[player.getxCoord()][player.getyCoord()].getRoomMessage());
		} else{
			return new Observation("Cannot walk down from here.");
		}
	}

	public Observation walkLeft(){
		if(player.getxCoord() > 0 && levelSetup[player.getxCoord()-1][player.getyCoord()].canWalkThrough()){
			player.walkLeft();
			roomVisited[player.getxCoord()][player.getyCoord()] = true;
			return new Observation("Walking left.", Observation.ANSI_CYAN)
					.concatObservation(levelSetup[player.getxCoord()][player.getyCoord()].getRoomMessage());
		} else{
			return new Observation("Cannot walk left from here.");
		}
	}

	public Observation walkRight(){
		if(player.getxCoord() < xSize-1 && levelSetup[player.getxCoord()+1][player.getyCoord()].canWalkThrough()){
			player.walkRight();
			roomVisited[player.getxCoord()][player.getyCoord()] = true;
			return new Observation("Walking right.", Observation.ANSI_CYAN)
					.concatObservation(levelSetup[player.getxCoord()][player.getyCoord()].getRoomMessage());
		} else{
			return new Observation("Cannot walk right from here.");
		}
	}

	public void toggleCompleted(){
		completed = true;
	}

	public boolean isCompleted() {
		return completed;
	}

	public Room getCurrentRoom() {
		int x = player.getxCoord();
		int y = player.getyCoord();
		return levelSetup[x][y];
	}

	public abstract String getCheatCode();

	public void resetPlayer(){
		player.place(X_START,Y_START);
	}

}
