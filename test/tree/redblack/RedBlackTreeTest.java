package tree.redblack;

import org.junit.Test;

public class RedBlackTreeTest {
	
	private static RedBlackTree<Integer> tree = new RedBlackTree<Integer>(10);

	@Test
	public void testInsert() {
		tree.insert(20);
		tree.insert(5);
		tree.insert(30);
		System.out.println(tree);
	}

}
