package graph;

public interface GraphVisitor {

	public boolean visit(String vertex);
	
	public boolean visit(String vertexFrom, String vertexTo, Integer edgeValue);
	
}
