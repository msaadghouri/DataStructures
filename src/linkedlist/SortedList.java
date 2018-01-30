package linkedlist;

public class SortedList {

	public static void main(String[] args) {
		SortedListFunctions theSortedList = new SortedListFunctions();
		theSortedList.insertKey(20); // Sorts and inserts element in List
		theSortedList.insertKey(40);
		theSortedList.insertKey(10); 
		theSortedList.insertKey(30);
		theSortedList.insertKey(50);
		theSortedList.remove(); // Removes the first element

	}

}
class SortedListFunctions{
	Link first;

	public SortedListFunctions() {
		first=null;
	}

	public boolean isEmpty(){
		return (first==null);
	}

	public void insertKey(int key){
		Link newLink= new Link(key);
		Link previous=null;
		Link current= first;

		while(current!=null && key>current.data){
			previous=current;
			current=current.next;
		}
		if(previous==null){			
			first=newLink;
		}else{
			previous.next=newLink;
		}
		newLink.next=current;
	}

	public Link remove(){
		Link remLink=first;
		first=first.next;
		return remLink;
	}

	public void displayList(){
		Link current= first;
		while(current!=null){
			current.displayLink();
			current=current.next;
		}
	}
}