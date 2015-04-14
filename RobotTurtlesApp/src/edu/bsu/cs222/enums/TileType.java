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

	public static final String ICE_NAME = "Ice";
	public static final String JEWEL_NAME = "Jewel";
	public static final String OPEN_NAME = "Open";
	public static final String PUDDLE_NAME = "Puddle";
	public static final String STONE_NAME = "Stone";
	public static final String WOOD_NAME = "Wood";
	public static final String TURTLE_NAME = "Turtle";
	
	public String name;
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
		case OPEN_NAME:
			return new OpenSpaceTile(location);
		case STONE_NAME:
			return new StoneBlockTile(location);
		case WOOD_NAME:
			return new WoodBlockTile(location);
		case ICE_NAME:
			return new IceBlockTile(location);
		case PUDDLE_NAME:
			return new PuddleTile(location);
		case JEWEL_NAME:
			return new JewelTile(location);
		case TURTLE_NAME:
			return new TurtleTile(location);
		default:
			return null;
		}
	}

}
