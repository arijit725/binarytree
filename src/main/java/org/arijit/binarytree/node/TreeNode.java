package org.arijit.binarytree.node;

public class TreeNode<T extends Object> {

	T value;
	TreeNode<T> leftChild;
	TreeNode<T> rightChild;
	
	private TreeNode(T value) {
		this.value = value;
	}
	
	public TreeNode<T> getLeftChild() {
		return leftChild;
	}
	public TreeNode<T> getRightChild() {
		return rightChild;
	}
	public void setLeftChild(TreeNode<T> leftChild) {
		this.leftChild = leftChild;
	}
	public void setRightChild(TreeNode<T> rightChild) {
		this.rightChild = rightChild;
	}
	
	public T getValue() {
		return value;
	}
	
	public static TreeNode<Object> create(Object value) {
		TreeNode<Object> node = new TreeNode<Object>(value);
		return node;
	}

	@Override
	public String toString() {
		return value.toString();
	}
	
	
	
}
