package edu.bsu.cs222.tiles;

import edu.bsu.cs222.Location;
import edu.bsu.cs222.R;

public class PuddleTile extends Tile {

	public PuddleTile(Location location) {
		super(location);
	}

	public boolean isOpenSpaceTile() {
		return true;
	}
	
	public boolean isPuddleTile(){
		return true;
	}

	public int getImage() {
		return R.drawable.puddletile;
	}
}
