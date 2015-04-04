package edu.bsu.cs222.cards;

import java.util.List;

import android.os.Handler;
import edu.bsu.cs222.MapTileSetter;
import edu.bsu.cs222.enums.Command;

public class CardRunner {

	private MapTileSetter mapTileSetter;
	private boolean running = false;

	public CardRunner(MapTileSetter mapTileSetter) {
		this.mapTileSetter = mapTileSetter;
	}
	
	public void run(Command command) {
		command.performTurtleAction(mapTileSetter);
	}
}
