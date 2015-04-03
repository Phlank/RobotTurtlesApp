package edu.bsu.cs222.finders;

import edu.bsu.cs222.Location;
import edu.bsu.cs222.TurtleTile;
import edu.bsu.cs222.enums.Direction;
import edu.bsu.cs222.game.maps.GameMap;
import edu.bsu.cs222.tiles.Tile;

public class TurtleFinder implements Finder {

	private TurtleTile turtle = TurtleTile.withLocation(new Location(-1)).andDirection(Direction.SOUTH);

	@Override
	public Tile find(GameMap map) {
		for (Tile tile : map) {
			if (tile.isTurtleTile()) {
				return (TurtleTile) tile;
			}
		}
		return turtle;
	}
}
