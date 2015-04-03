package edu.bsu.cs222.finders;

import edu.bsu.cs222.game.maps.GameMap;
import edu.bsu.cs222.tiles.Tile;

public class TileFinder {

	private Finder finder;

	public TileFinder(Finder finder) {
		this.finder = finder;
	}

	public Tile findTile(GameMap map) {
		return finder.find(map);
	}
}