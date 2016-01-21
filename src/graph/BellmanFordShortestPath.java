package graph;

import java.util.Iterator;
import java.util.Set;

import org.jgrapht.Graph;

public class BellmanFordShortestPath {
 
  public static int[] shortestPath(Graph<String, Integer> graph, String fromVertex) {
    
    Set<String> vertices = graph.vertexSet();
    long[] dist = new long[vertices.size()];
    dist[0] = 0;
    for (int i = 1; i < dist.length; i++) {
      dist[i] = Long.MAX_VALUE;
    }
    
    for (int v = 0; v < vertices.size() - 1; v++) {
      for (Iterator<Integer> eIter = graph.edgeSet().iterator(); eIter.hasNext();) {
        int edgeWeight = eIter.next().intValue();
//        if (dist[v] > ) {
//          
//        }
      }
    }
    
    return null;
    
  }
  
  public static void main(String[] args) {
    BellmanFordShortestPath.shortestPath(GraphStaticFactory.createBgMapGraph(), "Plodvid");
  }

}
