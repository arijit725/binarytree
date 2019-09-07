package org.arijit.binarytree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Stack;
import java.util.TreeMap;

import org.arijit.binarytree.node.TreeNode;

/**
 * All sort of Tree operations
 * 
 * @author ARIJIT
 *
 */
public class Tree {

	private TreeNode<Object> root;

	private Tree(TreeNode<Object> root) {
		this.root = root;
	}

	public static Tree create(TreeNode<Object> root) {
		Tree tree = new Tree(root);
		return tree;
	}

	public void inOrder() {
		System.out.println("Inorder in Iterative way: ");
		TreeNode<Object> tmpRoot = root;
		Stack<TreeNode<Object>> stk = new Stack<TreeNode<Object>>();
		while (tmpRoot != null || !stk.isEmpty()) {
			if (tmpRoot != null) {
				stk.push(tmpRoot);
				tmpRoot = tmpRoot.getLeftChild();
			} else {
				tmpRoot = stk.pop();
				System.out.print(tmpRoot + " ");
				tmpRoot = tmpRoot.getRightChild();
			}
		}
	}

	/**
	 * 
	 */
	public void preOrder() {
		System.out.println("Preorder in Iterative way: ");
		TreeNode<Object> tmpRoot = root;
		Stack<TreeNode<Object>> stk = new Stack<TreeNode<Object>>();
		while (tmpRoot != null || !stk.isEmpty()) {
			if (tmpRoot != null) {
				stk.push(tmpRoot);
				System.out.print(tmpRoot + " ");
				tmpRoot = tmpRoot.getLeftChild();
			} else {
				tmpRoot = stk.pop();

				tmpRoot = tmpRoot.getRightChild();
			}
		}
	}

	/**
	 * Given a Binary Tree, we need to print the bottom view from left to right. A
	 * node x is there in output if x is the bottommost node at its horizontal
	 * distance. Horizontal distance of left child of a node x is equal to
	 * horizontal distance of x minus 1, and that of right child is horizontal
	 * distance of x plus 1. If there are multiple bottom-most nodes for a
	 * horizontal distance from root, then print the later one in level traversal.
	 * 
	 */
	public void bottomView() {
		TreeNode<Object> tmpRoot = root;
		LinkedList<TreeNode<Object>> queue = new LinkedList<TreeNode<Object>>();
		queue.add(tmpRoot);
		// horizontalMap will always hold the last element of the same horizontal
		// distance.
		Map<Integer, TreeNode<Object>> horizontalMap = new HashMap<Integer, TreeNode<Object>>();
		while (!queue.isEmpty()) {
			tmpRoot = queue.poll();
			horizontalMap.put(tmpRoot.getHorizontalDistance(), tmpRoot);
			if (tmpRoot.getLeftChild() != null) {
				tmpRoot.getLeftChild().setHorizontalDistance(tmpRoot.getHorizontalDistance() - 1);
				queue.add(tmpRoot.getLeftChild());
			}
			if (tmpRoot.getRightChild() != null) {
				tmpRoot.getRightChild().setHorizontalDistance(tmpRoot.getHorizontalDistance() + 1);
				queue.add(tmpRoot.getRightChild());
			}
		}
		Iterator<Entry<Integer, TreeNode<Object>>> it = horizontalMap.entrySet().iterator();
		System.out.println("Bottom View: \n");
		while (it.hasNext()) {
			System.out.print(it.next().getValue() + " ");
		}
	}

	/**
	 * In VerticalOrder traversal print all the node in same horizontal distance and
	 * move to next horizontal distance Keep on printing untill all the nodes are
	 * printed.
	 */
	public void verticalOrder() {
		TreeNode<Object> tmpRoot = root;
		LinkedList<TreeNode<Object>> queue = new LinkedList<TreeNode<Object>>();
		queue.add(tmpRoot);
		// horizontalMap will always hold the last element of the same horizontal
		// distance.
		Map<Integer, List<TreeNode<Object>>> horizontalMap = new TreeMap<Integer, List<TreeNode<Object>>>();
		while (!queue.isEmpty()) {
			tmpRoot = queue.poll();
			if (!horizontalMap.containsKey(tmpRoot.getHorizontalDistance())) {
				horizontalMap.put(tmpRoot.getHorizontalDistance(), new ArrayList<TreeNode<Object>>());
			}
			horizontalMap.get(tmpRoot.getHorizontalDistance()).add(tmpRoot);
			if (tmpRoot.getLeftChild() != null) {
				tmpRoot.getLeftChild().setHorizontalDistance(tmpRoot.getHorizontalDistance() - 1);
				queue.add(tmpRoot.getLeftChild());
			}
			if (tmpRoot.getRightChild() != null) {
				tmpRoot.getRightChild().setHorizontalDistance(tmpRoot.getHorizontalDistance() + 1);
				queue.add(tmpRoot.getRightChild());
			}
		}

		System.out.println("Vertical Order Traversal: " + horizontalMap);

	}
	
	/**
	 * Density of Binary Tree = Size / Height 
	 */
	public void density() {
		TreeNode<Object> tmpRoot = root;
		LinkedList<TreeNode<Object>> q = new LinkedList<TreeNode<Object>>();
		q.add(tmpRoot);
		int nodeCount = q.size();
		int totalNode = nodeCount;
		int height = 1;
		while(!q.isEmpty()) {
			if(nodeCount ==0) {
				nodeCount = q.size();
				totalNode = totalNode+nodeCount;
				height++;				
			}
			tmpRoot = q.poll();
			if(tmpRoot.getLeftChild()!=null)
				q.add(tmpRoot.getLeftChild());
			if(tmpRoot.getRightChild()!=null)
				q.add(tmpRoot.getRightChild());
			nodeCount--;
		}
		float density =(float) totalNode/height;
		System.out.println("TotalNode: "+totalNode+" height: "+height+" density: "+density);
	}
	
	public TreeNode<Object> getRoot() {
		TreeNode<Object> tmpRoot = root;
		return tmpRoot;
	}
	
}
