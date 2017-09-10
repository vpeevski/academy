package tree;

import tree.redblack.RBTreeNode;

public final class BSTree<T extends Comparable<T>> {
	
	private BSTreeNode<T> root;
	
	public BSTree (T rootValue) {
		this.root = new BSTreeNode<>(rootValue);
	}
	
	public void insert(RBTreeNode<T> node) {
		//TODO implement insertion
	}

}
