package graph;

import org.jgrapht.Graph;
import org.jgrapht.graph.SimpleWeightedGraph;

public final class GraphStaticFactory {
	
	private GraphStaticFactory () {}
	
	public static Graph createBgMapGraph () {
		Graph<String, Integer> graph = new SimpleWeightedGraph<String, Integer>(Integer.class);
		graph.addVertex("Plovdiv");
		graph.addVertex("Sofia");
		graph.addVertex("Stara Zagora");
		graph.addVertex("Varna");
		graph.addVertex("Pleven");
		
		graph.addEdge("Plovdiv", "Sofia", 130);
		graph.addEdge("Plovdiv", "Stara Zagora", 80);
		
		//graph.addEdge("Sofia", 130);
		graph.addEdge("Sofia", "Stara Zagora", 30);
		graph.addEdge("Sofia", "Pleven", 120);
		graph.addEdge("Stara Zagora", "Sofia", 30);
		
		graph.addEdge("Stara Zagora", "Varna", 300);
		graph.addEdge("Pleven", "Varna", 250);
		
		return graph;
	}

}
