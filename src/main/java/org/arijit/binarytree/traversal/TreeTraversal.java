package org.arijit.binarytree.traversal;

import java.util.LinkedList;
import java.util.Stack;

import org.arijit.binarytree.Tree;
import org.arijit.binarytree.node.TreeNode;

public class TreeTraversal {

	private static final TreeTraversal instance = new TreeTraversal();

	/**
	 * <pre>
	 * Given a binary tree and a node, print all cousins of given node. Note that siblings should not be printed.
	
		Examples:
		
		Input : root of below tree 
		         1
		       /   \
		      2     3
		    /   \  /  \
		   4    5  6   7
		   and pointer to a node say 5.
	
		Output : 6, 7
	 * </pre>
	 * 
	 * @param tree
	 * @param node
	 */
	public void cousinTraversal(Tree tree, TreeNode<Object> node) {

		TreeNode<Object> root = tree.getRoot();
		LinkedList<TreeNode<Object>> q = new LinkedList<TreeNode<Object>>();
		q.add(root);
		int nodeCount = q.size();
		boolean cousinFound = false;
		int height = 0;
		int parentHeight = 0;
		while (!q.isEmpty()) {
			if (nodeCount == 0) {
				nodeCount = q.size();
				height++;
			}
			root = q.poll();
			if (cousinFound && height > parentHeight) {
				// we are checking at which level parents are having child and based on that we
				// are traversing. So all child should be a layer below the height where the
				// child node matches with target node.
				System.out.println(root.getValue());
			}
			if (root.getLeftChild() == node || root.getRightChild() == node) {
				// we want cousin, not siblings, so we will not print sibling
				cousinFound = true; // but this is the level where all other cousin will present. so mark the point
				parentHeight = height;

			} else {
				if (root.getLeftChild() != null)

					q.add(root.getLeftChild());
				if (root.getRightChild() != null)
					q.add(root.getRightChild());
			}
			nodeCount--;
		}
	}

	public void iterativeDiagonalTraversal(Tree tree) {
		LinkedList<TreeNode<Object>> q = new LinkedList<TreeNode<Object>>();
		TreeNode<Object> root = tree.getRoot();
		while (root != null || !q.isEmpty()) {
			if (root != null) {
				System.out.print(root + " ");
				TreeNode<Object> leftChild = root.getLeftChild();
				if (leftChild != null)
					q.add(leftChild);
				root = root.getRightChild();

			} else {
				root = q.poll();
			}
		}

	}

	public void IterativeBoudaryTraversal(Tree tree) {
		TreeNode<Object> root = tree.getRoot();
		// this contains left boundary of tree
		Stack<Object> leftStk = new Stack<Object>();
		Stack<Object> rightStk = new Stack<Object>();
		Stack<Object> leafStk = new Stack<Object>();

		LinkedList<TreeNode<Object>> q = new LinkedList<TreeNode<Object>>();
		q.add(root);
		int nodeCount = q.size();
		boolean left = true;
		while (!q.isEmpty()) {
			if (nodeCount == 0) {
				left = true;
				nodeCount = q.size();
			}
			TreeNode<Object> tmpRoot = q.poll();

			if (tmpRoot.getLeftChild() != null) {
				q.add(tmpRoot.getLeftChild());
			}
			if (tmpRoot.getRightChild() != null) {
				q.add(tmpRoot.getRightChild());
			}
			if (tmpRoot.getLeftChild() == null && tmpRoot.getRightChild() == null) {
				// its a leaf. no need to go down.
				leafStk.add(tmpRoot);
				left = false;

			} else if (left) {
				leftStk.push(tmpRoot);
				left = false;

			} else if (nodeCount == 1) {
				// this node is rightmost node in this level
				rightStk.add(tmpRoot);
			}
			nodeCount--;
		}
		System.out.println(leftStk);
		System.out.println(leafStk);
		System.out.println(rightStk);

	}

	public void boundaryTraversal(Tree tree) {
		TreeNode<Object> root = tree.getRoot();
		System.out.println(root.getValue());
		leftBoundary(root.getLeftChild());
		leafNode(root);
		rightBoundary(root.getRightChild());
	}

	/**
	 * Printing left boundary
	 * 
	 * @param root
	 */
	public void leftBoundary(TreeNode<Object> root) {
		if (root == null)
			return;
		if (root.getLeftChild() == null && root.getRightChild() == null)
			return;// we will not print leaf node while printing leftBoundary
		System.out.println(root.getValue());
		if (root.getLeftChild() != null)
			leftBoundary(root.getLeftChild());
		else if (root.getRightChild() != null)
			leftBoundary(root.getRightChild());
	}

	/**
	 * Printing right boundary. Here we will first encounter right child and if no
	 * right child found then will check for left child As we are goging in
	 * anticlockwise direction, rightBoundary will be traversed in bottomUP manner,
	 * means print child first and then go up
	 * 
	 * @param root
	 */
	public void rightBoundary(TreeNode<Object> root) {
		if (root == null)
			return;
		if (root.getLeftChild() == null && root.getRightChild() == null)
			return;
		if (root.getRightChild() != null)
			rightBoundary(root.getRightChild());
		else if (root.getLeftChild() != null)
			rightBoundary(root.getLeftChild());
		System.out.println(root.getValue());
	}

	public void leafNode(TreeNode<Object> root) {
		if (root == null)
			return;
		if (root.getLeftChild() == null && root.getRightChild() == null)
			System.out.println(root.getValue());
		leafNode(root.getLeftChild());
		leafNode(root.getRightChild());
	}

	public static TreeTraversal getInstance() {
		return instance;
	}

	public void diagonalTraversalRecr(Tree tree) {
		TreeNode<Object> root = tree.getRoot();
		LinkedList<TreeNode<Object>> q = new LinkedList<TreeNode<Object>>();
		diagonalTraversalRecr(root, q);
	}

	private void diagonalTraversalRecr(TreeNode<Object> root, LinkedList<TreeNode<Object>> q) {
		if (root == null)
			return;
		System.out.print(root.getValue() + " ");
		if (root.getLeftChild() != null) {
			q.add(root.getLeftChild());
		}
		if (root.getRightChild() != null) {
			diagonalTraversalRecr(root.getRightChild(), q);
		}
		System.out.println();
		root = q.poll();
		diagonalTraversalRecr(root, q);
	}
}
