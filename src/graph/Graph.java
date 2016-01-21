package graph;

import org.jgrapht.UndirectedGraph;


public final class Graph {

	public static Node createNode(String name) {
		return new Node(name);
	}

	private final Node _startNode;

	public Graph(Node startNode) {
		_startNode = startNode;
	}

//	public void addNode(Node node) {
//		
//	}

}
