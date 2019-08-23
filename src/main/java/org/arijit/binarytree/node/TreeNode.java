package org.arijit.binarytree.node;

public class TreeNode<T extends Object> {

	private T value;
	private TreeNode<T> leftChild;
	private TreeNode<T> rightChild;
	private int horizontalDistance;
	
	private TreeNode(T value) {
		this.value = value;
	}
	
	public int getHorizontalDistance() {
		return horizontalDistance;
	}
	public void setHorizontalDistance(int horizontalDistance) {
		this.horizontalDistance = horizontalDistance;
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
