package linklist;

public class LinkedList {

	static Node root=null;
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		addLast(22);;
		addLast(21);
		addFirst(50);
		addFirst(1100);
		traverseList();
		
		deleteKey(1100);
		deleteKey(21);
		traverseList();
		
		
		
	}
	
	public static void addLast(int value) {
		
		Node head=root;
		Node new_node=new Node();
		new_node.value=value;
		new_node.next=null;
		
		if(head == null) {
			root=new Node();
			root.value=value;
		}else {
			while(head.next!=null) {
				head=head.next;
			}		
			head.next=new_node;	
		}
	}
	
	public static void addFirst(int value) {
		Node node=new Node();
		node.value=value;
		
		node.next=root;
		root=node;
		
	}
	public static void traverseList() {
		Node head=root;
		while(head!= null) {
			System.out.print(head.value+" ");
			head=head.next;
			
		}
		System.out.println();
	}
	
		 public static void deleteKey(int key){ 
		        // Store head node 
		        Node currNode = root, prev = null; 
		        // CASE 1: 
		        // If head node itself holds the key to be deleted 
		        if (currNode != null && currNode.value == key) { 
		            root = currNode.next; // Changed head 
		            // Display the message 
		            System.out.println(key + " found and deleted"); 
		            return;
		            // Return 
		             
		        } 
		  
		        // 
		        // CASE 2: 
		        // If the key is somewhere other than at head 
		        // 
		  
		        // Search for the key to be deleted, 
		        // keep track of the previous node 
		        // as it is needed to change currNode.next 
		        while (currNode != null && currNode.value != key) { 
		            // If currNode does not hold key 
		            // continue to next node 
		            prev = currNode; 
		            currNode = currNode.next; 
		        } 
		  
		        // If the key was present, it should be at currNode 
		        // Therefore the currNode shall not be null 
		        if (currNode != null) { 
		            // Since the key is at currNode 
		            // Unlink currNode from linked list 
		            prev.next = currNode.next; 
		  
		            // Display the message 
		            System.out.println(key + " found and deleted"); 
		        } 
		  
		        // 
		        // CASE 3: The key is not present 
		        // 
		  
		        // If key was not present in linked list 
		        // currNode should be null 
		        if (currNode == null) { 
		            // Display the message 
		            System.out.println(key + " not found"); 
		        } 
		  
		        // return the List 
		        
		    } 
	
	
	}


class Node{
	int value=0;
	Node next=null;	
}
