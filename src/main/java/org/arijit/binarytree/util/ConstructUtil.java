package org.arijit.binarytree.util;

import org.arijit.binarytree.Tree;
import org.arijit.binarytree.node.TreeNode;

public class ConstructUtil {

	private static ConstructUtil instance = new ConstructUtil();
	
	/**
	 * Construct Tree with inorder and preorder traversal
	 * @param inOrder
	 * @param preOrder
	 * @return
	 */
	public Tree constructInPre(Object[] inOrder, Object[] preOrder) {
		int inStart = 0;
		int inEnd = inOrder.length-1;
		int[] preIndex = {0};
		TreeNode<Object> root = constructInPre(inOrder, preOrder, inStart, inEnd, preIndex);
		Tree tree = Tree.create(root);
		return tree;
	}
	/**
	 * Construct tree with inorder and preorder traversal
	 * @param inOrder
	 * @param preOrder
	 * @param inStart
	 * @param inEnd
	 * @param preIndex
	 * @return
	 */
	private TreeNode<Object> constructInPre(Object[] inOrder, Object[] preOrder, int inStart, int inEnd, int[] preIndex) {
		if(inStart>inEnd)
			return null;
		Object value = preOrder[preIndex[0]];
		TreeNode<Object> node = TreeNode.create(value);
		preIndex[0]=++preIndex[0];
		if(inStart==inEnd) {
			//there are no more child present for this node.
			return node;
		}
		int inIndex = searchInIndex(inOrder, value);
		TreeNode<Object> leftChild = constructInPre(inOrder, preOrder, inStart, inIndex-1, preIndex);
		node.setLeftChild(leftChild);
		TreeNode<Object> rightChild = constructInPre(inOrder, preOrder, inIndex+1, inEnd, preIndex);
		node.setRightChild(rightChild);
		return node;
	}
	
	/**
	 * Search value in the array
	 * @param inOrder
	 * @param value
	 * @return
	 */
	private int searchInIndex(Object[] inOrder, Object value) {
		for(int i=0;i<inOrder.length;i++) {
			if(inOrder[i].equals(value))
				return i;
		}
		return -1;
	}
	
	public Tree constructInLevel(Object[] inOrder, Object[] levelOrder) {
		int inStart = 0;
		int inEnd = inOrder.length-1;
		TreeNode<Object> root = constructInLevel(inOrder, levelOrder, inStart,inEnd);
		Tree tree = Tree.create(root);
		return tree;
	}
	private TreeNode<Object> constructInLevel(Object[] inOrder, Object[] levelOrder, int inStart, int inEnd){
		if(inStart>inEnd)
				return null;
		if(inStart ==  inEnd) {
			TreeNode<Object> node =TreeNode.create(inOrder[inStart]);
			//node does not have any children, so return from this point
			return node;			
		}

		int inIndex = -1;
		for(int i=0;i<levelOrder.length;i++) {
			boolean isFound = false;
			Object value = levelOrder[i];
			for(int j=inStart;j<=inEnd;j++) {
				if(inOrder[j].equals(value)) {
					isFound=true;							
					inIndex = j;
					break;
				}				
			}
			if(isFound)
				break;
		}
		TreeNode<Object> node = TreeNode.create(inOrder[inIndex]);
		TreeNode<Object> leftChild = constructInLevel(inOrder, levelOrder, inStart, inIndex-1);
		node.setLeftChild(leftChild);
		TreeNode<Object> rightChild = constructInLevel(inOrder, levelOrder, inIndex+1, inEnd);
		node.setRightChild(rightChild);
		return node;
	}
	
	public static ConstructUtil getInstance() {
		return instance;
	}
}
