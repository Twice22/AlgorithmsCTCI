package diGraph;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Digraph<V> {

    public static class Edge<V>{
        private V vertex;
        private int cost;
        private boolean visited = false;

        public Edge(V v, int c){
            vertex = v; cost = c;
        }

        public V getVertex() {
            return vertex;
        }

        public int getCost() {
            return cost;
        }
        
        public void visited() {
        	this.visited = true;
        }
        
        public boolean isVisited() {
        	return this.visited;
        }

        @Override
        public String toString() {
            return "Edge [vertex=" + vertex + ", cost=" + cost + "]";
        }

    }

    /**
     * A Map is used to map each vertex to its list of adjacent vertices.
     */

    private Map<V, List<Edge<V>>> neighbors = new HashMap<V, List<Edge<V>>>();

    private int nr_edges;

    /**
     * String representation of graph.
     */
    public String toString() {
        StringBuffer s = new StringBuffer();
        for (V v : neighbors.keySet())
            s.append("\n    " + v + " -> " + neighbors.get(v));
        return s.toString();
    }

    /**
     * Add a vertex to the graph. Nothing happens if vertex is already in graph.
     */
    public void add(V vertex) {
        if (neighbors.containsKey(vertex))
            return;
        neighbors.put(vertex, new ArrayList<Edge<V>>());
    }

    public int getNumberOfEdges(){
        int sum = 0;
        for(List<Edge<V>> outBounds : neighbors.values()){
            sum += outBounds.size();
        }
        return sum;
    }

    /**
     * True iff graph contains vertex.
     */
    public boolean contains(V vertex) {
        return neighbors.containsKey(vertex);
    }

    /**
     * Add an edge to the graph; if either vertex does not exist, it's added.
     * This implementation allows the creation of multi-edges and self-loops.
     */
    public void add(V from, V to, int cost) {
        this.add(from);
        this.add(to);
        neighbors.get(from).add(new Edge<V>(to, cost));
    }

    public int outDegree(int vertex) {
        return neighbors.get(vertex).size();
    }

    public int inDegree(V vertex) {
       return inboundNeighbors(vertex).size();
    }

    public List<V> outboundNeighbors(V vertex) {
        List<V> list = new ArrayList<V>();
        for(Edge<V> e: neighbors.get(vertex))
            list.add(e.vertex);
        return list;
    }

    public List<V> inboundNeighbors(V inboundVertex) {
        List<V> inList = new ArrayList<V>();
        for (V to : neighbors.keySet()) {
            for (Edge e : neighbors.get(to))
                if (e.vertex.equals(inboundVertex))
                    inList.add(to);
        }
        return inList;
    }

    public boolean isEdge(V from, V to) {
      for(Edge<V> e :  neighbors.get(from)){
          if(e.vertex.equals(to))
              return true;
      }
      return false;
    }

    public int getCost(V from, V to) {
        for(Edge<V> e :  neighbors.get(from)){
            if(e.vertex.equals(to))
                return e.cost;
        }
        return -1;
    }
    
    public boolean bfs(V from, V to) {
    	Queue<V> queue = new ConcurrentLinkedQueue<V>();
    	
    }
    
    public static void main(String[] args) throws IOException {

        Digraph<Integer> graph = new Digraph<Integer>();
        Random rand = new Random();
        
        for ( int i = rand.nextInt(10), k = 0; k < 10; i = rand.nextInt(10) ) {
        	graph.add(k);
        	graph.add(k++, i, 1);
        }
        
        for ( int i = rand.nextInt(10), k = 0; k < 10; i = rand.nextInt(10) ) {
        	graph.add(i, k++, 1);
        }
        
        System.out.println("The current graph: " + graph);
    }
   
}
