package edu.bsu.cs222.finders;

import android.util.Log;
import edu.bsu.cs222.game.maps.GameMap;
import edu.bsu.cs222.tiles.Tile;
import edu.bsu.cs222.tiles.TurtleTile;

public class TurtleFinder implements Finder {

	@Override
	public TurtleTile find(GameMap map) {
		for (Tile tile : map) {
			if (tile != null && tile.isTurtleTile()) {
				Log.d("TurtleFinder", "Turtle found at tile " + tile.toString() + " at location " + tile.getLocation().getTileLocation()[0] + "," + tile.getLocation().getTileLocation()[1]);
				return (TurtleTile) tile;
			}
		}
		return null;
	}
}
