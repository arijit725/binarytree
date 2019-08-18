package org.arijit.binarytree.test;


import org.arijit.binarytree.Tree;
import org.arijit.binarytree.node.TreeNode;
import org.arijit.binarytree.util.ConstructUtil;


public class TestBinaryTree {

	public static void main(String args[]) {
//		TreeNode<Object> root =  TreeNode.create('D');
		constructWithInOrderPreOrder();
		constructWithInOrderLevelOrder();
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
