package edu.bsu.cs222.enums;

import edu.bsu.cs222.R;

public enum Direction {
	NORTH, SOUTH, EAST, WEST;

	private Direction leftTurn;
	private Direction rightTurn;
	private Direction reverseDirection;
	private int[] locationModifier = { 0, 0 };
	private int image;

	static {
		NORTH.leftTurn = WEST;
		NORTH.rightTurn = EAST;
		SOUTH.leftTurn = EAST;
		SOUTH.rightTurn = WEST;

		EAST.leftTurn = NORTH;
		EAST.rightTurn = SOUTH;
		WEST.leftTurn = SOUTH;
		WEST.rightTurn = NORTH;

		NORTH.reverseDirection = SOUTH;
		SOUTH.reverseDirection = NORTH;
		EAST.reverseDirection = WEST;
		WEST.reverseDirection = EAST;

		NORTH.locationModifier[0] = -1;
		SOUTH.locationModifier[0] = 1;
		WEST.locationModifier[1] = -1;
		EAST.locationModifier[1] = 1;

		NORTH.image = R.drawable.turtletileup;
		SOUTH.image = R.drawable.turtletiledown;
		EAST.image = R.drawable.turtletileright;
		WEST.image = R.drawable.turtletileleft;
	}

	public Direction turnLeft() {
		return leftTurn;
	}

	public Direction turnRight() {
		return rightTurn;
	}

	public Direction reverseDirection() {
		return reverseDirection;
	}

	public int[] locationModifier() {
		return locationModifier;
	}

	public int setImage() {
		return image;
	}
}
