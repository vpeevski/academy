package graph;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
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

    List<Object> notVisitedVertexes = Arrays.asList(graph.vertexSet().toArray());
    String currentVertex = startVertex;
    for (Iterator<Object> iter = notVisitedVertexes.iterator(); iter.hasNext();) {
      
      for (Integer edgeWeight : graph.edgesOf(currentVertex)) {
        String sourceVertex = graph.getEdgeSource(edgeWeight);
        String targetVertex = graph.getEdgeTarget(edgeWeight);
        relaxEdge(sourceVertex, targetVertex, edgeWeight, dist);
        relaxEdge(targetVertex, sourceVertex, edgeWeight, dist);
      }
      
      currentVertex = (String) iter.next();      
    }

    printPaths(dist);

    return null;
  }

  private static void printPaths(Map<Object, Long> dist) {
    Set<Object> vertixesKeys = dist.keySet();
    for (Object vertex : vertixesKeys) {
      System.out.println("Shortest path to vertex " + vertex + " is :" + dist.get(vertex));
    }
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
    Set<String> vertexes = bgMapGraph.vertexSet();
    for (String vertex : vertexes) {
      System.out.println();
      System.out.println("***********    Paths from " + vertex + "   **************");
      System.out.println();
      DijkstraShortestPath.shortestPath(bgMapGraph, vertex);
      
    }
    
  }

}
