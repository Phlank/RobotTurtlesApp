package edu.bsu.cs222.tiles;

import java.util.Objects;

import android.annotation.SuppressLint;
import edu.bsu.cs222.Location;
import edu.bsu.cs222.R;
import edu.bsu.cs222.enums.Direction;

@SuppressLint("NewApi")
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

	public Location getNextLocation(Direction direction) {
		return this.getLocation().getForwardLocation(direction);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(location);
	}
	
	@Override
	public boolean equals(Object o) {
		if (o == null) {
			return false;
		}
		if (o.getClass().equals(this.getClass())) {
			Tile other = (Tile) o;
			if (this.location.equals(other.location)) {
				return true;
			}
		}
		return false;
	}
}
