package edu.bsu.cs222.bot;

import java.util.ArrayList;
import java.util.List;

public class Node {
	
	private List<Edge> edges;
	private List<Node> connections;
	
	public Node() {
		edges = new ArrayList<Edge>();
		connections = new ArrayList<Node>();
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

}
