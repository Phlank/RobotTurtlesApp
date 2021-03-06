package edu.bsu.cs222.bot;

public class Edge {

	private Node start;
	private Node end;

	public Edge(Node start, Node end) {
		this.start = start;
		this.end = end;
		start.addEdge(this);
	}

	public Node getEnd() {
		return end;
	}
	
	public boolean hasNode(Node node) {
		return start.equals(node) || end.equals(node);
	}

}
