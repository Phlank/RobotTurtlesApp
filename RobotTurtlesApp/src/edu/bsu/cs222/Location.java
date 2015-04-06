package edu.bsu.cs222;

import java.util.Objects;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.os.Build;
import edu.bsu.cs222.enums.Direction;

@TargetApi(Build.VERSION_CODES.KITKAT)
@SuppressLint("NewApi")
public class Location {

	private Integer location;

	public Location(Integer location) {
		this.location = location;
	}

	public Integer getTileLocation() {
		return this.location;
	}

	public Location getForwardLocation(Direction direction) {
		Integer integerDirection = direction.getIntegerDirection();
		return new Location(this.location + integerDirection);
	}

	public Location getSecondForwardLocation(Direction direction) {
		Integer integerDirection = 2 * direction.getIntegerDirection();
		return new Location(this.location + integerDirection);
	}

	@Override
	public int hashCode() {
		return Objects.hash(location);
	}

	@Override
	public boolean equals(Object object) {
		if (object instanceof Location) {
			Location other = (Location) object;
			return Objects.equals(this.location, other.location);
		}
		return false;
	}
}
