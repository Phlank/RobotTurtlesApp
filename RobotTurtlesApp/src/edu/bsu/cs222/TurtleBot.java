package edu.bsu.cs222;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import edu.bsu.cs222.enums.Direction;
import edu.bsu.cs222.game.maps.GameMap;
import edu.bsu.cs222.tiles.OpenSpaceTile;
import edu.bsu.cs222.tiles.Tile;

public class TurtleBot {

	private static final int WEST_BLOCK_MODIFIER = -1;
	private static final int EAST_BLOCK_MODIFIER = 1;
	private static final int NORTH_BLOCK_MODIFIER = -8;
	private static final int SOUTH_BLOCK_MODIFIER = 8;
	
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
			mover.getTile().turnTurtleLeft();
			leftCount++;
			if (mover.getTile().getNextTile(mover.getTile().getDirection())
					.getClass().equals(OpenSpaceTile.class)) {
				mover.getTile().turnTurtleLeft();
				leftCount++;
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
		moveToLastVisitedTile();
		deadEnds.add(map.getTile(deadLocation));
		go();
	}

	// Turtle turns left until it faces the last visited tile and moves forward
	private void moveToLastVisitedTile() {
		// West
		if (visited.peek().getLocation().getTileLocation() == mover.getTile()
				.getLocation().getTileLocation() - WEST_BLOCK_MODIFIER) {
			while (mover.getTile().getDirection() != Direction.WEST) {
				mover.getTile().turnTurtleLeft();
			}
		}
		// East
		else if (visited.peek().getLocation().getTileLocation() == mover
				.getTile().getLocation().getTileLocation() + EAST_BLOCK_MODIFIER) {
			while (mover.getTile().getDirection() != Direction.EAST) {
				mover.getTile().turnTurtleLeft();
			}
		}
		// North
		else if (visited.peek().getLocation().getTileLocation() == mover
				.getTile().getLocation().getTileLocation() - NORTH_BLOCK_MODIFIER) {
			while (mover.getTile().getDirection() != Direction.NORTH) {
				mover.getTile().turnTurtleLeft();
			}
		}
		// South
		else if (visited.peek().getLocation().getTileLocation() == mover
				.getTile().getLocation().getTileLocation() - SOUTH_BLOCK_MODIFIER){
			while (mover.getTile().getDirection() != Direction.SOUTH) {
				mover.getTile().turnTurtleLeft();
			}
		}
	}

}
