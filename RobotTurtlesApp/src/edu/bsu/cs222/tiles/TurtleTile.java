package edu.bsu.cs222.tiles;

import edu.bsu.cs222.Location;
import edu.bsu.cs222.enums.Direction;

public class TurtleTile extends Tile {

	private Direction direction;

	public TurtleTile(Location location) {
		super(location);
		this.direction = Direction.SOUTH;
	}

	public boolean isTurtleTile() {
		return true;
	}

	public Direction getDirection() {
		return direction;
	}

	public Direction turnTurtleLeft() {
		direction = direction.turnLeft();
		return direction;
	}

	public Direction turnTurtleRight() {
		direction = direction.turnRight();
		return direction;
	}

	public int getImage() {
		return direction.setImage();
	}

	public Location getForwardTileLocation() {
		return location.getForwardLocation(this.direction);
	}

	public Location getSecondForwardTileLocation() {
		return location.getSecondForwardLocation(this.direction);
	}

}
