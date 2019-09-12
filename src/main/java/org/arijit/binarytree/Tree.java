package org.arijit.binarytree;

import java.util.ArrayList;
import java.util.Arrays;
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
	
	
	/**
	 * This is an iterative approch to find all parent of a child present in a tree.
	 */
	public void childParentIterative() {
		TreeNode<Object> tmpRoot = root;
		LinkedList<TreeNode<Object>> q = new LinkedList<TreeNode<Object>>();
		HashMap<Object, Object> childParentMap = new HashMap<Object, Object>();
		HashMap<Object, List<Object>> allParentChildMap = new HashMap<Object, List<Object>>();
		q.push(tmpRoot);
		while(!q.isEmpty()) {
			tmpRoot = q.poll();
			if(tmpRoot.getLeftChild()!=null) {
				childParentMap.put(tmpRoot.getLeftChild(),tmpRoot);
				q.add(tmpRoot.getLeftChild());
			}
			if(tmpRoot.getRightChild()!=null) {
				childParentMap.put(tmpRoot.getRightChild(),tmpRoot);
				q.add(tmpRoot.getRightChild());
			}	
		}
		Iterator<Entry<Object, Object>> it = childParentMap.entrySet().iterator();
		while(it.hasNext()) {
			Entry<Object, Object> entry = it.next();
			Object val = entry.getValue();
			while(val!=null) {
				if(!allParentChildMap.containsKey(entry.getKey())){
					List<Object> list= new ArrayList<Object>();
					allParentChildMap.put(entry.getKey(),list);
				}
				allParentChildMap.get(entry.getKey()).add(val);
				val = childParentMap.get(val);
			}
			
		}
		Iterator<Entry<Object, List<Object>>> aIt = allParentChildMap.entrySet().iterator();
		while(aIt.hasNext()) {
			Entry<Object, List<Object>> entry = aIt.next();
			System.out.println(entry.getKey()+" => "+ entry.getValue());
		}
	}
	
	/**
	 * This is child parent mapping with approch 1
	 */
	public void childParent1() {
		TreeNode<Object> tmpRoot = root;
		HashMap<Object, Object> childParentMap = new HashMap<Object, Object>();
		childParentMap.put(tmpRoot, null);
		childParent(tmpRoot, childParentMap);
		HashMap<Object, List<Object>> allParentChildMap = new HashMap<Object, List<Object>>();
		Iterator<Entry<Object, Object>> it = childParentMap.entrySet().iterator();
		while(it.hasNext()) {
			Entry<Object, Object> entry = it.next();
			Object val = entry.getValue();
			while(val!=null) {
				if(!allParentChildMap.containsKey(entry.getKey())){
					List<Object> list= new ArrayList<Object>();
					allParentChildMap.put(entry.getKey(),list);
				}
				allParentChildMap.get(entry.getKey()).add(val);
				val = childParentMap.get(val);
			}
			
		}
		Iterator<Entry<Object, List<Object>>> aIt = allParentChildMap.entrySet().iterator();
		while(aIt.hasNext()) {
			Entry<Object, List<Object>> entry = aIt.next();
			System.out.println(entry.getKey()+" => "+ entry.getValue());
		}
	}
	
	private void childParent(TreeNode<Object> root,HashMap<Object, Object> childParentMap) {
		if(root==null)
			return;
		if(root.getLeftChild()!=null) {
			childParentMap.put(root.getLeftChild(),root);
			childParent(root.getLeftChild(), childParentMap);
		}
		if(root.getRightChild()!=null) {
			childParentMap.put(root.getRightChild(),root);
			childParent(root.getRightChild(), childParentMap);
		}					
	}
	public void childParent() {
		TreeNode<Object> tmpRoot = root;
		HashMap<Object, List<Object>> childParentMap = new HashMap<Object, List<Object>>();
		Object data[] = new Object[32];
		int index = 0;
		childParent(tmpRoot, data, index, childParentMap);
		System.out.println("Child Parent Map: ");
		Iterator<Entry<Object, List<Object>>> it = childParentMap.entrySet().iterator();
		while(it.hasNext()) {
			Entry<Object, List<Object>> entry = it.next();
			System.out.println(entry.getKey()+" => "+ entry.getValue());
		}
	}
	private void childParent(TreeNode<Object> root, Object[] data, int index, HashMap<Object, List<Object>> childParentMap) {
	
		if(root==null)
			return;
		data[index] = root;
		if(!childParentMap.containsKey(root)) {
			List<Object> parentList = new ArrayList<Object>();
			for(int i=0;i<index;i++) {
				parentList.add(data[i]);
			}
			childParentMap.put(root, parentList);
		}
		if(root.getLeftChild()==null && root.getRightChild()==null) {
			// traverse the data and prepare parent child map
			List<Object> parentList = new ArrayList<Object>();
			for(int i=0;i<index;i++) {
				parentList.add(data[i]);
			}
			childParentMap.put(root, parentList);
			return;
		}
		childParent(root.getLeftChild(), data, index+1, childParentMap);
		childParent(root.getRightChild(),data,index+1,childParentMap);
		
	}
	
	
	public TreeNode<Object> getRoot() {
		TreeNode<Object> tmpRoot = root;
		return tmpRoot;
	}
	
	
}
