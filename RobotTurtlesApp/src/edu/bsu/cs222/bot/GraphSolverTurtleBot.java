package edu.bsu.cs222.bot;
 
import java.util.ArrayList;
import java.util.List;
 
import edu.bsu.cs222.MapTileSetter;
import edu.bsu.cs222.Utility;
import edu.bsu.cs222.enums.Direction;
import edu.bsu.cs222.finders.JewelFinder;
import edu.bsu.cs222.finders.TurtleFinder;
import edu.bsu.cs222.game.maps.GameMap;
import edu.bsu.cs222.tiles.IceBlockTile;
import edu.bsu.cs222.tiles.JewelTile;
import edu.bsu.cs222.tiles.OpenSpaceTile;
import edu.bsu.cs222.tiles.PuddleTile;
import edu.bsu.cs222.tiles.Tile;
import edu.bsu.cs222.tiles.TurtleTile;
 
public class GraphSolverTurtleBot implements TurtleBot {
 
	private Graph graph;
	private MapTileSetter setter;
	private GameMap map;
	private Tile turtleTile;
	private Tile jewelTile;
	private Node turtleNode;
	private Node jewelNode;
	private Node nextNode;
	private List<Path> paths;
	private Path solutionPath;
 
	public GraphSolverTurtleBot(MapTileSetter setter, GameMap map) {
		this.setter = setter;
		this.map = map;
		graph = new Graph();
		paths = new ArrayList<Path>();
		findRelevantTiles();
		buildGraph();
	}
 
	private void findRelevantTiles() {
		TurtleFinder turtleFinder = new TurtleFinder();
		turtleTile = turtleFinder.find(map);
		JewelFinder jewelFinder = new JewelFinder();
		jewelTile = jewelFinder.find(map);
	}
 
	private void buildGraph() {
		addNodesToGraph();
		addEdgesToNodes();
		makePaths();
	}
 
	private void addNodesToGraph() {
		for (Tile tile : map) {
			if (tile.getClass().equals(IceBlockTile.class)
					|| tile.getClass().equals(JewelTile.class)
					|| tile.getClass().equals(OpenSpaceTile.class)
					|| tile.getClass().equals(PuddleTile.class)
					|| tile.getClass().equals(TurtleTile.class)) {
				Node tileNode = new Node(tile);
				graph.addNode(tileNode);
				if (tileNode.getTile().equals(turtleTile)) {
					turtleNode = tileNode;
				} else if (tileNode.getTile().equals(jewelTile)) {
					jewelNode = tileNode;
				}
			}
		}
	}
 
	private void addEdgesToNodes() {
		for (Node node : graph.getNodes()) {
			for (Direction direction : Direction.values()) {
				Node nextNode = getNextNode(node, direction);
				if (nextNode != null) {
					Edge edge = new Edge(node, nextNode);
					graph.addEdge(edge);
				}
			}
		}
	}
 
	private Node getNextNode(Node node, Direction direction) {
		Tile nextTile = getTileAtNextLocation(node.getTile(), direction);
		return graph.getNodeCorrespondingToTile(nextTile);
	}
 
	private Tile getTileAtNextLocation(Tile tile, Direction direction) {
		return map.getTile(tile.getNextLocation(direction));
	}
 
	private void makePaths() {
		startFirstPath();
		continuePaths();
	}
 
	private void startFirstPath() {
		Path path = new Path();
		path.addNode(turtleNode);
		paths.add(path);
	}
 
	private void continuePaths() {
		List<Integer> oldIndexes = new ArrayList<Integer>();
		List<Path> oldPaths = Utility.copyPaths(paths);
		for (Path oldPath : oldPaths) {
			oldIndexes.add(paths.indexOf(oldPath));
			for (Edge edge : oldPath.getLastNode().getEdges()) {
				Path newPath = new Path(oldPath);
				if (newPath.addNode(edge.getEnd())) {
					paths.add(newPath);
					if (edge.getEnd().equals(jewelNode)) {
						solutionPath = newPath;
						return;
					}
				}
			}
		}
		for (Integer index : oldIndexes) {
			paths.remove(index);
		}
		continuePaths();
	}
 
	public void go() {
		if (nextNode == null) {
			nextNode = solutionPath.next();
		}
		if (!turnTurtleTowardsNextNode()) {
			moveTurtleToNextNode();
		}
	}
	
	private boolean turnTurtleTowardsNextNode() {
		if (!setter.getForwardTile().equals(nextNode.getTile())) {
			setter.turnTurtleToLeft();
			return true;
		}
		return false;
	}
	
	private void moveTurtleToNextNode() {
		if (!meltNextNodeIfIce()) {
			setter.moveTurtleForward();
			nextNode = solutionPath.next();
		}
		meltNextNodeIfIce();
	}
	
	private boolean meltNextNodeIfIce() {
		if (nextNode.getClass().equals(IceBlockTile.class)) {
			setter.fireLaser();
			return true;
		}
		return false;
	}
 
}