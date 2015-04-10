package edu.bsu.cs222.finders;

import edu.bsu.cs222.game.maps.GameMap;
import edu.bsu.cs222.tiles.Tile;
import edu.bsu.cs222.tiles.TurtleTile;

public class TurtleFinder implements Finder {

	@Override
	public TurtleTile find(GameMap map) {
		for (Tile tile : map) {
			if (tile.isTurtleTile()) {
				return (TurtleTile) tile;
			}
		}
		return null;
	}
}
