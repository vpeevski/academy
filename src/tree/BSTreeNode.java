package tree;

import tree.redblack.RBTreeNode;

public final class BSTreeNode<T extends Comparable<T>> {

	private BSTreeNode<T> left;

	private BSTreeNode<T> right;

	private BSTreeNode<T> parent;

	public T value;

	public BSTreeNode(BSTreeNode<T> left, BSTreeNode<T> right, T value) {
		this.left = left;
		this.right = right;
		this.value = value;
	}

	public BSTreeNode(T value) {
		this(null, null, value);
	}

	public T getValue() {
		return value;
	}

	public BSTreeNode<T> getLeft() {
		return left;
	}

	public void setLeft(BSTreeNode<T> left) {
		this.left = left;
	}

	public BSTreeNode<T> getRight() {
		return right;
	}

	public void setRight(BSTreeNode<T> right) {
		this.right = right;
	}

	public BSTreeNode<T> getParent() {
		return parent;
	}

	public void setParent(BSTreeNode<T> parent) {
		this.parent = parent;
	}

	@Override
	public String toString() {
		return "" + value;
	}

}
