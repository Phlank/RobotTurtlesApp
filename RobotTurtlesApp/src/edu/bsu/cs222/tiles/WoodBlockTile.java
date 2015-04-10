package edu.bsu.cs222.tiles;

import edu.bsu.cs222.Location;
import edu.bsu.cs222.R;

public class WoodBlockTile extends Tile {

	public WoodBlockTile(Location location) {
		super(location);
	}

	public boolean isWoodBlockTile() {
		return true;
	}

	public int getImage() {
		return R.drawable.woodtile;
	}
}
