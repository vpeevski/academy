package graph;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.jgrapht.Graph;

public class BellmanFordShortestPath {
 
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
    
//    graph.e
    Object[] edges = graph.edgeSet().toArray();
    for (int v = 0; v < vertices.length - 1; v++) {
      for (int e = 0; e < edges.length; e++) {
        Integer edgeWeight = (Integer) edges[e];
        String targetVertex = graph.getEdgeTarget(edgeWeight);
        String sourceVertex = graph.getEdgeSource(edgeWeight);
        relaxEdge(sourceVertex, targetVertex, edgeWeight, dist);
        relaxEdge(targetVertex, sourceVertex, edgeWeight, dist);
      }
    }
    
    Set<Object> vertixesKeys = dist.keySet();
    for (Object vertex : vertixesKeys) {
      System.out.println("Shortest path to vertex " + vertex + " is :" + dist.get(vertex));
    }
    
    return null;
    
  }
  
  private static void relaxEdge(String sourceVertex, String targetVertex, Integer edgeWeight, Map<Object, Long> dist) {
    Long oldDistance = dist.get(targetVertex);
    Long distToSourceVertex = dist.get(sourceVertex);
    Long newDist = distToSourceVertex + edgeWeight;
    if (newDist < oldDistance) {
      dist.put(targetVertex, newDist);
    } 
  }

  public static void main(String[] args) {
    GraphViewApp gViewApp = new GraphViewApp();
    Graph bgMapGraph = GraphStaticFactory.createBgMapGraph();
    gViewApp.showGraph(bgMapGraph);
    BellmanFordShortestPath.shortestPath(bgMapGraph, "Pleven");
  }

}
