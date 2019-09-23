package org.arijit.binarytree.treesum;

import org.arijit.binarytree.Tree;
import org.arijit.binarytree.node.TreeNode;

/**
 * <pre>
 * Find the maximum path sum between two leaves of a binary tree
 * Given a binary tree in which each node element contains a number. Find the maximum possible sum from one leaf node to another.
 * </pre>
 * 
 * @author ARIJIT
 *
 */
public class MaxPathsumBetweenTwoLeaves {

	private static MaxPathsumBetweenTwoLeaves instance = new MaxPathsumBetweenTwoLeaves();

	public void findMaxPathSum(Tree tree) {
		int[] max = new int[1];
		TreeNode<Object> root = tree.getRoot();
		findMaxPathSum(root, max);
		System.out.println("Max Path Sum: " + max[0]);
	}

	private int findMaxPathSum(TreeNode<Object> root, int[] max) {
		if (root == null)
			return 0;
		int lSum = findMaxPathSum(root.getLeftChild(), max);
		int rSum = findMaxPathSum(root.getRightChild(), max);
		int sum = (int) root.getValue() + lSum + rSum;
		if (sum > max[0])
			max[0] = sum;
		int pathSum = (int) root.getValue() + Math.max(lSum, rSum);
		return pathSum;
	}

	public static MaxPathsumBetweenTwoLeaves getInstance() {
		return instance;
	}

}
