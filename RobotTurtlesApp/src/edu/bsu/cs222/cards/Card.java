package edu.bsu.cs222.cards;

import edu.bsu.cs222.enums.Command;

public class Card {

	private Command command;
	
	public Card(Command command) {
		this.command = command;
	}

	public Command getCommand() {
		return this.command;
	}

	public int getCardImage() {
		return this.command.setImage();
	}
}
