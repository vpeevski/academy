package tree.redblack;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.HashMap;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JScrollPane;

import org.jgraph.JGraph;
import org.jgraph.graph.AttributeMap;
import org.jgraph.graph.CellViewRenderer;
import org.jgraph.graph.DefaultCellViewFactory;
import org.jgraph.graph.DefaultGraphCell;
import org.jgraph.graph.GraphConstants;
import org.jgraph.graph.GraphLayoutCache;
import org.jgraph.graph.VertexRenderer;
import org.jgraph.graph.VertexView;
import org.jgrapht.ext.JGraphModelAdapter;

public class TreeVisualizer<T extends Comparable<T>, V extends RBTreeNode<T>, E> {

	private JGraphModelAdapter<V, E> _graphAdapter;

	public static void main(String[] args) {
		TreeVisualizer treeVisualizer = new TreeVisualizer();
		treeVisualizer.showRedBlackTree(produceRedBlackTree());
	}

	public void showRedBlackTree(RedBlackTreeGraph<T, V, E> graph) {
		AttributeMap vertexAtts = JGraphModelAdapter.createDefaultVertexAttributes();
		GraphConstants.setBorder(vertexAtts, BorderFactory.createEmptyBorder());
		_graphAdapter = new JGraphModelAdapter<>(graph, vertexAtts,
				JGraphModelAdapter.createDefaultEdgeAttributes(graph));
		GraphLayoutCache graphLayoutCache = new GraphLayoutCache(_graphAdapter, new CustomViewFactory());
		JGraph jGraph = new JGraph(graphLayoutCache);
		showRedBlackTree(graph, jGraph);
	}

	private void showRedBlackTree(RedBlackTreeGraph<T, V, E> graph, JGraph jGraph) {
		for (RBTreeNode<T> vertex : graph) {
			putVertexToPosition(vertex);
		}

		JFrame _frame = new JFrame();
		JScrollPane scrollPane = new JScrollPane(jGraph);
		_frame.add(scrollPane, BorderLayout.CENTER);

		_frame.setVisible(true);
		_frame.setSize(new Dimension(1192, 800));
		_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void putVertexToPosition(RBTreeNode<T> vertex) {
		DefaultGraphCell gCell = _graphAdapter.getVertexCell(vertex);
		if (gCell != null) {
			Map atts = gCell.getAttributes();

			GraphConstants.setBounds(atts, new Rectangle(vertex.getX(), vertex.getY(), 50, 50));

			Map cellAttr = new HashMap();
			cellAttr.put(gCell, atts);
			_graphAdapter.edit(cellAttr, null, null, null);
		}

	}

	private static RedBlackTreeGraph<Integer, RBTreeNode<Integer>, DummyEdge> produceRedBlackTree() {
		RedBlackTreeGraph<Integer, RBTreeNode<Integer>, DummyEdge> graph = new RedBlackTreeGraph<>(DummyEdge.class);

		graph.addVertex(new RBTreeNode<Integer>(10));
//		graph.addVertex(new RBTreeNode<Integer>(5));
		graph.addVertex(new RBTreeNode<Integer>(20));
		graph.addVertex(new RBTreeNode<Integer>(30));
		graph.addVertex(new RBTreeNode<Integer>(25));
//		graph.addVertex(new RBTreeNode<Integer>(6));
//		graph.addVertex(new RBTreeNode<Integer>(4));
//		graph.addVertex(new RBTreeNode<Integer>(3));
//		graph.addVertex(new RBTreeNode<Integer>(22));

		return graph;
	}

	public static class DummyEdge {
		@Override
		public String toString() {
			return "";
		}

	}

	private static class CustomViewFactory extends DefaultCellViewFactory {
		@Override
		protected VertexView createVertexView(Object cell) {
			return new OvalView(cell);
		}
	}

	private static class OvalView extends VertexView {

		public OvalView(Object cell) {
			super(cell);
		}

		@Override
		public CellViewRenderer getRenderer() {
			return new OvalRenderer((DefaultGraphCell) cell);
		}

	}

	private static class OvalRenderer<T extends Comparable<T>> extends VertexRenderer {

		private RBTreeNode<T> node;

		private DefaultGraphCell cell;

		private OvalRenderer(DefaultGraphCell cell) {
			node = (RBTreeNode<T>) ((DefaultGraphCell) cell).getUserObject();
			this.cell = cell;
		}

		@Override
		public void paint(Graphics g) {
			try {
				Graphics2D g2d = (Graphics2D) g;
				if (gradientColor != null && !preview && isOpaque()) {
					setOpaque(false);

					g2d.setPaint(
							new GradientPaint(0, 0, getBackground(), getWidth(), getHeight(), gradientColor, true));
					g2d.fillOval(0, 0, getWidth(), getHeight());
				}

				if (node.isRed()) {
					g2d.setPaint(Color.RED);
				} else {
					g2d.setPaint(Color.BLACK);
				}

				g2d.fillOval(0, 0, getWidth(), getHeight());
				setOpaque(false);
				super.paint(g2d);

			} catch (IllegalArgumentException e) {
				// JDK Bug: Zero length string passed to TextLayout constructor
			}
		}

	}

	// private class RBCellFactory<T extends Comparable<T>, V extends
	// RBTreeNode<T>, E> extends DefaultCellFactory<V, E> {
	//
	// @Override
	// public DefaultGraphCell createVertexCell(V jGraphTVertex) {
	// RBTreeNode<T> parentNode = ((RBTreeNode<T>) jGraphTVertex).getParent();
	// return new RedBlackCell((RBTreeNode<T>) jGraphTVertex, parentNode == null
	// ? null :
	// (RedBlackCell) _graphAdapter.getVertexCell(parentNode));
	// }
	//
	// }

}
