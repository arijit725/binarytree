package org.arijit.binarytree.misleneous;

public class FindMaxPathSum {

	private static class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		public TreeNode(int val) {
			this.val = val;
		}
	}
	private static int maxPathSum = -1;
	public static int pathSum(TreeNode root){
		if(root==null)
			return 0;

		int l = pathSum(root.left);
		int r = pathSum(root.right);
		int sum = root.val+l+r;
		if(sum>maxPathSum) {
			maxPathSum = sum;
		}
		return root.val+Math.max(l,r);	
	}

	public static void main(String args[]) {		
        TreeNode root = new TreeNode(-15); 
        root.left = new TreeNode(5); 
        root.right = new TreeNode(6); 
        root.left.left = new TreeNode(-8); 
        root.left.right = new TreeNode(1); 
        root.left.left.left = new TreeNode(2); 
        root.left.left.right = new TreeNode(6); 
        root.right.left = new TreeNode(3); 
        root.right.right = new TreeNode(9); 
        root.right.right.right = new TreeNode(0); 
        root.right.right.right.left = new TreeNode(4); 
        root.right.right.right.right = new TreeNode(-1); 
        root.right.right.right.right.left = new TreeNode(10);
        pathSum(root);
        System.out.println(maxPathSum);
        
	}
}
