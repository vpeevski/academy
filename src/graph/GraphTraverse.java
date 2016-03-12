package graph;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

import org.jgrapht.Graph;

public class GraphTraverse {
	
	public static void depthFirstSearchIterative(Graph<String, Integer> graph, String vertex, Set<String> visited, GraphVisitor visitor) {
		Deque<String> stack = new ArrayDeque<>();//stack, so that deeper vertices are visited first /pushed at the start of the stack, before the other vertices/
		stack.add(vertex);
		while(!stack.isEmpty()) {
			String current = stack.pop();
			if (visited.add(current)) {
				if (visitor.visit(current)) {
					return;
				}
				Set<Integer> edges = graph.edgesOf(current);
				for (Integer edge : edges) {
					String neighbour = null;
					String edgeSource = graph.getEdgeSource(edge);
					String edgeTarget = graph.getEdgeTarget(edge);
					if (!current.equals(edgeSource)) {
						neighbour = edgeSource;
					} else if (!current.equals(edgeTarget)) {
						neighbour = edgeTarget;
					}
					if (neighbour == null) {
						throw new IllegalArgumentException("Wrong edge ['"+edgeSource+"'-"+edge+"->'"+edgeTarget+"'] for vertex: "+vertex);
					}
					stack.push(neighbour);
				}
			}
		}
	}
	
	public static void breadthFirstSearchIterative(Graph<String, Integer> graph, String vertex, Set<String> visited, GraphVisitor visitor) {
		Queue<String> que = new LinkedList<>();//queue - any deeper vertices are enqueued at the back, so they will be visited last
		que.add(vertex);
		while(!que.isEmpty()) {
			String current = que.poll();
			if (visited.add(current)) {
				if (visitor.visit(current)) {
					return;
				}
				Set<Integer> edges = graph.edgesOf(current);
				for (Integer edge : edges) {
					String neighbour = null;
					String edgeSource = graph.getEdgeSource(edge);
					String edgeTarget = graph.getEdgeTarget(edge);
					if (!current.equals(edgeSource)) {
						neighbour = edgeSource;
					} else if (!current.equals(edgeTarget)) {
						neighbour = edgeTarget;
					}
					if (neighbour == null) {
						throw new IllegalArgumentException("Wrong edge ['"+edgeSource+"'-"+edge+"->'"+edgeTarget+"'] for vertex: "+vertex);
					}
					que.add(neighbour);
				}
			}
		}
	}
	
	public static void breadthFirstSearch(Graph<String, Integer> graph, String vertex, Set<String> visited, GraphVisitor visitor) {
		if (graph.containsVertex(vertex)) {
			if (visited.add(vertex)) {
				//first visit
				if (visitor.visit(vertex)) {
					return ;
				}
				//then go deeper
				Set<Integer> edges = graph.edgesOf(vertex);
				for (Integer edge : edges) {
					String neighbour = null;
					String edgeSource = graph.getEdgeSource(edge);
					String edgeTarget = graph.getEdgeTarget(edge);
					if (!vertex.equals(edgeSource)) {
						neighbour = edgeSource;
					} else if (!vertex.equals(edgeTarget)) {
						neighbour = edgeTarget;
					}
					if (neighbour == null) {
						throw new IllegalArgumentException("Wrong edge ['"+edgeSource+"'-"+edge+"->'"+edgeTarget+"'] for vertex: "+vertex);
					}
					breadthFirstSearch(graph, neighbour, visited, visitor);
				}
			}
		}
	}
	
	public static void depthFirstSearch(Graph<String, Integer> graph, String vertex, Set<String> visited, GraphVisitor visitor) {
		if (graph.containsVertex(vertex)) {
			if (visited.add(vertex)) {
				Set<Integer> edges = graph.edgesOf(vertex);
				//first go into depth
				for (Integer edge : edges) {
					String neighbour = null;
					String edgeSource = graph.getEdgeSource(edge);
					String edgeTarget = graph.getEdgeTarget(edge);
					if (!vertex.equals(edgeSource)) {
						neighbour = edgeSource;
					} else if (!vertex.equals(edgeTarget)) {
						neighbour = edgeTarget;
					}
					if (neighbour == null) {
						throw new IllegalArgumentException("Wrong edge ['"+edgeSource+"'-"+edge+"->'"+edgeTarget+"'] for vertex: "+vertex);
					}
					if (!visited.contains(neighbour)) {
						depthFirstSearch(graph, neighbour, visited, visitor);
					}
				}
				//then visit
				if (visitor.visit(vertex)) {
					return ;
				}
			}
		}
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {
		GraphViewApp gViewApp = new GraphViewApp();
	    Graph bgMapGraph = GraphStaticFactory.createBgMapGraph();
	    
	    GraphVisitor displayVisitor = new GraphVisitorAdapter(){
	    	@Override
	    	public boolean visit(String vertex) {
	    		System.out.println(vertex);
	    		return false;//to continue traversal - leading to full traverse of the graph
	    	}
	    };
	    //traverse all using breadth first search, starting from Sofia
	    System.out.println("---BFS---");
	    Set<String> visited = new HashSet<String>();
	    breadthFirstSearch(bgMapGraph, "Sofia", visited, displayVisitor);
	    //Traverse all using depth first search, starting from Sofia
	    System.out.println("---DFS---");
	    visited.clear();
	    depthFirstSearch(bgMapGraph, "Sofia", visited, displayVisitor);
	    
	    System.out.println("---BFS iterative---");
	    visited.clear();
	    breadthFirstSearchIterative(bgMapGraph, "Sofia", visited, displayVisitor);
	    
	    System.out.println("---DFS iterative---");
	    visited.clear();
	    depthFirstSearchIterative(bgMapGraph, "Sofia", visited, displayVisitor);
	    
	    gViewApp.showGraph(bgMapGraph);
	}

}
