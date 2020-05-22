package org.arijit.binarytree.misleneous;

public class DeletePathMoreThanK {

	private static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		public TreeNode(int val) {
			this.val = val;
		}
	}

	public static boolean deletePath(TreeNode root, int k, int pathSum) {
		if (root == null) {
			if (pathSum >= k) // if we have reached pathsum this path should exist.
				return false;
			else
				return true; // we have reached end and pathsum could not achived, so remove.
		}
		pathSum = pathSum + root.val;
		if (root.left == null && root.right == null && pathSum < k) {
			// we need to delete at this point
			return true;
		}

		boolean l = deletePath(root.left, k, pathSum);
		boolean r = deletePath(root.right, k, pathSum);
		if (l)
			root.left = null;
		if (r)
			root.right = null;
		return l & r; // if any of left or right path exist return false else return true.

	}

	public static void inOrder(TreeNode root) {
		if (root == null)
			return;
		inOrder(root.left);
		System.out.print(root.val + " ");
		inOrder(root.right);
	}

	public static void main(String args[]) {
		int k = 45;
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		root.left.left.left = new TreeNode(8);
		root.left.left.right = new TreeNode(9);
		root.left.right.left = new TreeNode(12);
		root.right.right.left = new TreeNode(10);
		root.right.right.left.right = new TreeNode(11);
		root.left.left.right.left = new TreeNode(13);
		root.left.left.right.right = new TreeNode(14);
		root.left.left.right.right.left = new TreeNode(15);
		inOrder(root);
		;
		deletePath(root, k, 0);
		System.out.println();
		inOrder(root);
		;
	}

}
