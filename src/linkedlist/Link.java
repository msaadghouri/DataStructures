package linkedlist;

public class Link {

	public int data;
	public Link next;
	public Link previous; // Used for Doubly Linked List

	public Link(int data) {
		this.data=data;
	}
	public void displayLink(){
		System.out.println("Data"+ data);
	}
}
