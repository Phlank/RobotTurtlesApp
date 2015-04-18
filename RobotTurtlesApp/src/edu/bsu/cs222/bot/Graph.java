package edu.bsu.cs222.bot;

import java.util.ArrayList;
import java.util.List;

import edu.bsu.cs222.tiles.Tile;

public class Graph {

	private List<Node> nodes;
	private List<Edge> edges;

	public Graph() {
		nodes = new ArrayList<Node>();
		edges = new ArrayList<Edge>();
	}
	
	public void addNode(Node node) {
		nodes.add(node);
	}
	
	public void addEdge(Edge edge) {
		edges.add(edge);
	}
	
	public List<Node> getNodes() {
		return nodes;
	}
	
	public List<Edge> getEdges() {
		return edges;
	}
	
	public Node getNodeCorrespondingToTile(Tile tile) {
		for (Node node : nodes) {
			if (node.getTile().equals(tile)) {
				return node;
			}
		}
		return null;
	}

}
