package tree.redblack;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

import tree.redblack.RBTreeNode.Color;

public final class RedBlackTree<T extends Comparable<T>> {

	private RBTreeNode<T> root;

	public RedBlackTree(T rootValue) {
		root = createRootNode(rootValue);
	}

	public RedBlackTree() {
	}

	public RBTreeNode<T> insert(T value) {
		RBTreeNode<T> insertNode = new RBTreeNode<>(value);
		if (root != null) {
			if (value.compareTo(root.getValue()) >= 0) {
				insertRight(root, insertNode);
			} else {
				insertLeft(root, insertNode);

			}
			return insertNode;
		} else {
			root = createRootNode(value);
			return root;
		}

	}

	private void insertLeft(RBTreeNode<T> parent, RBTreeNode<T> insertNode) {
		if (!parent.getLeft().isLeaf()) {
			insertRec(parent.getLeft(), insertNode);
		} else {
			parent.setLeft(insertNode);
		}
	}

	private void insertRight(RBTreeNode<T> parent, RBTreeNode<T> insertNode) {
		if (!parent.getRight().isLeaf()) {
			insertRec(parent.getRight(), insertNode);
		} else {
			parent.setRight(insertNode);
		}
	}

	private void insertRec(RBTreeNode<T> parent, RBTreeNode<T> insertNode) {
		if (parent != null) {
			if (insertNode.getValue().compareTo(parent.getValue()) >= 0) {
				if (parent.getRight().isLeaf()) {
					parent.setRight(insertNode);
					reColorIfNeeded(insertNode);
				} else {
					insertRec(parent.getRight(), insertNode);
				}
			} else {
				if (parent.getLeft().isLeaf()) {
					parent.setLeft(insertNode);
					reColorIfNeeded(insertNode);
				} else {
					insertRec(parent.getLeft(), insertNode);
				}
			}
		}

	}

	private void reColorIfNeeded(RBTreeNode<T> node) {
		assert (node != null);
		if (node.isRed() && !node.isRoot() && node.getParent().isRed() && node.getUncle() != null
				&& node.getUncle().isRed()) { // RED parent RED uncle
			node.getParent().setColor(Color.BLACK);
			if (node.getUncle() != null) {
				node.getUncle().setColor(Color.BLACK);
			}

			if (node.getGrantFather() != root) {
				node.getGrantFather().setColor(Color.RED);
				reColorIfNeeded(node.getGrantFather());
			}
		} else if (node.isRed() && !node.isRoot() && node.getParent().isRed()
				&& !node.getUncle().isRed() && !haveSameSide(node, node.getUncle())) {
			if (node.getParent().isLeftChild()) {
				rotateRight(node.getGrantFather());
			} else {
				rotateLeft(node.getGrantFather());
			}

		}
	}

	private boolean haveSameSide(RBTreeNode<T> node, RBTreeNode<T> uncle) {
		return uncle != null && (node.isLeftChild() && uncle.isLeftChild()) || (!node.isLeftChild() && !uncle.isLeftChild());
	}

	private void rotateRight(RBTreeNode<T> rotationRoot) {

	}

	private RBTreeNode<T> rotateLeft(RBTreeNode<T> rotationRoot) {
		if (rotationRoot == null) {
			return null;
		}
		RBTreeNode<T> tmpNode = rotationRoot.getRight();
		rotationRoot.setRight(tmpNode.getLeft());
		tmpNode.setLeft(rotationRoot);
		tmpNode.setColor(tmpNode.getLeft().getColor());
		tmpNode.getLeft().setColor(Color.RED);
		return tmpNode;
	}

	private RBTreeNode<T> createRootNode(T value) {
		RBTreeNode<T> result = new RBTreeNode<>(value, null);
		result.setColor(Color.BLACK);
		return result;
	}

	public Iterator<RBTreeNode<T>> bfsIterator() {
		return new BfsIterator();
	}

	private class BfsIterator implements Iterator<RBTreeNode<T>> {

		private Queue<RBTreeNode<T>> nodes;

		public BfsIterator() {
			nodes = new LinkedList<>();
			flatBfsTreeNodes(root, nodes);
		}

		@Override
		public boolean hasNext() {
			return nodes.peek() != null;
		}

		@Override
		public RBTreeNode<T> next() {
			return nodes.poll();
		}

		private void flatBfsTreeNodes(RBTreeNode<T> currentNode, Queue<RBTreeNode<T>> resultList) {
			Queue<RBTreeNode<T>> nodesQ = new LinkedList<>();
			do {
				if (!nodesQ.isEmpty()) {
					currentNode = nodesQ.poll();
				}
				if (currentNode != null) {
					resultList.add(currentNode);
					if (currentNode.getLeft() != null) {
						nodesQ.add(currentNode.getLeft());
					}
					if (currentNode.getRight() != null) {
						nodesQ.add(currentNode.getRight());
					}
				}

			} while (!nodesQ.isEmpty());

		}

	}

}
