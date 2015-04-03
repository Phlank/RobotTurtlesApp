package edu.bsu.cs222.finders;

import edu.bsu.cs222.game.maps.GameMap;
import edu.bsu.cs222.tiles.Tile;

public interface Finder {

	public Tile find(GameMap map);

}
