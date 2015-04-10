package edu.bsu.cs222.tiles;

import edu.bsu.cs222.Location;
import edu.bsu.cs222.R;
import edu.bsu.cs222.enums.Direction;

public abstract class Tile {

	protected Location location;

	public Tile(Location location) {
		this.location = location;
	}

	public boolean isOpenSpaceTile() {
		return false;
	}

	public boolean isTurtleTile() {
		return false;
	}

	public boolean isStoneBlockTile() {
		return false;
	}

	public boolean isWoodBlockTile() {
		return false;
	}

	public boolean isIceBlockTile() {
		return false;
	}

	public boolean isPuddleTile() {
		return false;
	}

	public boolean isJewelTile() {
		return false;
	}

	public Location setLocation(Location location) {
		return this.location = location;
	}

	public Location getLocation() {
		return this.location;
	}

	public int getImage() {
		return R.drawable.grasstile;
	}

	public Location getNextTile(Direction direction) {
		return this.getLocation().getForwardLocation(direction);
	}
}
