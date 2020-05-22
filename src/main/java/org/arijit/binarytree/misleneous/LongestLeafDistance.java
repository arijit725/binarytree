package org.arijit.binarytree.misleneous;

import java.util.Arrays;
import java.util.LinkedList;

public class LongestLeafDistance {

	private static class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		
		public TreeNode(int val) {
			this.val = val;
		}
	}
	private static int maxDist = -1;
	public static int calDistance(TreeNode root,int[] data,int index){
		if(root==null)
			return 0;				
		int l = calDistance(root.left,data, index++);
		int r = calDistance(root.right, data, index++);
		int dist = 1+l+r;
		if(dist>maxDist) {
			maxDist = dist;	
		}
		return 1+Math.max(l,r);
	}
	
	public static void main(String args[]) {
		TreeNode root = new TreeNode(1); 
		root.left = new TreeNode(2); 
	    root.right = new TreeNode(3); 
	    root.left.left = new TreeNode(4); 
	    root.left.right = new TreeNode(5); 
	    root.left.right.left = new TreeNode(6); 
	    root.left.right.right = new TreeNode(7); 
	    root.left.left.right = new TreeNode(8); 
	    root.left.left.right.left = new TreeNode(9); 
	    int data[] = new int[10];
	    int i = calDistance(root,data,0);
	    System.out.println(maxDist);
	    
	    
	}
	
	
}
