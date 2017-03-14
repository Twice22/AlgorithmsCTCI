package graph;

import java.util.Random;

public class DemoGraph {

	public static void main(String args[]) {
		Random rand = new Random();
		Graph graph = new Graph();
		Node[] nodes = new Node[10];
		int len = nodes.length;
		
		for ( int i = 0; i < len; i++ ) {
			nodes[i] = new Node("" + i);
			graph.addNode(nodes[i], true);
		}
		
		
		// add some edges randomly
		for ( int i = rand.nextInt(len), k = 0; k < len/2; i = rand.nextInt(len) ) {
			graph.addEdge(nodes[i], nodes[k++]);			
		}
		
		for ( int i = rand.nextInt(len), k = 0; k < len/2; i = rand.nextInt(len) ) {
			graph.addEdge(nodes[k++], nodes[i]);			
		}
		
		// display the graph
		for(int i = 0; i < len; i++){
			System.out.println(nodes[i]);

			for(int j = 0; j < nodes[i].getNeighborCount(); j++){
				System.out.println(nodes[i].getNeighbor(j));
			}
			System.out.println();
		}
		
		Node n1 = nodes[rand.nextInt(len/2)];
		Node n2 = nodes[rand.nextInt(len/2)];		
		System.out.println("path (" + n1.getLabel() + ", " + n2.getLabel() + ") : " + graph.routeBetween2Nodes(n1, n2, false) );
		
	}
	
}
