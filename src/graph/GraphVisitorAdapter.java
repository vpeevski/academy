package graph;

public class GraphVisitorAdapter implements GraphVisitor {

	@Override
	public boolean visit(String vertex) {
		return false;
	}

	@Override
	public boolean visit(String vertexFrom, String vertexTo, Integer edgeValue) {
		return false;
	}

}
