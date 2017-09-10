package tree.redblack;

import java.util.Iterator;

import org.jgrapht.graph.SimpleDirectedGraph;

public class RedBlackTreeGraph<T extends Comparable<T>, V extends RBTreeNode<T>, E> extends SimpleDirectedGraph<V, E>
		implements Iterable<RBTreeNode<T>> {

	private RedBlackTree<T> tree;

	public RedBlackTreeGraph(Class<? extends E> edgeClass) {
		super(edgeClass);
		this.tree = new RedBlackTree<>();
	}

	@Override
	public boolean addVertex(V v) {
		RBTreeNode<T> node = tree.insert(v.getValue());
		boolean isInserted = super.addVertex((V) node);
		if (node.getParent() != null) {
			addEdge((V) node.getParent(), (V) node);
		}

		return isInserted;
	}

	private class NodesIterator implements Iterator<RBTreeNode<T>> {

		private Iterator<RBTreeNode<T>> treeIter;

		public NodesIterator() {
			treeIter = tree.bfsIterator();
		}

		@Override
		public boolean hasNext() {
			return treeIter.hasNext();
		}

		@Override
		public RBTreeNode<T> next() {
			return treeIter.next();
		}

	}

	@Override
	public Iterator<RBTreeNode<T>> iterator() {
		return new NodesIterator();
	}

}
