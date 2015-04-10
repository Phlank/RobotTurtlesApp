package edu.bsu.cs222.tiles;

import edu.bsu.cs222.Location;
import edu.bsu.cs222.R;

public class IceBlockTile extends Tile {

	public IceBlockTile(Location location) {
		super(location);
	}

	public boolean isIceBlockTile() {
		return true;
	}

	public int getImage() {
		return R.drawable.icetile;
	}
}
