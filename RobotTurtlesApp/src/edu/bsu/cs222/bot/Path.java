package edu.bsu.cs222.bot;

import java.util.ArrayList;

import edu.bsu.cs222.tiles.IceBlockTile;

public class Path {
	
	private ArrayList<Node> nodes;
	private int currentIndex;
	
	public Path() {
		nodes = new ArrayList<Node>();
		currentIndex = 0;
	}
	
	public Path(Path path) {
		nodes = new ArrayList<Node>();
		copyPathNodesToNewList(path);
		currentIndex = path.currentIndex;
	}
	
	private void copyPathNodesToNewList(Path path) {
		for (Node node : path.nodes) {
			nodes.add(node);
		}
	}
	
	public boolean addNode(Node node) {
		if (node != null) {
			if (nodes.contains(node)) {
				return false;
			}
			nodes.add(node);
			return true;
		}
		return false;
	}
	
	public Node next() {
		if (currentIndex < nodes.size() - 1) {
			currentIndex++;
			return nodes.get(currentIndex);
		} else {
			return nodes.get(nodes.size() - 1);
		}
	}
	
	public int length() {
		return nodes.size();
	}
	
	public Node getLastNode() {
		return nodes.get(nodes.size() - 1);
	}
	
	public void replaceNode(Node toRemove, Node toAdd) {
		int index = nodes.indexOf(toRemove);
		nodes.remove(toRemove);
		nodes.add(index, toAdd);
	}

}
