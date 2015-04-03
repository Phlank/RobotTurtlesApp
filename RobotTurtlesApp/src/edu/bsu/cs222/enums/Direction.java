package edu.bsu.cs222.enums;

import edu.bsu.cs222.R;

public enum Direction {
	NORTH, SOUTH, EAST, WEST;

	private Direction leftTurn;
	private Direction rightTurn;
	private Direction reverseDirection;
	private Integer integerDirection;
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
		
		NORTH.integerDirection = -10;
		SOUTH.integerDirection = 10;
		WEST.integerDirection = -1;
		EAST.integerDirection = 1;

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
	
	public Direction reverseDirection(){
		return reverseDirection;
	}

	public Integer getIntegerDirection() {
		return integerDirection;
	}

	public int setImage() {
		return image;
	}
}
