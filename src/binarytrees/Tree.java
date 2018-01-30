package binarytrees;

public class Tree {

	public static void main(String[] args) {
		BinaryTree tree= new BinaryTree();
		tree.insert(5);
		tree.insert(8);
		tree.insert(10);
		tree.insert(9);
		tree.insert(2);
	}
}

// Root value is less than the right child and greater than the left child.
class BinaryTree{
	Node root;
	int minValue=Integer.MAX_VALUE;

	public void insert(int data){
		Node node= new Node(data);
		if(root==null)
			root=node; // Is root is null, set first node as root
		else{
			Node current=root, parent;
			while(true){
				parent=current;
				if(data>current.data){ // If node's value is greater than root, go right.
					current=current.rightChild;
					if(current==null){
						parent.rightChild=node;
						return;
					}
				}else{ // If node's value is less than root, go left.
					current=current.leftChild;
					if(current==null){
						parent.leftChild=node;
						return;
					}
				}
			}
		}
	}

	// Iterative process to find a key in Binary tree
	public boolean findKey(int key){
		Node current=root;
		while(current.data!=key){
			if(key>current.data)
				current=current.rightChild;
			else
				current=current.leftChild;
			if(current==null)
				return false;
		}
		return true;
	}

	// Inorder prints the tree in the following order: Left node, root, right node
	public void printInorder(Node root){
		if(root!=null){
			printInorder(root.leftChild);
			System.out.print(root.data+" ");
			printInorder(root.rightChild);
		}
	}

	// Inorder prints the tree in the following order: Root, left node, right node
	public void printPreorder(Node root){
		if(root!=null){
			System.out.print(root.data+" ");
			printPreorder(root.leftChild);
			printPreorder(root.rightChild);
		}
	}
	// Inorder prints the tree in the following order: Left node, right node, root
	public void printPostorder(Node root){
		if(root!=null){
			printPostorder(root.leftChild);
			printPostorder(root.rightChild);
			System.out.print(root.data+" ");
		}
	}

	// Recursive way to find a minimum in Binary tree
	public void findMinInBT(Node root){
		if(root!=null){
			findMinInBT(root.leftChild);
			if(root.data<minValue){
				minValue=root.data;
			}
			findMinInBT(root.rightChild);
		}
	}

	// The left most node of the tree is the minimum
	public Node findMinimumInBST(){
		Node current, last = null;
		current=root;
		while(current!=null){
			last=current;
			current=current.leftChild; // rightChild for max
		}
		return last;
	}
}