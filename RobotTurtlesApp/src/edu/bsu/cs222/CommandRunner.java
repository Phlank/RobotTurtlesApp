package edu.bsu.cs222;

import java.util.List;

import android.os.Handler;
import edu.bsu.cs222.enums.Command;

public class CommandRunner {

	private MapTileSetter mapTileSetter;
	private boolean running = false;

	public CommandRunner(MapTileSetter mapTileSetter) {
		this.mapTileSetter = mapTileSetter;
	}
	
	public void run(Command command) {
		command.performTurtleAction(mapTileSetter);
	}
}
