package org.arijit.binarytree;

import java.util.Stack;

import org.arijit.binarytree.node.TreeNode;


public class Tree {

	private TreeNode<Object> root;
	
	private Tree(TreeNode<Object> root) {
		this.root = root;
	}
	
	public static Tree create(TreeNode<Object> root){
		Tree tree = new Tree(root);
		return tree;
	}
	
	public void inOrder() {
		System.out.println("Inorder in Iterative way: ");
		TreeNode<Object> tmpRoot = root;
		Stack<TreeNode<Object>> stk = new Stack<TreeNode<Object>>();
		while(tmpRoot!=null|| !stk.isEmpty()) {
			if(tmpRoot!=null) {
				stk.push(tmpRoot);
				tmpRoot=tmpRoot.getLeftChild();				
			}
			else {
				tmpRoot = stk.pop();
				System.out.print(tmpRoot+" ");
				tmpRoot = tmpRoot.getRightChild();
			}
		}
	}
	
	public void preOrder() {
		System.out.println("Preorder in Iterative way: ");
		TreeNode<Object> tmpRoot = root;
		Stack<TreeNode<Object>> stk = new Stack<TreeNode<Object>>();
		while(tmpRoot!=null|| !stk.isEmpty()) {
			if(tmpRoot!=null) {
				stk.push(tmpRoot);
				System.out.print(tmpRoot+" ");
				tmpRoot=tmpRoot.getLeftChild();				
			}
			else {
				tmpRoot = stk.pop();
				
				tmpRoot = tmpRoot.getRightChild();
			}
		}
	}
}
