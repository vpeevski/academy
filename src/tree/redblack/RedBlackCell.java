package tree.redblack;

import org.jgraph.graph.DefaultGraphCell;

@Deprecated
public class RedBlackCell extends DefaultGraphCell {

	private final int ROOT_X = 500;
	private final int ROOT_Y = 100;

	private final int OFFSET_X = 100;
	private final int OFFSET_Y = 100;

	private int x;

	private int y;

	private RedBlackCell parentCell;

	public RedBlackCell(RBTreeNode node, RedBlackCell parentCell) {
		super(node);
		this.parentCell = parentCell;
	}

	public int getX() {
		RBTreeNode node = (RBTreeNode) userObject;
		if (parentCell == null) {
			x = ROOT_X;
		} else if (node.isLeftChild()) {
			x = parentCell.getX() - OFFSET_X;
		} else {
			x = parentCell.getX() + OFFSET_X;
		}
		return x;
	}

	public int getY() {
		RBTreeNode node = (RBTreeNode) userObject;
		if (parentCell == null) {
			y = ROOT_Y;
		} else {
			y = parentCell.getY() + OFFSET_Y;
		}

		return y;
	}

}
