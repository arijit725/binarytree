package org.arijit.binarytree.treesum;

import org.arijit.binarytree.Tree;
import org.arijit.binarytree.node.TreeNode;

public class SubtreeWithMaxSum {

	private static SubtreeWithMaxSum instance = new SubtreeWithMaxSum();
	
	
	/**
	 * <pre>
	 * Find largest subtree sum in a tree
	Given a binary tree, task is to find subtree with maximum sum in tree.
	
	Examples:
	
	Input :   1
	        /   \
	       2      3
	      / \    / \
	     4   5  6   7
	Output : 28
	As all the tree elements are positive,
	the largest subtree sum is equal to
	sum of all tree elements.
	
	Input :    1
	        /    \
	      -2      3
	      / \    /  \
	     4   5  -6   2
	Output : 7
	Subtree with largest sum is :  
							  -2
	                         /  \ 
	                        4    5
	Also, entire tree sum is also 7.
	 * </pre>
	 * 
	 * @param tree
	 */
	public void subTreeMaxSum(Tree tree) {
		int ans[] = new int[1];
		TreeNode<Object> root = tree.getRoot();
		subtreeMaxSum(root, ans);
		System.out.println("MaxSum Subtree: " + ans[0]);
	}

	private int subtreeMaxSum(TreeNode<Object> root, int[] ans) {
		if (root == null)
			return 0;
		int sum = (int) root.getValue() + subtreeMaxSum(root.getLeftChild(), ans)
				+ subtreeMaxSum(root.getRightChild(), ans);
		ans[0] = Math.max(sum, ans[0]);
		return sum;
	}
	
	public static SubtreeWithMaxSum getInstance() {
		return instance;
	}
}
