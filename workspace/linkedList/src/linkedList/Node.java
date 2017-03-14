package linkedList;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Stack;

public class Node {
	
	Node next = null;
	int d;
	
	Node(int d) {
		this.d = d;
		
	}
	
	public Node addNode(int d) {
		Node node = new Node(d);
		Node current = this;
		
		while ( current.next != null ) {
			current = current.next;
		}
		current.next = node;
		return this;
		
	}
	
	public Node addNode(Node n) {
		Node current = this;
		while ( current.next != null ) {
			current = current.next;
		}
		current.next = n;
		return this;
	}
	
	public void displayNode(  ) {
		Node n = this;
		
		while ( n.next != null ) {
			System.out.println(n.d);
			n = n.next;
		}
		System.out.print(n.d);
		System.out.println("\n");
	}
	
	public Node deleteDups() {
		Node node1 = this;
		
		while ( node1 != null ) {
			Node node2 = node1;
			
			while ( node2.next != null ) {
				if ( node1.d == node2.next.d ) {
					node2.next = node2.next.next; // != null ? node2.next.next : null;
				} else {
					node2 = node2.next;
				}
			}
			node1 = node1.next;		
		}
		return this;
	}
	
	public Node find(int d) {
		Node current = this;
		
		while ( current != null && current.d != d ) {
			current = current.next;
		}
		return current;
	}
	
	public int kthToLast(int k) {
		Node kth = this;
		Node tail = this;
		
		while ( tail != null && k != 0) {
			tail = tail.next;
			k--;
		}
		if ( k != 0 ) return -1;
		
		while ( tail.next != null ) {
			kth = kth.next;
			tail = tail.next;
		}
		return kth.d;
	}
	
	public void deleteNode(Node ntod) {
		Node current = this, prev = null;
		
		while ( !current.equals(ntod) ) {
			prev = current;
			current = current.next;
		}
		prev.next = prev.next.next;
	}
	
	public static Node sumNode(Node n1, Node n2) {
		Node nSum = new Node(0);
		return sumNodeRec(n1,n2,nSum);
	}
	
	public static Node sumNodeRec(Node n1, Node n2, Node nSum) {
		if ( n1 != null && n2 != null ) {
			nSum.d += (n1.d+n2.d)%10;
			nSum.addNode((n1.d + n2.d) >= 10 ? 1 : 0);
			sumNodeRec(n1.next, n2.next, nSum.next);
		} else if ( n1 == null && n2 != null ) {
			nSum.addNode((n2.d + nSum.d) >= 10 ? 1 : 0);
			nSum.d += n2.d % 10;
			sumNodeRec(n1, n2.next, nSum.next);
		} else if ( n1 != null && n2 == null ) {
			nSum.addNode((n1.d + nSum.d) >= 10 ? 1 : 0);
			nSum.d += n1.d % 10;
			sumNodeRec(n1.next, n2, nSum.next);
		} else {
			return nSum;
		}
		return nSum;

	}
	
	public Boolean isPalindrom() {
		int mid = 0;
		Node current = this;
		while ( current != null ) {
			current = current.next;
			mid++;
		}
		int isOdd = mid % 2;
		int len = mid;
		mid /= 2;
		current = this;
		Stack st = new Stack();
		for (int i = 0; i < mid; i++) {
			st.push(current.d);
			current = current.next;
		}
		int mid2 = isOdd == 1 ? mid+2 : mid+1;
		if ( isOdd == 1 ) {
			current = current.next;
		}
		while ( mid2 < len && (int) st.pop() == current.d ) {
			current = current.next;
			mid2++;
		}
		return ( mid2 == len);
		
	}
	
	public Node firstNode() {
		Node current = this;
		Map<Node, Boolean> myMap = new LinkedHashMap<Node, Boolean>();
		while ( myMap.get(current) == null ) {
			myMap.put(current, true);
			current = current.next;
		}
		return current;
	}

	public static void main(String args[]) {
		
		/*Node n = new Node(15);
		n.addNode(18);
		n.addNode(5);
		n.addNode(7);
		n.addNode(18);
		n.addNode(26);
		n.addNode(18);
		n.addNode(5);
		n.displayNode();
		
		//n.deleteDups();
		//n.displayNode();
		Node myNode = n.find(5);
		n.deleteNode(myNode);
		n.displayNode();
		//System.out.println(" kth to lastr : " + n.kthToLast(2));*/
		
		//Node n1 = new Node(7);
		//n1.addNode(8);
		//n1.addNode(6);
		
		//Node n2 = new Node(9);
		//n2.addNode(5);
		//n2.addNode(4);
		
		//Node nSum = sumNode(n1,n2);
		//nSum.displayNode();
		
		/*Node n = new Node(1);
		n.addNode(2);
		n.addNode(3);
		n.addNode(4);
		n.addNode(5);
		n.addNode(3);
		n.addNode(2);
		n.addNode(1);
		n.displayNode();
		System.out.println("palindrom : " + n.isPalindrom());
		*/
		
		//Corrupt circular linked list
		Node n = new Node(1);
		Node n3 = new Node(3);
		n.addNode(2);
		n.addNode(n3);
		n.addNode(4);
		n.addNode(5);
		n.addNode(n3);
		//n.displayNode();
		Node test = n.firstNode(); //retourne l'élément au début de la boucle
		System.out.println("my looped node : " + test.d);
		
	}
}
