package edu.bsu.cs222.tiles;

import edu.bsu.cs222.Location;
import edu.bsu.cs222.R;

public class JewelTile extends Tile {

	public JewelTile(Location location) {
		super(location);
	}

	public boolean isOpenSpaceTile() {
		return true;
	}

	public boolean isJewelTile() {
		return true;
	}

	public int getImage() {
		return R.drawable.gemtile;
	}
}
