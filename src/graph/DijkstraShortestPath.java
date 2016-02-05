package graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.jgrapht.Graph;

public class DijkstraShortestPath {
  
  public static int[] shortestPath(Graph<String, Integer> graph, String startVertex) {
    Object[] vertices = graph.vertexSet().toArray();
    Map<Object, Long> dist = new HashMap<Object, Long>();
    Map<String, String> prev = new HashMap<String, String> ();
    
    for (int i = 0; i < vertices.length; i++) {
      Long initialWeight = Long.valueOf(Integer.MAX_VALUE);
      if (vertices[i].equals(startVertex)) {
        initialWeight = 0L;
      }
      
      dist.put(vertices[i], initialWeight);
    }
    
    Set<String> notVisitedVertexes = createVertexesSet(graph, startVertex);
    String currentVertex = startVertex;
    while (!notVisitedVertexes.isEmpty()) {
      currentVertex = deleteMin(graph, notVisitedVertexes, currentVertex);
      for (Integer edgeWeight : graph.edgeSet()) {
        String sourceVertex = graph.getEdgeSource(edgeWeight);
        String targetVertex = graph.getEdgeTarget(edgeWeight);
        
        //graph.getAllEdges(sourceVertex, targetVertex)
        
        relaxEdge(sourceVertex, targetVertex, edgeWeight, dist);
        relaxEdge(targetVertex, sourceVertex, edgeWeight, dist);
        
//        if (dist.get(targetVertex) > dist.get(sourceVertex) + edgeWeight) {
//          dist.put(targetVertex, dist.get(sourceVertex) + edgeWeight);
//          prev.put(targetVertex, sourceVertex);
////          decreaseKey(notVisitedVertexes, targetVertex);
//        }
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
  
  
  private static Set<String> createVertexesSet(Graph<String, Integer> graph,  String startVertex) {
    Set<String> vertexSet = new HashSet<String>(graph.vertexSet()); //new is used to make modifiable Set from unmodifiable;
    vertexSet.remove(startVertex);
    return vertexSet;
  }


  private static String deleteMin(Graph<String, Integer> graph, Set<String> notVisitedVertexes, String currentVertex) {
    Integer minEdge = minEdge(graph.edgesOf(currentVertex));
    String nearestEdge = graph.getEdgeTarget(minEdge);
    if(nearestEdge.equals(currentVertex)) {
      nearestEdge = graph.getEdgeSource(minEdge);
    }
//    if (nearestEdge == null) {
//      nearestEdge = graph.getEdgeSource(minEdge);
//    }
    
    notVisitedVertexes.remove(nearestEdge);
    return nearestEdge;
  }
  
  private static Integer minEdge (Set<Integer> edges) {
    Integer minEdge = Integer.MAX_VALUE;
    for (Integer integer : edges) {
      if (integer < minEdge) {
        minEdge = integer;
      }
    }
    
    return minEdge;
  }

  public static void main(String[] args) {
    GraphViewApp gViewApp = new GraphViewApp();
    Graph bgMapGraph = GraphStaticFactory.createBgMapGraph();
    gViewApp.showGraph(bgMapGraph);
    DijkstraShortestPath.shortestPath(bgMapGraph, "Pleven");
  }
  
  

}
