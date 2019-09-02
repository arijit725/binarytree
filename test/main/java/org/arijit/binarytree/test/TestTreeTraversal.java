package org.arijit.binarytree.test;

import org.arijit.binarytree.Tree;
import org.arijit.binarytree.node.TreeNode;
import org.arijit.binarytree.traversal.TreeTraversal;

public class TestTreeTraversal {

	public static void main(String args[]) {
		boundaryTraversal();
	}

	public static void boundaryTraversal() {
		TreeNode<Object> root = TreeNode.create(20);
		TreeNode<Object> l1 = TreeNode.create(8);
		TreeNode<Object> l2 = TreeNode.create(22);
		root.setLeftChild(l1);
		root.setRightChild(l2);
		TreeNode<Object> l3 = TreeNode.create(4);
		TreeNode<Object> l4 = TreeNode.create(12);
		l1.setLeftChild(l3);
		l1.setRightChild(l4);
		TreeNode<Object> l5 = TreeNode.create(10);
		TreeNode<Object> l6 = TreeNode.create(14);
		l4.setLeftChild(l5);
		l4.setRightChild(l6);
		TreeNode<Object> l7 = TreeNode.create(25);
		l2.setRightChild(l7);

		TreeNode<Object> l8 = TreeNode.create(30);
		l7.setLeftChild(l8);
		TreeNode<Object> l9 = TreeNode.create(31);
		l8.setLeftChild(l9);

		Tree tree = Tree.create(root);
		TreeTraversal.getInstance().boundaryTraversal(tree);
		TreeTraversal.getInstance().IterativeBoudaryTraversal(tree);
	}
}
