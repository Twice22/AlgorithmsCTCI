package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Graph {

	private HashMap<String, Node> nodes;
	private HashMap<Integer, Edge> edges;
	
	public Graph() {
		this.nodes = new HashMap<String, Node>();
		this.edges = new HashMap<Integer, Edge>();
	}
	
	public Graph(ArrayList<Node> nodes) {
		this.nodes = new HashMap<String, Node>();
		this.edges = new HashMap<Integer, Edge>();
		
		for (Node n : nodes) {
			this.nodes.put(n.getLabel(), n);
		}
	}
	
	public boolean addEdge(Node n1, Node n2) {
		return addEdge(n1, n2, 1);
	}
	
	public boolean addEdge(Node n1, Node n2, int weight) {
		if ( n1.equals(n2) ) {
			return false;
		}
		Edge e = new Edge(n1, n2, weight);
		if ( edges.containsKey(e.hashCode()) ) {
			return false;
		} else {
			if ( n1.containsNeighbor(e) || n2.containsNeighbor(e) ) {
				return false;
			}
		}
		
		edges.put(e.hashCode(), e);
		n1.addNeighbor(e);
		n2.addNeighbor(e);
		return true;
	}
	
	public boolean containsEdge(Edge e) {
		if ( e.getN1() == null || e.getN2() == null ) {
			return false;
		}
		
		return this.edges.containsKey(e.hashCode());
	}
	
	public Edge removeEdge(Edge e) {
		e.getN1().removeNeighbor(e);
		e.getN2().removeNeighbor(e);
		return this.edges.remove(e.hashCode());
	}
	
	public boolean containsNode(Node node) {
		return this.nodes.get(node.getLabel()) != null;
	}
	
	public Node getNode(String label) {
		return nodes.get(label);
	}
	
	public boolean addNode(Node node, boolean overwriteExisting) {
		Node current = this.nodes.get(node.getLabel());
		if ( current != null ) {
			if ( !overwriteExisting ) {
				return false;
			}
			
			while ( current.getNeighborCount() > 0 ) {
				this.removeEdge(current.getNeighbor(0));
			}
		}
		
		nodes.put(node.getLabel(), node);
		return true;
	}
	
	public Node removeNode(String label) {
		Node n = nodes.remove(label);
		while ( n.getNeighborCount() > 0 ) {
			this.removeEdge(n.getNeighbor(0));
		}
		return n;
	}
	
	public Set<String> nodeKeys() {
		return this.nodes.keySet();
	}
	
	public Set<Edge> getEdges() {
		return new HashSet<Edge>(this.edges.values());
	}
	
	public boolean routeBetween2Nodes(Node n1, Node n2, boolean connected) {
		if ( n1.getNeighborCount() == 0 || n2.getNeighborCount() == 0 ) {
			return false;
		}
		
		n1.visit();
		for ( Edge e :  n1.getNeighbors() ) {
			if ( e.getN1().equals(n2) || e.getN2().equals(n2) ) {
				connected = true;
			}
			
			Node neighborNode = e.getN1().equals(n1) ? e.getN2() : e.getN1();
			if ( !neighborNode.getVisit() ) {
				connected = routeBetween2Nodes(neighborNode, n2, connected);
			}
		}
		
		return connected;
	}
}
