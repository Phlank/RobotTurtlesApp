package edu.bsu.cs222.game.maps;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import android.annotation.SuppressLint;
import edu.bsu.cs222.Location;
import edu.bsu.cs222.enums.TileType;
import edu.bsu.cs222.tiles.Tile;

@SuppressLint("UseSparseArrays")
public final class GameMap implements Iterable<Tile>{

	private Tile tile;
	private HashMap<Location, Tile> map = new HashMap<Location, Tile>();
	private Integer id;
	
	public static GameMap create() {
		return new GameMap();
	}

	private GameMap() {
	}

	public boolean isEmpty() {
		return map.isEmpty();
	}

	public Integer getId(){
		return this.id;
	}
	
	public void setId(Integer id){
		this.id = id;
	}

	public void addSingleTileToMap(Tile tile) {
		map.put(tile.getLocation(), tile);
	}

	public void addTilesToMap(List<Integer> ids, TileType tileType) {
		for (int i = 0; i < ids.size(); i++) {
			Location location = new Location(ids.get(i));
			tile = tileType.createTile(location);
			map.put(tile.getLocation(), tile);
		}
	}

	public Tile getTile(Location location) {
		Tile tile = map.get(location);
		return tile;
	}
	
	public Integer getMapSize(){
		return map.size();
	}

	@Override
	public Iterator<Tile> iterator() {
		return map.values().iterator();
	}
	
	public boolean doesLocationExist(Location locationToMove){
		return map.containsKey(locationToMove);
	}
}
