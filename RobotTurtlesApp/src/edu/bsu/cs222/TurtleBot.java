package edu.bsu.cs222;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import edu.bsu.cs222.game.maps.GameMap;

import edu.bsu.cs222.tiles.Tile;

public class TurtleBot {
	
	private Stack<Tile> visited = new Stack<Tile>();
	private List<Tile> deadEnds = new ArrayList<Tile>();
	private TurtleMover mover;
	private GameMap map;
	
	public TurtleBot() {
		
	}

	public void go() {
		if (mover.canMoveFoward()) {
			Location lastLocation = mover.getTile().getLocation();
			mover.moveForward();
			Tile visitedTile = map.getTile(lastLocation);
		}
	}

}
