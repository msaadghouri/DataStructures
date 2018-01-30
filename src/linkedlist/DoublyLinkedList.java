package linkedlist;

public class DoublyLinkedList {

	public static void main(String[] args) {
		DoublyLinked theList = new DoublyLinked();
		theList.insertFirst(22);
		theList.insertFirst(44);
		theList.insertFirst(66);
		theList.insertLast(11); 
		theList.insertLast(33);
		theList.insertLast(55);
		theList.displayForward();
		theList.displayBackward();
		theList.deleteFirst(); 
		theList.deleteLast(); 
		theList.deleteKey(11);
		theList.displayForward();
		theList.insertAfter(22, 77);
		theList.insertAfter(33, 88);
		theList.displayForward(); 

	}

}

class DoublyLinked{

	private Link first;
	private Link last;

	public DoublyLinked() {
		first=null;
		last=null;
	}

	public boolean isEmpty(){
		return (first==null);
	}

	public void insertFirst(int key){
		Link newLink= new Link(key);
		if(isEmpty())
			last=newLink;
		else
			first.previous=newLink;
		newLink.next=first;
		first=newLink;
	}

	public void insertLast(int key){
		Link newLink= new Link(key);
		if(isEmpty())
			first=newLink;
		else{
			last.next=newLink;
			newLink.previous=last;
		}
		last=newLink;
	}

	public Link deleteFirst(){
		Link tem=first;
		if(first.next==null)
			last=null;
		else
			first.next.previous=null;
		first=first.next;
		return tem;
	}

	public Link deleteLast(){
		Link tem=last;
		if(last.previous==null)
			first=null;
		else
			last.previous.next=null;
		last=last.previous;
		return tem;
	}

	public boolean insertAfter(int key, int data){

		Link current= first;
		while(current.data!=key){
			current=current.next;
			if(current==null)
				return false;
		}
		Link newLink= new Link(data);

		if(current==last){
			newLink.next=null;
			last=newLink;
		}else{
			newLink.next=current.next;
			current.previous=newLink;
		}
		newLink.previous=current;
		current.next=newLink;
		return true;
	}

	public Link deleteKey(long key){

		Link current = first;
		while(current.data != key){
			current = current.next;
			if(current == null)
				return null;
		}

		if(current==first)
			first = current.next;
		else
			current.previous.next = current.next;

		if(current==last) 
			last = current.previous;
		else
			current.next.previous = current.previous;
		return current;
	}

	public void displayForward(){
		Link current=first;
		while(current!=null){
			current.displayLink();
			current=current.next;
		}
	}

	public void displayBackward(){
		Link current=last;
		while(current!=null){
			current.displayLink();
			current=current.previous;
		}
	}
}