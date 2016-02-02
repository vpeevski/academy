package graph;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.jgrapht.Graph;

public class DijkstraShortestPath {
  
  public static int[] shortestPath(Graph<String, Integer> graph, String startVertex) {
    Object[] vertices = graph.vertexSet().toArray();
    Map<Object, Long> dist = new HashMap<Object, Long>();
    
    for (int i = 0; i < vertices.length; i++) {
      Long initialWeight = Long.valueOf(Integer.MAX_VALUE);
      if (vertices[i].equals(startVertex)) {
        initialWeight = 0L;
      }
      
      dist.put(vertices[i], initialWeight);
    }
    
    Set<String> notVisitedVertexes = graph.vertexSet();
    //notVisitedVertexes.remove(startVertex);
    
    
    return null;
  }
  
  
  public static void main(String[] args) {
    GraphViewApp gViewApp = new GraphViewApp();
    Graph bgMapGraph = GraphStaticFactory.createBgMapGraph();
    gViewApp.showGraph(bgMapGraph);
    DijkstraShortestPath.shortestPath(bgMapGraph, "Pleven");
  }
  
  

}
