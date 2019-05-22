package muic.ooc.zork.location.levels;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LevelIterator {

	private static final List<Level> LEVELS_LIST = new ArrayList<Level>(){{
		add(new LevelOne());
		add(new LevelTwo());
		add(new Pitfall());
		add(new LevelThree());
	}};

	private static Iterator<Level> levelIterator = LEVELS_LIST.iterator();

	public static Level nextLevel(){
		return levelIterator.next();
	}

	public static void reset(){
		levelIterator = LEVELS_LIST.iterator();
	}

	public static boolean hasNextLevel(){
		return levelIterator.hasNext();
	}

}
