package edu.bsu.cs222.enums;

import edu.bsu.cs222.Location;
import edu.bsu.cs222.tiles.IceBlockTile;
import edu.bsu.cs222.tiles.JewelTile;
import edu.bsu.cs222.tiles.OpenSpaceTile;
import edu.bsu.cs222.tiles.PuddleTile;
import edu.bsu.cs222.tiles.StoneBlockTile;
import edu.bsu.cs222.tiles.Tile;
import edu.bsu.cs222.tiles.TurtleTile;
import edu.bsu.cs222.tiles.WoodBlockTile;

public enum TileType {

	ICEBLOCK, JEWEL, OPENSPACE, PUDDLE, STONEBLOCK, WOODBLOCK, TURTLE;

	private String name;
	private Tile tile;

	static {
		ICEBLOCK.name = "Ice";
		JEWEL.name = "Jewel";
		OPENSPACE.name = "Open";
		PUDDLE.name = "Puddle";
		STONEBLOCK.name = "Stone";
		WOODBLOCK.name = "Wood";
		TURTLE.name = "Turtle";
	}

	public String toString() {
		return this.name;
	}

	public Tile createTile(Location location) {
		switch (this) {
		case OPENSPACE:
			tile = new OpenSpaceTile(location);
			break;
		case STONEBLOCK:
			tile = new StoneBlockTile(location);
			break;
		case WOODBLOCK:
			tile = new WoodBlockTile(location);
			break;
		case ICEBLOCK:
			tile = new IceBlockTile(location);
			break;
		default:
			break;
		}
		return tile;
	}

	public static Tile createTileFromName(String name, Location location) {
		switch (name) {
		case "Open":
			return new OpenSpaceTile(location);
		case "Stone":
			return new StoneBlockTile(location);
		case "Wood":
			return new WoodBlockTile(location);
		case "Ice":
			return new IceBlockTile(location);
		case "Puddle":
			return new PuddleTile(location);
		case "Jewel":
			return new JewelTile(location);
		case "Turtle":
			return new TurtleTile(location);
		default:
			return null;
		}
	}

}
