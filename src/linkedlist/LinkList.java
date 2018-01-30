package linkedlist;

public class LinkList {

	private Link first;

	public LinkList() {
		first=null;
	}

	public boolean isEmpty(){
		return (first==null);
	}

	public void insertFirst(int data){
		Link newLink= new Link(data);
		newLink.next=first;
		first=newLink;
	}

	public void deleteFirst(){
		Link delFirst= first;
		first=delFirst.next;
		delFirst.displayLink();
	}

	public void displayList(){
		Link current= first;
		while(current!=null){
			current.displayLink();
			current=current.next;
		}
	}

	public Link findKey(int key){
		Link current=first;
		while(current.data!=key){
			if(current.next==null)
				return null;
			else
				current=current.next;
		}
		return current;
	}

	public Link deleteLink(int key){
		Link current=first;
		Link previous=first;
		while(current.data!=key){
			if(current.next==null)
				return null;
			else
				previous=current;
			current=current.next;
		}
		if(current==first)
			first=first.next;
		else
			previous.next=current.next;

		return current;
	}
}
