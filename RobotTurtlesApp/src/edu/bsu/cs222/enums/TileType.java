package edu.bsu.cs222.enums;

import edu.bsu.cs222.Location;
import edu.bsu.cs222.tiles.IceBlockTile;
import edu.bsu.cs222.tiles.OpenSpaceTile;
import edu.bsu.cs222.tiles.StoneBlockTile;
import edu.bsu.cs222.tiles.Tile;
import edu.bsu.cs222.tiles.WoodBlockTile;

public enum TileType {

	ICEBLOCK, JEWEL, OPENSPACE, PUDDLE, STONEBLOCK, WOODBLOCK, TURTLE;

	private String string;
	private Tile tile;

	static {
		ICEBLOCK.string = "iceBlockTiles";
		JEWEL.string = "jewelTile";
		OPENSPACE.string = "openSpaceTiles";
		PUDDLE.string = "puddleTiles";
		STONEBLOCK.string = "stoneTiles";
		WOODBLOCK.string = "woodBlockTiles";
		TURTLE.string = "turtleTile";
	}

	public String toString() {
		return this.string;
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
}
