package edu.bsu.cs222.game.maps;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import android.util.Log;
import edu.bsu.cs222.Location;

public class GameMapMaker {

	public static List<GameMap> createMaps(Document document) {
		List<GameMap> maps = new ArrayList<GameMap>();
		NodeList mapNodes = document.getElementsByTagName("playerMap");
		for (int mapId = 0; mapId < mapNodes.getLength(); mapId++) {
			GameMap map = new GameMap();
			Element mapNode = (Element) mapNodes.item(mapId);
			NodeList rowNodes = mapNode.getElementsByTagName("row");
			Log.d("GameMapMaker", "Number of row nodes for map " + mapId + ": "
					+ rowNodes.getLength());
			for (int row = 0; row < rowNodes.getLength(); row++) {
				Element rowNode = (Element) rowNodes.item(row);
				NodeList tileNodes = rowNode.getElementsByTagName("tile");
				Log.d("GameMapMaker", "Number of column nodes for map " + mapId
						+ " row " + row + ": " + tileNodes.getLength());
				for (int col = 0; col < tileNodes.getLength(); col++) {
					Element tileNode = (Element) tileNodes.item(col);
					Location location = new Location(row, col);
					map.addTile(location, tileNode.getTextContent());
				}
			}
			maps.add(map);
		}
		return maps;
	}

	public static GameMap createMap(Document document, int mapIndex) {
		return createMaps(document).get(mapIndex - 1);
	}
}
