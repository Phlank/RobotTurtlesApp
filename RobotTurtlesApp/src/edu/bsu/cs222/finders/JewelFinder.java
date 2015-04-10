package edu.bsu.cs222.finders;

import edu.bsu.cs222.Location;
import edu.bsu.cs222.game.maps.GameMap;
import edu.bsu.cs222.tiles.JewelTile;
import edu.bsu.cs222.tiles.Tile;

public class JewelFinder implements Finder {

	private static final int[] INIT_JEWEL = { -1, -1 };
	private JewelTile jewel = new JewelTile(new Location(INIT_JEWEL));

	@Override
	public JewelTile find(GameMap map) {
		for (Tile tile : map) {
			if (tile.isJewelTile()) {
				return (JewelTile) tile;
			}
		}
		return jewel;
	}
}
