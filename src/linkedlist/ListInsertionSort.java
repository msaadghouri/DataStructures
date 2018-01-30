package linkedlist;

public class ListInsertionSort {

	public static void main(String[] args) {
		Link[] linkArray= new Link[10];
		for(int i=0;i<linkArray.length;i++){
			int n = (int)(java.lang.Math.random()*100);
			Link link= new Link(n);
			linkArray[i]=link;
		}
		System.out.print("Unsorted array: ");
		for(int j=0; j<linkArray.length; j++)
			System.out.print( linkArray[j].data + " " );
		System.out.println("");

		InsertionSortListFunc func= new InsertionSortListFunc(linkArray);
		for(int j=0; j<linkArray.length; j++)
			linkArray[j]=func.remove();

		System.out.print("Sorted array: ");
		for(int j=0; j<linkArray.length; j++)
			System.out.print( linkArray[j].data + " " );
		System.out.println("");
	}

}
class InsertionSortListFunc{
	Link first;

	public InsertionSortListFunc(Link[] linkArray) {
		first=null;
		for(int i=0;i<linkArray.length;i++){
			insertKey(linkArray[i]);
		}
	}

	public boolean isEmpty(){
		return (first==null);
	}

	public void insertKey(Link linkArray){

		Link previous=null;
		Link current= first;

		while(current!=null && linkArray.data>current.data){
			previous=current;
			current=current.next;
		}
		if(previous==null){			
			first=linkArray;
		}else{
			previous.next=linkArray;
		}
		linkArray.next=current;
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