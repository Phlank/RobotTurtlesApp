package edu.bsu.cs222.game.maps;

import org.w3c.dom.Document;

import edu.bsu.cs222.MapTileSetter;
import edu.bsu.cs222.activities.MapMenuItem;

public class GameMapSelecter {

	private MapTileSetter mapTileSetter;
	private Integer currentMap;
	private GameMap gameMap;
	private static final Integer INITIAL_MAP = 1;
	private Document document;

	public GameMapSelecter(MapTileSetter mapTileSetter) {
		this.mapTileSetter = mapTileSetter;
	}

	public Integer getCurrentMap() {
		return currentMap;
	}

	public void createInitialMap(Document document) {
		currentMap = INITIAL_MAP;
		this.document = document;
		setGameMap(INITIAL_MAP);
	}

	public void mapSelecter(MapMenuItem mapMenuItem) {
		Integer mapMenuId = mapMenuItem.getMapId();
		currentMap = Integer.valueOf(mapMenuId);
		setGameMap(mapMenuId);
	}

	private void setGameMap(Integer mapMenuId) {
		gameMap = GameMapMaker.createMap(document, mapMenuId);
		mapTileSetter.setMap(gameMap);
		mapTileSetter.setTiles();
	}
}
