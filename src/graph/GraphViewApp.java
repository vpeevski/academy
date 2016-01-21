package graph;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

import org.jgraph.JGraph;
import org.jgraph.graph.DefaultGraphCell;
import org.jgraph.graph.GraphConstants;
import org.jgrapht.Graph;
import org.jgrapht.ext.JGraphModelAdapter;

public class GraphViewApp {
	
	private final int CENTER_X = 300;
	private final int CENTER_Y = 300;
	private final int RADIUS   = 100;
	
	private JGraphModelAdapter<String, Integer> _graphAdapter;
	
	public void showGraph (Graph graph) {
		_graphAdapter = new JGraphModelAdapter<String, Integer>(graph);
		
		JGraph jGraph = new JGraph(_graphAdapter);
		
		Set vertexes = graph.vertexSet();
		
		int x , y;
		double fi = 0;
		int radius = RADIUS;
		int i = 0;
		for (Object vertex : vertexes) {
			
			if (i % 5 == 0) {
				radius += 100;
			}
			
			x = CENTER_X + (int) (radius * Math.sin(fi));
			y = CENTER_Y + (int) (radius * Math.cos(fi));
			putVertexToPosition(vertex , x, y);
			fi += 15;
			i++;
		}
		
		JFrame _frame = new JFrame();
		JScrollPane scrollPane = new JScrollPane(jGraph);
		_frame.add(scrollPane, BorderLayout.CENTER);
	
		_frame.setVisible(true);
		_frame.setSize(new Dimension(600, 800));
	}
	
	private void putVertexToPosition (Object vertex, int x, int y) {
		DefaultGraphCell gCell = _graphAdapter.getVertexCell(vertex);
		Map atts =  gCell.getAttributes();
		Rectangle2D        b    = GraphConstants.getBounds( atts );
		
		GraphConstants.setBounds( atts, new Rectangle( x, y, (int) b.getWidth(), (int) b.getHeight() ) );

	    Map cellAttr = new HashMap(  );
	     cellAttr.put( gCell, atts );
	     _graphAdapter.edit( cellAttr, null, null, null );
	}
	
	public static void main(String[] args) {
		GraphViewApp gViewApp = new GraphViewApp();
		gViewApp.showGraph(GraphStaticFactory.createBgMapGraph());
	}
	
	

}
