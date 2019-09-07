package org.arijit.binarytree.test;

import org.arijit.binarytree.Tree;
import org.arijit.binarytree.node.TreeNode;
import org.arijit.binarytree.treesum.TreeSum;

public class TestTreeSum {

	public static void main(String args[]) {
//		maxPathSum();
//		maxSumSubtree();
		subTreeWithSum();
	}
	
	public static void subTreeWithSum() {
		TreeNode<Object> root = TreeNode.create(5);
		TreeNode<Object> left1 = TreeNode.create(-10);
		TreeNode<Object> right1 = TreeNode.create(3);
		root.setLeftChild(left1);
		root.setRightChild(right1);
		TreeNode<Object> left11 = TreeNode.create(9);
		TreeNode<Object> right11 = TreeNode.create(8);
		left1.setLeftChild(left11);
		left1.setRightChild(right11);
		
		TreeNode<Object> left12 = TreeNode.create(4);
		TreeNode<Object> right12 = TreeNode.create(7);
		right1.setLeftChild(left12);
		right1.setRightChild(right12);
		
		Tree tree = Tree.create(root);
		TreeSum.getInstance().findSubtreeSum(tree, 7);
	}
	
	public static void maxSumSubtree() {
		TreeNode<Object> root =  TreeNode.create(1);
		TreeNode<Object> l11 = TreeNode.create(-2);
		TreeNode<Object> l12 = TreeNode.create(3);
		root.setLeftChild(l11);
		root.setRightChild(l12);
		TreeNode<Object> l21 = TreeNode.create(4);
		TreeNode<Object> l22 = TreeNode.create(5);
		l11.setLeftChild(l21);
		l11.setRightChild(l22);
		TreeNode<Object> l23 = TreeNode.create(-6);
		TreeNode<Object> l24 = TreeNode.create(2);
		l12.setLeftChild(l23);
		l12.setRightChild(l24);
		
		Tree tree=Tree.create(root);
		TreeSum.getInstance().subTreeMaxSum(tree);
	}
	public static void maxPathSum() {
		TreeNode<Object> root = TreeNode.create(10);
		TreeNode<Object> n2 = TreeNode.create(2);
		TreeNode<Object> n5 = TreeNode.create(10);
		root.setLeftChild(n2);
		root.setRightChild(n5);
		
		TreeNode<Object> n7 = TreeNode.create(20);
		TreeNode<Object> n3 = TreeNode.create(1);		
		n2.setLeftChild(n7);
		n2.setRightChild(n3);
		
		TreeNode<Object> n4 = TreeNode.create(-25);
		n5.setRightChild(n4);
		
		TreeNode<Object> n6 = TreeNode.create(3);
		TreeNode<Object> n9 = TreeNode.create(4);
		n4.setLeftChild(n6);
		n4.setRightChild(n9);
		
		Tree tree = Tree.create(root);
		
		TreeSum.getInstance().maxPathSum(tree);
		
	}
	
//	public static void parentSum() {
//		TreeNode<Object> root = TreeNode.create(4);
//		TreeNode<Object> n2 = TreeNode.create(2);
//		TreeNode<Object> n5 = TreeNode.create(5);
//		root.setLeftChild(n2);
//		root.setRightChild(n5);
//		
//		TreeNode<Object> n7 = TreeNode.create(7);
//		TreeNode<Object> n3 = TreeNode.create(2);		
//		n2.setLeftChild(n7);
//		n2.setRightChild(n3);
//		
//		TreeNode<Object> n4 = TreeNode.create(2);	
//		TreeNode<Object> n6 = TreeNode.create(3);	
//		n5.setLeftChild(n6);
//		
//		int sum = TreeSum.parentSum(root, 2);
//		System.out.println(sum);
//	}
}
