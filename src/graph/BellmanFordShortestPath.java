package graph;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.jgrapht.Graph;

public class BellmanFordShortestPath {
 
  public static int[] shortestPath(Graph<String, Integer> graph, String fromVertex) {
    
    Object[] vertices = graph.vertexSet().toArray();
    Map<Object, Long> dist = new HashMap<>();
    dist.put(vertices[0], 0L);
    for (int i = 1; i < vertices.length; i++) {
      dist.put(vertices[i], Long.valueOf(Integer.MAX_VALUE));
    }
    
//    graph.e
    Object[] edges = graph.edgeSet().toArray();
    for (int v = 0; v < vertices.length - 1; v++) {
      for (int e = 0; e < edges.length; e++) {
        Integer edgeWeight = (Integer) edges[e];
        String targetVertex = graph.getEdgeTarget(edgeWeight);
        String sourceVertex = graph.getEdgeSource(edgeWeight);
        Long oldDistance = dist.get(targetVertex);
        Long distToSourceVertex = dist.get(sourceVertex);
        Long newDist = distToSourceVertex + edgeWeight;
        if (newDist < oldDistance) {
          dist.put(targetVertex, newDist);
        }
        
      }
    }
    
    Set<Object> vertixesKeys = dist.keySet();
    for (Object vertex : vertixesKeys) {
      System.out.println("Shortest path to vertex " + vertex + " is :" + dist.get(vertex));
    }
    
    return null;
    
  }
  
  public static void main(String[] args) {
    BellmanFordShortestPath.shortestPath(GraphStaticFactory.createBgMapGraph(), "Plodvid");
  }

}
