package graph;

public class Edge implements Comparable<Edge> {

	private Node n1, n2;
	private int weight;
	
	public Edge(Node n1, Node n2) {
		this(n1, n2, 1);
	}
	
	public Edge(Node n1, Node n2, int weight) {
		this.n1 = (n1.getLabel().compareTo(n2.getLabel()) <= 0 ) ? n1 : n2;
		this.n2 = (this.n1 == n1) ? n2 : n1;
		this.weight = weight;
	}
	
	public Node getNeighbor(Node current) {
		if ( !(current.equals(n1) || current.equals(n2)) ) {
			return null;
		}
		
		return (current.equals(n1)) ? n2 : n1;
	}
	
	public Node getN1() {
		return this.n1;
	}
	
	public Node getN2() {
		return this.n2;
	}
	
	public int getWeight() {
		return this.weight;
	}
	
	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	public int compareTo(Edge other) {
		return this.weight - other.weight;
	}
	
	public String toString() {
		return "({" + n1 + ", " + n2 + "}, " + weight + ")";
	}
	
	public int hashCode() {
		return (n1.getLabel() + n2.getLabel()).hashCode();
	}
	
	public boolean equals(Object other) {
		if ( !(other instanceof Edge) ) {
			return false;
		}
		Edge e = (Edge)other;
		return e.n1.equals(this.n1) && e.n2.equals(this.n2);
	}
}
