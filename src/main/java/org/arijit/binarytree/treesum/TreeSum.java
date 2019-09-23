package org.arijit.binarytree.treesum;

import org.arijit.binarytree.Tree;
import org.arijit.binarytree.node.TreeNode;

public class TreeSum {

	private static TreeSum instance = new TreeSum();

//	public static int parentSum(TreeNode<Object> root, int val) {
//		if(root == null)
//			return 0;
//		if((root.getLeftChild()!= null && (int)root.getLeftChild().getValue()==val )
//			||(root.getRightChild()!=null &&  (int)root.getRightChild().getValue() == val )) {
//			int sum = (int)root.getValue() + parentSum(root.getLeftChild(), val) + parentSum(root.getRightChild(), val);
//			return sum;
//		}	
//		return 0;
//	}

	public void maxPathSum(Tree tree) {

		TreeNode<Object> root = tree.getRoot();
		int[] res = new int[1];
		int sum = maxPathSum(root, res);
		System.out.println("Max Path Sum: " + res[0]);
	}

	private int maxPathSum(TreeNode<Object> root, int[] res) {

		// Base Case
		if (root == null)
			return 0;

		// l and r store maximum path sum going through left and
		// right child of root respectively
		int l = maxPathSum(root.getLeftChild(), res);
		int r = maxPathSum(root.getRightChild(), res);

		// Max path for parent call of root. This path must
		// include at-most one child of root
		int maxSinglePathSum = Math.max(Math.max(l, r) + (int) root.getValue(), (int) root.getValue());

		/*
		 * Here we are calcuating whether subtree is having max path or including the
		 * parent of subtree having max path
		 */
		int subtreeMaxPathSum = Math.max(maxSinglePathSum, l + r + (int) root.getValue());

		// Store the Maximum Result.
		res[0] = Math.max(res[0], subtreeMaxPathSum);

		return maxSinglePathSum;
	}

	

	public void findSubtreeSum(Tree tree, int X) {
		TreeNode<Object> tmpRoot = tree.getRoot();
		int ans[] = new int[1];
		findSubtreeSum(tmpRoot, X, ans);
		System.out.println("Total subtree with sum : " + X + " = " + ans[0]);
	}

	/**
	 * 
	 * Given a binary tree containing n nodes. The problem is to count subtrees
	 * having total node’s data sum equal to a given value using only single
	 * recursive functionx.
	 * 
	 * <pre>
	Examples:
	
	Input : 
	        5
	      /   \  
	   -10     3
	   /  \   /  \
	  9    8 -4   7
	  
	  x = 7
	
	Output : 2
	There are 2 subtrees with sum 7.
	
	1st one is leaf node:
	7.
	
	2nd one is:
	
	 -10
	/   \
	9     8
	 * </pre>
	 * 
	 * @param root
	 * @param X
	 * @param ans
	 * @return
	 */
	private int findSubtreeSum(TreeNode<Object> root, int X, int ans[]) {
		if (root == null)
			return 0;
		int sum = (int) root.getValue() + findSubtreeSum(root.getLeftChild(), X, ans)
				+ findSubtreeSum(root.getRightChild(), X, ans);
		if (sum == X)
			ans[0] = ++ans[0];
		return sum;
	}

	public static TreeSum getInstance() {
		return instance;
	}
}
