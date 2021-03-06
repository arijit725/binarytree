package org.arijit.binarytree.test;


import org.arijit.binarytree.Tree;
import org.arijit.binarytree.node.TreeNode;
import org.arijit.binarytree.traversal.TreeTraversal;
import org.arijit.binarytree.util.ConstructUtil;


public class TestBinaryTree {

	public static void main(String args[]) {
//		constructWithInOrderPreOrder();
//		constructWithInOrderLevelOrder();
//		
//		bottomView();
//		
//		verticalView();
//		
//		density();
		
//		parentChildMap();
		
		diagonalTraversalTest();
	}
	
	private static void diagonalTraversalTest() {
		TreeNode<Object> root = TreeNode.create(8);
		TreeNode<Object> l11 = TreeNode.create(3);
		TreeNode<Object> r11 = TreeNode.create(10);
		root.setLeftChild(l11);
		root.setRightChild(r11);
		TreeNode<Object> l12 = TreeNode.create(1);
		l11.setLeftChild(l12);
		TreeNode<Object> r1l1 = TreeNode.create(6);
		TreeNode<Object> r1r1 = TreeNode.create(14);
		r11.setLeftChild(r1l1);
		r11.setRightChild(r1r1);
		TreeNode<Object> r1l2 = TreeNode.create(4);
		TreeNode<Object> r1r2 = TreeNode.create(7);
		r1l1.setLeftChild(r1l2);
		r1l1.setRightChild(r1r2);
		TreeNode<Object> r1r3 = TreeNode.create(13);
		r1r1.setLeftChild(r1r3);
		
		Tree tree = Tree.create(root);
		TreeTraversal.getInstance().diagonalTraversalRecr(tree);
		
		
	}
	
	private static void parentChildMap() {
		TreeNode<Object> root = TreeNode.create(1);
		TreeNode<Object> l11 = TreeNode.create(2);
		TreeNode<Object> r11 = TreeNode.create(3);
		root.setLeftChild(l11);
		root.setRightChild(r11);
		TreeNode<Object> l21 = TreeNode.create(4);
		TreeNode<Object> r21 = TreeNode.create(5);
		l11.setLeftChild(l21);
		l11.setRightChild(r21);
		TreeNode<Object> l22 = TreeNode.create(6);
		TreeNode<Object> r22 = TreeNode.create(7);
		r11.setLeftChild(l22);
		r11.setLeftChild(r22);
		TreeNode<Object> r31 = TreeNode.create(8);
		r21.setRightChild(r31);
		Tree tree = Tree.create(root);
		System.out.println("Approach 1: ");
		tree.childParent();
		System.out.println("Approach 2: ");
		tree.childParent1();
		System.out.println("Approach 3: ");
		tree.childParentIterative();
	
		
	}
	private static void density() {
		TreeNode<Object> root = TreeNode.create(1);
		TreeNode<Object> node1 = TreeNode.create(2);
		TreeNode<Object> node2 = TreeNode.create(3);
		root.setLeftChild(node1);
		root.setRightChild(node2);
		Tree tree = Tree.create(root);
		tree.density();
	}
	private static void verticalView() {
		TreeNode<Object> root = TreeNode.create(1);
		TreeNode<Object> node1 = TreeNode.create(2);
		TreeNode<Object> node2 = TreeNode.create(3);
		root.setLeftChild(node1);
		root.setRightChild(node2);
		
		TreeNode<Object> node3 = TreeNode.create(4);
		TreeNode<Object> node4 = TreeNode.create(5);
		node1.setLeftChild(node3);
		node1.setRightChild(node4);
		
		TreeNode<Object> node5 = TreeNode.create(6);
		TreeNode<Object> node6 = TreeNode.create(7);
		node2.setLeftChild(node5);
		node2.setRightChild(node6);
		
		TreeNode<Object> node7 = TreeNode.create(8);
		node5.setRightChild(node7);
		TreeNode<Object> node8 = TreeNode.create(9);
		node6.setRightChild(node8);
		
		Tree tree = Tree.create(root);
		tree.verticalOrder();
	}
	
	
	private static void bottomView() {
		TreeNode<Object> root = TreeNode.create(20);
		TreeNode<Object> node1 = TreeNode.create(8);
		TreeNode<Object> node2 = TreeNode.create(22);
		root.setLeftChild(node1);
		root.setRightChild(node2);
		
		TreeNode<Object> node3 = TreeNode.create(5);
		TreeNode<Object> node4 = TreeNode.create(3);
		node1.setLeftChild(node3);
		node1.setRightChild(node4);
		
		TreeNode<Object> node5 = TreeNode.create(4);
		TreeNode<Object> node6 = TreeNode.create(25);
		node2.setLeftChild(node5);
		node2.setRightChild(node6);
		
		TreeNode<Object> node7 = TreeNode.create(10);
		TreeNode<Object> node8 = TreeNode.create(14);
		node4.setLeftChild(node7);
		node4.setRightChild(node8);
		
		Tree tree = Tree.create(root);
		
		tree.bottomView();
	}
	
	private static void constructWithInOrderPreOrder() {
		Character[] inOrder = {'D','B','E','A','F','C'};
		Character[] preOrder = {'A','B','D','E','C','F'};
		Tree tree = ConstructUtil.getInstance().constructInPre(inOrder, preOrder);
		tree.inOrder();
		tree.preOrder();
	}
	
	private static void constructWithInOrderLevelOrder() {
		Integer[] inOrder = {4,8,10,12,14,20,22};
		Integer[] levelOrder = {20,8,22,4,12,10,14};
		Tree tree = ConstructUtil.getInstance().constructInLevel(inOrder, levelOrder);
		tree.inOrder();
		tree.preOrder();
	}
}
