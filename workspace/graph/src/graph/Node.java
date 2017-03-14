package graph;

import java.util.ArrayList;

public class Node {

	private String label;
	private ArrayList<Edge> neighbor;
	protected boolean visited = false;
	private double distance = Integer.MAX_VALUE;
	
	public Node(String label) {
		this.label = label;
		this.neighbor = new ArrayList<Edge>();
	}
	
	public void addNeighbor(Edge edge) {
		if ( this.neighbor.contains(edge) ) {
			return;
		}
		this.neighbor.add(edge);
	}
	
	public boolean containsNeighbor(Edge other) {
		return this.neighbor.contains(other);
	}
	
	public Edge getNeighbor(int index) {
		return this.neighbor.get(index);
	}
	
	public Edge removeNeighbor(int index) {
		return this.neighbor.remove(index);
	}
	
	public void removeNeighbor(Edge e){
		this.neighbor.remove(e);
	}

	public int getNeighborCount() {
		return this.neighbor.size();
	}
	
	public String getLabel() {
		return this.label;
	}
	
	public String toString() {
		return "Node " + label;
	}
	
	public int hashCode() {
		return this.label.hashCode();
	}
	
	public boolean equals(Object other) {
		if ( !(other instanceof Node) ) {
			return false;
		}
		Node n = (Node) other;
		return this.label.equals(n.label);
	}
	
	public ArrayList<Edge> getNeighbors() {
		return new ArrayList<Edge>(this.neighbor);
	}
	
	public void visit() {
		this.visited = true;
	}
	
	public boolean getVisit() {
		return this.visited;
	}
}
