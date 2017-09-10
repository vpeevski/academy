package tree.redblack;

import tree.BSTreeNode;

public class RBTreeNode<T extends Comparable<T>> {

	private final int ROOT_X = 500;
	private final int ROOT_Y = 100;

	private final int OFFSET_X = 100;
	private final int OFFSET_Y = 100;

	private int x = ROOT_X;

	private int y = ROOT_Y;

	private RBTreeNode<T> left;

	private RBTreeNode<T> right;

	private RBTreeNode<T> parent;

	private BSTreeNode<T> innerNode;

	private Color color;

	private int level;

	public RBTreeNode(T value) {
		this(value, null);
	}

	public RBTreeNode(T value, RBTreeNode<T> parent) {
		this(value, Color.RED, parent);
	}

	public RBTreeNode(T value, Color color, RBTreeNode<T> parent) {
		innerNode = new BSTreeNode<>(value);
		this.color = color;
		this.parent = parent;
		this.level = parent == null ? 0 : parent.level + 1;

	}

	public T getValue() {
		return innerNode.getValue();
	}

	public RBTreeNode<T> getLeft() {
		return left;
	}

	public RBTreeNode<T> getRight() {
		return right;
	}

	public void setLeft(RBTreeNode<T> left) {
		this.left = left;
		left.setParent(this);
	}

	public void setRight(RBTreeNode<T> right) {
		this.right = right;
		right.setParent(this);
	}

	public RBTreeNode<T> getParent() {
		return parent;
	}

	public void setParent(RBTreeNode<T> parent) {
		this.level = parent == null ? 0 : parent.level + 1;
		this.parent = parent;
		calcCoordinates();
	}

	public RBTreeNode<T> getUncle() {
		RBTreeNode<T> parent = getParent();
		return parent.getBrother();
	}

	public RBTreeNode<T> getBrother() {
		RBTreeNode<T> parent = getParent();
		RBTreeNode<T> uncle = null;
		if (parent != null) {
			if (parent.getLeft() == this) {
				uncle = parent.getRight();
			} else {
				uncle = parent.getLeft();
			}
		}
		return uncle;
	}

	public RBTreeNode<T> getGrantFather() {
		return parent.getParent();
	}

	public boolean isRed() {
		return color == Color.RED;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public boolean isLeftChild() {
		return parent == null ? false : parent.getLeft() == this;
	}

	public boolean isRoot() {
		return parent == null;
	}

	public int getLevel() {
		return level;
	}

	public static enum Color {
		RED, BLACK
	}

	@Override
	public String toString() {
		return innerNode.getValue() + "";
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	private void calcCoordinates() {
		if (isLeftChild()) {
			x = parent.getX() - OFFSET_X;
			y = parent.getY() + OFFSET_Y;
		} else {
			x = parent.getX() + OFFSET_X;
			y = parent.getY() + OFFSET_Y;
		}
	}
}
