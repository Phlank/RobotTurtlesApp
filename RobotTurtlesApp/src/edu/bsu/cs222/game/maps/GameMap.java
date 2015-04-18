package edu.bsu.cs222.game.maps;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import android.annotation.SuppressLint;
import edu.bsu.cs222.Location;
import edu.bsu.cs222.enums.TileType;
import edu.bsu.cs222.tiles.Tile;

@SuppressLint("UseSparseArrays")
public final class GameMap implements Iterable<Tile> {

	private Map<Location, Tile> map;
	private Integer id;

	public GameMap() {
		map = new HashMap<Location, Tile>();
	}

	public void addTile(Location location, String name) {
		map.put(location, TileType.createTileFromName(name, location));
	}

	public void replaceTile(Tile newTile) {
		map.remove(newTile.getLocation());
		map.put(newTile.getLocation(), newTile);
	}

	public boolean isEmpty() {
		return map.isEmpty();
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Tile getTile(Location location) {
		return map.get(location);
	}

	public Integer getMapSize() {
		return map.size();
	}

	@Override
	public Iterator<Tile> iterator() {
		return map.values().iterator();
	}

	public boolean doesLocationExist(Location locationToMove) {
		return map.keySet().contains(locationToMove);
	}
}
