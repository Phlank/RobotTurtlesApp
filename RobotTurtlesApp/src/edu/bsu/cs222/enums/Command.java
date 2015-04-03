package edu.bsu.cs222.enums;

import android.annotation.SuppressLint;
import edu.bsu.cs222.MapTileSetter;
import edu.bsu.cs222.R;

public enum Command {
	FORWARD, @SuppressLint("RtlHardcoded")
	LEFT, RIGHT, LASER;

	private String command;
	private Integer image;
	
	static {
		FORWARD.command = "Forward";
		LEFT.command = "Left";
		RIGHT.command = "Right";
		LASER.command = "Laser";
		
		FORWARD.image = R.drawable.uparrow;
		LEFT.image = R.drawable.leftarrow;
		RIGHT.image = R.drawable.rightarrow;
		LASER.image = R.drawable.laser;
	}
	
	public String setCommand(){
		return command;
	}

	public Integer setImage() {
		return image;
	}
	
	public void performTurtleAction(MapTileSetter mapTileSetter){
		switch(this){
		case FORWARD: mapTileSetter.moveTurtleForward();
			break;
		case RIGHT: mapTileSetter.turnTurtleToRight();
			break;
		case LEFT: mapTileSetter.turnTurtleToLeft();
			break;
		case LASER: mapTileSetter.fireLaser();
			break;
		}
	}
}
