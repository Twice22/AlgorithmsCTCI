package treeQuestion;

import java.util.ArrayList;
import java.util.LinkedList;

public class TreeTest {
	
	//Question 4.3
	public static void listOfDepths(TreeNode root, ArrayList<LinkedList<TreeNode>> lists, int level) {
		// cas de base
		if ( root == null ) return;
		
		LinkedList<TreeNode> list = null;
		if ( lists.size() == level ) {
			list = new LinkedList<TreeNode>();
			lists.add(list);
		} else {
			list = lists.get(level);
		}
		list.add(root);
		
		listOfDepths(root.left, lists, level+1);
		listOfDepths(root.right, lists, level+1);
	}
	
	ArrayList<LinkedList<TreeNode>> listOfDepths(TreeNode root) {
		ArrayList<LinkedList<TreeNode>> lists = new ArrayList<LinkedList<TreeNode>>();
		listOfDepths(root, lists, 0);
		return lists;
	}
	
	//Question 4.3 variant
	ArrayList<LinkedList<TreeNode>> createLevelLinkedList(TreeNode root) {
		ArrayList<LinkedList<TreeNode>> lists = new ArrayList<LinkedList<TreeNode>>();
		LinkedList<TreeNode> current = new LinkedList<TreeNode>();
		if ( root != null ) {
			current.add(root);
		}
		
		while ( current.size() > 0 ) {
			lists.add(current);
			LinkedList<TreeNode> parents = current;
			current = new LinkedList<TreeNode>();
			for (TreeNode parent : parents) {
				if ( parent.left != null ) {
					current.add(parent.left);
				}
				if ( parent.right != null ) {
					current.add(parent.right);
				}
			}
		}
		return lists;
		
	}
	
	//Question 4.4
	public int getHeight(TreeNode root) {
		if ( root == null ) return -1;
		return 1 + Math.max(getHeight(root.left), getHeight(root.right));
	}
	
	public boolean isBalanced(TreeNode root) {
		TreeNode leftTree = root.left;
		TreeNode rightTree = root.right;
		if ( Math.abs(getHeight(leftTree) - getHeight(rightTree)) <= 1 ) {
			return false;
		} else {
			return isBalanced(leftTree) && isBalanced(rightTree);
		}
	}
	
	public int checkTree(TreeNode root) {
		if ( root == null ) return -1;
		
		int leftHeight = checkTree(root.left);
		if ( leftHeight == Integer.MIN_VALUE ) return Integer.MIN_VALUE;
		
		int rightHeight = checkTree(root.right);
		if ( rightHeight == Integer.MIN_VALUE ) return Integer.MIN_VALUE;
		
		if ( Math.abs(rightHeight - leftHeight) > 1 ) {
			return Integer.MIN_VALUE;
		} else {
			return 1 + Math.max(leftHeight, rightHeight);
		}
		
	}
	
	//Question 4.4 better solution
	public boolean isBalanced2(TreeNode root) {
		return checkTree(root) != Integer.MIN_VALUE;
	}
	
	//Question 4.5
	Integer last_printed = null;
	public boolean isBST(TreeNode node) {
		if ( node == null ) return true;
		
		if ( !isBST(node.left) ) return false;
		
		if ( last_printed != null && last_printed > node.data ) {
			return false;
		}
		last_printed = node.data;
		
		if ( !isBST(node.right) ) return false;
		
		return true;
	}
	
	//Question 4.6 (a revoir)
	public TreeNode parentOf(TreeNode tree, TreeNode node) {
		if ( tree == null ) return null;
		
		if ( node.equals(tree) ) {
			if ( node.parent != null ) {
				return node.parent;
			}
		}
		parentOf(tree, node.left);
		parentOf(tree, node.right);
		
		return null;
	}

	public static void main(String args[]) {
		
		int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		
		// We needed this code for other files, so check out the code in the library
		TreeNode root = TreeNode.createMinimalBST(array);
		System.out.println("Root? " + root.data);
		System.out.println("Created BST? " + root.isBST());
		System.out.println("Height: " + root.height());
	}
	
	
}
