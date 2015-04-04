package edu.bsu.cs222;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import edu.bsu.cs222.enums.Direction;
import edu.bsu.cs222.game.maps.GameMap;
import edu.bsu.cs222.tiles.OpenSpaceTile;
import edu.bsu.cs222.tiles.Tile;

public class TurtleBot {
	
	private Stack<Tile> visited = new Stack<Tile>();
	private List<Tile> deadEnds = new ArrayList<Tile>();
	private TurtleMover mover;
	private GameMap map;
	private int leftCount = 0;
	
	public TurtleBot() {
		
	}

	public void go() {
		if (mover.canMoveFoward()) {
			Location lastLocation = mover.getTile().getLocation();
			mover.moveForward();
			visited.push(map.getTile(lastLocation));
			leftCount = 0;
		} else {
			mover.getTile().turnTurtleLeft(); leftCount++;
			if (mover.getTile().getNextTile(mover.getTile().getDirection()).getClass().equals(OpenSpaceTile.class)) {
				mover.getTile().turnTurtleLeft(); leftCount++;
				go();
			} else {
				if (leftCount == 4) {
					deadEnd();
				} else {
					go();
				}
			}
		}
	}
	
	public void deadEnd() {
		Location deadLocation = mover.getTile().getLocation();
		visited.peek();
	}
	
	private Direction getDirectionToLastVisitedTile() {
		if (visited.peek().getLocation().getTileLocation() == mover.getTile().getLocation().getTileLocation() - 1) { //West
			
		} else if (visited.peek().getLocation().getTileLocation() == mover.getTile().getLocation().getTileLocation() + 1) { //East
			
		} else if (visited.peek().getLocation().getTileLocation() == mover.getTile().getLocation().getTileLocation() - 8) { //North
			
		} else { //South
			
		}
		return null;
	}

}
