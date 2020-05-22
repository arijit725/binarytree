package org.arijit.binarytree.misleneous;

import java.util.LinkedList;

public class DistanceBetweenTwoNode {

	public static void main(String args[]) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		root.right.left.right = new TreeNode(8);

		int val1 = 6;
		int val2 = 8;
		System.out.println("Distnce: " + distanceBetweenNode(root, val1, val2));
	}

	public static int distanceBetweenNode(TreeNode root, int val1, int val2) {
		TreeNode lca = findLca(root, val1, val2);
		System.out.println("LCA: " + lca.val);
//		System.out.println("4 - 6 :"+distanceBetweenNode(root, 4,5));
		int[] valLevels = findLevels(lca, val1, val2);
		return (valLevels[0] + valLevels[1]);
	}

	public static TreeNode findLca(TreeNode root, int val1, int val2) {
		if (root == null)
			return null;
		if (root.val == val1) {
			return root;
		}
		if (root.val == val2) {
			return root;
		}
		TreeNode left = findLca(root.left, val1, val2);
		TreeNode right = findLca(root.right, val1, val2);
		if (left != null && right != null)
			return root;
		else if (left != null)
			return left;
		else
			return right;
	}

	public static int[] findLevels(TreeNode root, int val1, int val2) {
		int level = 0;
		LinkedList<TreeNode> q = new LinkedList<>();
		int valLevel[] = new int[2];
		q.add(root);
		int nodeCount = q.size();
		while (!q.isEmpty()) {
			if (nodeCount == 0) {
				level++;
				nodeCount = q.size();
			}
			TreeNode tmp = q.poll();
			if (tmp.val == val1) {
				valLevel[0] = level;
			} else if (tmp.val == val2)
				valLevel[1] = level;

			if (tmp.left != null)
				q.add(tmp.left);
			if (tmp.right != null)
				q.add(tmp.right);
			nodeCount--;
		}
		return valLevel;
	}

	private static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		public TreeNode(int val) {
			this.val = val;
		}
	}

}
