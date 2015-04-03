package edu.bsu.cs222.tiles;

import edu.bsu.cs222.Location;
import edu.bsu.cs222.R;

public class OpenSpaceTile extends Tile {

	public OpenSpaceTile(Location location) {
		super(location);
	}

	public boolean isOpenSpaceTile() {
		return true;
	}

	public int getImage() {
		return R.drawable.grasstile;
	}
}
