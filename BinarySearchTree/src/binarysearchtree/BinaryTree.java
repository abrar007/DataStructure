package binarysearchtree;


public class BinaryTree {
	
	static Node root;
	
	public static void main(String [] args) {
		BinaryTree bintree=new BinaryTree();
		bintree.insertNode(6);
		bintree.insertNode(9);
		bintree.insertNode(5);
		bintree.insertNode(4);
		bintree.insertNode(3);
		bintree.insertNode(10);
		bintree.insertNode(11);
		bintree.insertNode(13);
		bintree.insertNode(14);
		bintree.insertNode(15);
		bintree.insertNode(2);
		bintree.insertNode(7);
		bintree.insertNode(12);
		
		bintree.display(root);
		deleteKey(9);
		deleteKey(11);
		System.out.println();
		bintree.display(root);
		
		System.out.println();
		//System.out.println(inOrder(root.rightnode));
		
		
		}
	public void display(Node root) {
		if(root==null) {
			return;
		}
		System.out.print(root.value+" ");
		display(root.leftnode);
		display(root.rightnode);
	}
	public static int findNumberOfChild(Node root,int value) {
		if(root==null) {
			return 0;
		}if(value==root.value) {
			if(root.leftnode!=null&&root.rightnode!=null) {
				return 2;
			}if(root.leftnode!=null&&root.rightnode==null) {
				return 1;
			}if(root.rightnode!=null&&root.leftnode==null) {
				return 1;
			}if(root.leftnode==null&&root.rightnode==null) {
				return 0;
			}
			
		}if(value>root.value) {
		  return findNumberOfChild(root.rightnode,value);
		}else {
			return findNumberOfChild(root.leftnode,value);
		}
		
	}
	
	public static int inOrder(Node root) {
		        int minv = root.value; 
		        Node parent=root;
		        while (root.leftnode != null) 
		        { 
		        	parent=root;
		            minv = root.leftnode.value; 
		            root = root.leftnode; 
		        } 
		        
		      //  System.out.println("Parent "+parent.value+"Child "+root.value);
		        return minv; 
		    
	
	}
	  static void deleteKey(int key) 
	    { 
	        root = deleteRec(root, key); 
	    } 
	  
	    /* A recursive function to insert a new key in BST */
	  static  Node  deleteRec(Node root, int key) 
	    { 
	        /* Base Case: If the tree is empty */
	        if (root == null)  return root; 
	  
	        /* Otherwise, recur down the tree */
	        if (key < root.value) 
	            root.leftnode = deleteRec(root.leftnode, key); 
	        else if (key > root.value) 
	            root.rightnode = deleteRec(root.rightnode, key); 
	  
	        // if key is same as root's key, then This is the node 
	        // to be deleted 
	        else
	        { 
	            // node with only one child or no child 
	            if (root.leftnode == null) 
	                return root.rightnode; 
	            else if (root.rightnode == null) 
	                return root.leftnode; 
	  
	            // node with two children: Get the inorder successor (smallest 
	            // in the right subtree) 
	            root.value = inOrder(root.rightnode); 
	  
	            // Delete the inorder successor 
	            root.rightnode = deleteRec(root.rightnode, root.value); 
	        } 
	  
	        return root; 
	    } 
	  
	
	
		
	public static boolean findNode(Node root,int value) {
		if(root==null) {
			return false;
		}if(root.value==value) {
			return true;
		}if(value>root.value) {
			return findNode(root.rightnode,value);	
		}if(value<root.value) {
			return findNode(root.leftnode,value);
		}else {
			return false;
		}
	}

	public void insertNode(int value) {
		Node node=new Node();
		node.value=value;
		//Current and parent points to the root node
		Node current=root;
		Node parent=root;	
		//if root null then make a node and this becomes the root 
		if(root==null) {
			root=node;
			
		}
		// else the node need to be inserted at a certain position
		else {
			while(true) {
				//current node is set at parents
				parent=current;
				// value is more then the current value then 
				// go right and update current
				if(value>current.value) {
					current=current.rightnode;
					//if current becomes null then 
					//we are at the leaf node and we must add it here
					if(current==null) {
						parent.rightnode=node;
						return;
					}
					//if value is less then current value
					//we traverse left of the tree
				}else {
					current=current.leftnode;
					if(current==null) {
						parent.leftnode=node;
						return;
					}
				}	
			}	
		}	
	}
	
		
	
}
// this is the node class 
//each node has a value a pointer to left and right  
class Node{
	int value=0;
	Node leftnode=null;
	Node rightnode=null;
	
	public Node(int value,Node left_child,Node right_child) {
		this.value=value;
		this.leftnode=left_child;
		this.rightnode=right_child;
		
	}
	public Node() {
		
	}
}