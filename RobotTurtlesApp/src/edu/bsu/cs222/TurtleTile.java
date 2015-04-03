package edu.bsu.cs222;

import edu.bsu.cs222.enums.Direction;
import edu.bsu.cs222.tiles.Tile;

public class TurtleTile extends Tile{

	private Direction direction;
	
	public static Builder withLocation(Location location){
		return new Builder(location);
	}
	
	public static final class Builder{
		private Location location;
		private Direction direction;
		
		private Builder(Location location){
			this.location = location;
		}
		
		public TurtleTile andDirection(Direction direction){
			this.direction = direction;
			return new TurtleTile(this);
		}
	}
	
	private TurtleTile(Builder builder) {
		super(builder.location);
		this.direction = builder.direction;
	}
	
	public boolean isTurtleTile(){
		return true;
	}
	
	public Direction getDirection() {
		return this.direction;
	}

	public Direction turnTurtleLeft() {
		this.direction = this.direction.turnLeft();
		return this.direction;
	}

	public Direction turnTurtleRight() {
		this.direction = this.direction.turnRight();
		return this.direction;
	}

	public int getImage() {
		return this.direction.setImage();
	}

	public Location getForwardTileLocation() {
		return this.getLocation().getForwardLocation(this.direction);
	}

	public Location getSecondForwardTileLocation() {
		return this.getLocation().getSecondForwardLocation(this.direction);
	}
}
