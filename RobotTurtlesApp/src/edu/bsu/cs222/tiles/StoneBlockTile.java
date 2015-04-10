package edu.bsu.cs222.tiles;

import edu.bsu.cs222.Location;
import edu.bsu.cs222.R;

public class StoneBlockTile extends Tile {

	public StoneBlockTile(Location location) {
		super(location);
	}

	public boolean isStoneBlockTile() {
		return true;
	}

	public int getImage() {
		return R.drawable.stonetile;
	}

}
