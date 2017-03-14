package treeQuestion;

import java.util.ArrayList;
import java.util.LinkedList;

public class TreeNode {

	public int data;      
	public TreeNode left;    
	public TreeNode right; 
	public TreeNode parent;
	private int size = 0;
	
	public TreeNode(int data) {
		this.data = data;
		this.size = 1;
	}
	
	private void setLeftChild(TreeNode left) {
		this.left = left;
		if ( left != null ) {
			left.parent = this;
			
		}		
	}
	
	private void setRightChild(TreeNode right) {
		this.right = right;
		if ( right != null ) {
			right.parent = this;
		}
	}
	
	public void insertInOrder(int d) {
		if ( d <= data ) {
			if ( left == null ) {
				setLeftChild(new TreeNode(d));
			} else {
				left.insertInOrder(d);
			}
		} else {
			if ( right == null ) {
				setRightChild(new TreeNode(d));
			} else {
				right.insertInOrder(d);
			}
		}
		size++;
	}
	
	public int size() {
		return size();
	}
	
	public boolean isBST() {
		
		if ( left != null ) {
			if ( left.data > data || !left.isBST() ) return false;
			left.isBST();
		}
		if ( right != null ) {
			if ( right.data < data || !right.isBST() ) return false;
		}
		
		return true;
	}
	
	public int height() {
		int leftHeight = left != null ? left.height() : 0;
		int rightHeight = right != null ? right.height() : 0;
		return 1 + Math.max(leftHeight, rightHeight);
	}
	
	public TreeNode find(int d) {
		if ( data == d ) {
			return this;
		} else if ( d <= data ) {
			return left != null ? left.find(d) : null;
		} else if ( d > data ) {
			return right != null ? right.find(d) : null;
		}
		
		return null;
	}
	
	public static TreeNode createMinimalBST(int array[], int start, int end) {
		if ( end < start ) {
			return null;
		}
		int mid = (start + end)/2;
		TreeNode n = new TreeNode(array[mid]);
		n.setLeftChild(createMinimalBST(array, start, mid-1));
		n.setRightChild(createMinimalBST(array, mid+1, end));
		return n;		
	}
	
	public static TreeNode createMinimalBST(int array[]) {
		return createMinimalBST(array, 0, array.length - 1);
	}
	
	@Override
	public boolean equals(Object other) {
		if ( !(other instanceof TreeNode) ) return false;
		TreeNode node = (TreeNode) other;
		if (this.parent.equals(node.parent)) {
			return true;
		}
		return false;
		
	}
	
	//Question 4.8
	public TreeNode firstCommonAncestor(TreeNode n1, TreeNode n2) {
		int delta = depth(n1) - depth(n2);
		TreeNode firstNode = delta > 0 ? n2 : n1;
		TreeNode secondNode = delta > 0 ? n1 : n2;
		
		secondNode.goUpBy(delta);
		
		while ( firstNode != null && !firstNode.equals(secondNode) ) {
			firstNode = firstNode.parent;
			secondNode = secondNode.parent;
		}
		
		return firstNode;
	}
	
	public void goUpBy( int step) {
		int i = 0;
		TreeNode currentNode = this;
		
		step = Math.abs(step);		
		while ( i < step ) {
			currentNode = currentNode.parent;
			i++;
		}
	}
	
	public int depth(TreeNode n) {
		int i = 0;
		while ( n != null ) {
			n = n.parent;
			i++;
		}
		return i;
	}
	
}
