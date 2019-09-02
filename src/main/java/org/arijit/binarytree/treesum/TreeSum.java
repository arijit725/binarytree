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
		int sum = maxPathSum(root,res);
		System.out.println("Max Path Sum: "+res[0]);
	}
	private int maxPathSum(TreeNode<Object> root , int[]  res) 
	    { 
	  
	        // Base Case 
	        if (root == null) 
	            return 0; 
	  
	        // l and r store maximum path sum going through left and 
	        // right child of root respectively 
	        int l = maxPathSum(root.getLeftChild(), res); 
	        int r = maxPathSum(root.getRightChild(), res); 
	  
	        // Max path for parent call of root. This path must 
	        // include at-most one child of root 
	        int maxSinglePathSum = Math.max(Math.max(l, r) + (int)root.getValue(), 
	                                  (int)root.getValue()); 
	  
	  

	        /*
	         * Here we are calcuating whether subtree is having max path or including the parent of subtree having max path
	         */
	        int subtreeMaxPathSum = Math.max(maxSinglePathSum, l + r + (int) root.getValue()); 
	  
	        // Store the Maximum Result. 
	       res[0] = Math.max(res[0], subtreeMaxPathSum); 
	  
	        return maxSinglePathSum; 
	    } 
	  
	/**
	 * Given a binary tree, task is to find subtree with maximum sum in tree.   
	 * @param tree
	 */
	public void subTreeMaxSum(Tree tree) {
		int ans[] = new int[1];
		TreeNode<Object> root = tree.getRoot();
		subtreeMaxSum(root, ans);
		System.out.println("MaxSum Subtree: "+ans[0]);
	}
	
	 private int subtreeMaxSum(TreeNode<Object> root, int[] ans) {
		 if(root==null)
			 return 0;
		 int sum =(int)root.getValue() + subtreeMaxSum(root.getLeftChild(), ans)+subtreeMaxSum(root.getRightChild(), ans);
		 ans[0] = Math.max(sum, ans[0]);
		 return sum;
	 }
	public static TreeSum getInstance() {
		return instance;
	}
}
