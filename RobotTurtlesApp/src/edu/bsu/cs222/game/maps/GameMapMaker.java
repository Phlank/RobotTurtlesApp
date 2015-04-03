package edu.bsu.cs222.game.maps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import edu.bsu.cs222.Location;
import edu.bsu.cs222.TurtleTile;
import edu.bsu.cs222.enums.Direction;
import edu.bsu.cs222.enums.TileType;
import edu.bsu.cs222.tiles.JewelTile;

public class GameMapMaker {

	private Document document;
	private Element element;
	private GameMap gameMap = GameMap.create();
	private ArrayList<TileType> listOfTileTypes = new ArrayList<>();
	private static final Integer FIRST_CHILD = 0;

	public GameMapMaker(Document document) {
		this.document = document;
	}

	public GameMap createMap(Integer gameMapId) {
		gameMap.setId(gameMapId);
	    createListOfTileTypes();
	    Node node = getNode(gameMapId);
		if (node.getNodeType() == Node.ELEMENT_NODE) {
			element = (Element) node;
			addAllTilesToMap();
		}
		return gameMap;
	}

	private void createListOfTileTypes(){
		List<TileType> list = Arrays.asList(TileType.OPENSPACE, TileType.STONEBLOCK, TileType.WOODBLOCK, TileType.ICEBLOCK);
		listOfTileTypes.addAll(list);
	}
	
	private Node getNode(Integer gameMapId){
	    NodeList nodeList = document.getElementsByTagName("PlayerMap" + gameMapId);
	    return nodeList.item(FIRST_CHILD);
	}
	
	private void addAllTilesToMap(){
		for (TileType tileType : listOfTileTypes) {
			addTiles(tileType);
		}
	    addJewelTile();
	    addTurtleTile();
	}
	
	private void addTiles(TileType tileType){
	    String idString = getTileIdString(tileType.toString());
	    List<Integer> ids = splitNumbers(idString);
	    gameMap.addTilesToMap(ids, tileType);
	}
	
	private String getTileIdString(String name) {
		String idString = element.getElementsByTagName(name).item(FIRST_CHILD)
				.getTextContent();
		return idString;
	}

	private List<Integer> splitNumbers(String listOfNumbers) {
		String punctuation = ",";
		StringTokenizer st = new StringTokenizer(listOfNumbers, punctuation);
		List<Integer> listOfNumbersInData = new ArrayList<>();

		while (st.hasMoreTokens()) {
			listOfNumbersInData.add(Integer.valueOf(st.nextToken()));
		}
		return listOfNumbersInData;
	}

	private void addJewelTile() {
		String jewelIdString = getTileIdString("jewelTile");
		Location jewelLocation = new Location(Integer.valueOf(jewelIdString));
		gameMap.addSingleTileToMap(new JewelTile(jewelLocation));
	}
	
	private void addTurtleTile(){
		String turtleIdString = getTileIdString("turtleTile");
		Integer turtleLocation = Integer.valueOf(turtleIdString);
		TurtleTile turtle = TurtleTile.withLocation(new Location(turtleLocation)).andDirection(Direction.SOUTH);
		gameMap.addSingleTileToMap(turtle);
	}
}
