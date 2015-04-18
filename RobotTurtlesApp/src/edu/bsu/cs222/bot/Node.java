package edu.bsu.cs222.bot;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import android.annotation.SuppressLint;
import edu.bsu.cs222.tiles.Tile;

@SuppressLint("NewApi") 
public class Node {

	private List<Edge> edges;
	private List<Node> connections;
	private Tile tile;

	public Node(Tile tile) {
		edges = new ArrayList<Edge>();
		connections = new ArrayList<Node>();
		this.tile = tile;
	}

	public void addEdge(Edge edge) {
		edges.add(edge);
		connections.add(edge.getEnd());
	}

	public List<Edge> getEdges() {
		return edges;
	}

	public List<Node> getConnections() {
		return connections;
	}
	
	public Tile getTile() {
		return tile;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(tile);
	}
	
	@Override
	public boolean equals(Object o) {
		if (o == null) {
			return false;
		}
		if (o.getClass().equals(Node.class)) {
			Node other = (Node) o;
			if (this.tile.equals(other.tile)) {
				return true;
			}
		}
		return false;
	}

}
