package edu.bsu.cs222;

import java.util.Objects;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.os.Build;
import edu.bsu.cs222.enums.Direction;

@TargetApi(Build.VERSION_CODES.KITKAT)
@SuppressLint("NewApi")
public class Location {

	private int[] location = { 0, 0 };

	public Location(int row, int col) {
		location[0] = row;
		location[1] = col;
	}

	public Location(int[] coordinates) {
		location[0] = coordinates[0];
		location[1] = coordinates[1];
	}

	public int[] getTileLocation() {
		return location;
	}

	public Location getForwardLocation(Direction direction) {
		return addDirectionToLocation(this, direction);
	}

	public Location getSecondForwardLocation(Direction direction) {
		return addDirectionToLocation(addDirectionToLocation(this, direction),
				direction);
	}

	private Location addDirectionToLocation(Location loc, Direction dir) {
		return new Location(loc.location[0] + dir.locationModifier()[0],
				loc.location[1] + dir.locationModifier()[1]);
	}

	@Override
	public int hashCode() {
		return Objects.hash(location[0], location[1]);
	}

	@Override
	public boolean equals(Object object) {
		if (object == null) {
			return false;
		} else if (!object.getClass().equals(Location.class)) {
			return false;
		} else {
			Location other = (Location) object;
			if (this.location[0] == other.location[0]
					&& this.location[1] == other.location[1]) {
				return true;
			} else {
				return false;
			}
		}
	}

}
