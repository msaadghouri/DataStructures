package heaps;

import java.io.IOException;
import java.util.Scanner;

import binarytrees.Node;

public class HeapConcept {
	//Heap Sort
	public static void main(String[] args) throws IOException {

		Scanner scanner= new  Scanner(System.in);
		int size= scanner.nextInt();
		Heap heapArray = new Heap(size);

		//		heapArray.insertKey(5);
		//		heapArray.insertKey(2);
		//		heapArray.insertKey(8);
		//		heapArray.insertKey(4);

		for(int i=0; i<size; i++){
			int random = (int) (Math.random()*99);
			Node node= new Node(random);
			heapArray.insertAt(i, node);
			heapArray.incrementSize();
		}

		System.out.print("Unsorted Array: " );
		heapArray.displayArray();

		for(int j=size/2-1; j>=0; j--){
			//	size/2-1 gives the parent node holding the last child
			heapArray.trickleDown(j);
		}

		System.out.print("Heap Array: ");
		heapArray.displayArray();

		for(int j=size-1; j>=0; j--){
			//	remove() gets the top node and rearrange nodes
			//	satisfying heap condition
			Node topNode = heapArray.remove();
			heapArray.insertAt(j, topNode);
		}
		System.out.print("Sorted Array: ");
		heapArray.displayArray(); 

		scanner.close();
	} 
}

class Heap{
	private Node[] heapArray;
	private int maxSize;
	private int currentSize;

	public Heap(int maxSize) {
		this.maxSize=maxSize;
		currentSize=0;
		heapArray= new Node[maxSize];
	}

	public boolean isEmpty(){
		return currentSize==0;
	}

	public boolean insertKey(int key){

		if(currentSize==maxSize)
			return false;
		Node node= new Node(key);
		heapArray[currentSize]=node;
		trickleUp(currentSize++);

		return true;
	}

	//	Converting tree to array, for a node at x position:
	//	Parent: (x-1)/2; left child: 2x+1; right child: 2x+2

	public void trickleUp(int newKey) {
		// Node is added at the bottom, and then moved up the
		// tree to find a spot satisfying heap condition

		int parent= (newKey-1)/2;
		Node bottomNode= heapArray[newKey];
		while(newKey>0 && heapArray[parent].getData() < bottomNode.getData()){
			heapArray[newKey]=heapArray[parent];
			newKey=parent;
			parent=(parent-1)/2;
		}
		heapArray[newKey]=bottomNode;
	}

	public Node remove(){
		Node rootNode= heapArray[0];
		heapArray[0]=heapArray[--currentSize];
		trickleDown(0);
		return rootNode;
	}

	public void trickleDown(int takeDown) {
		// Root node is deleted and replaced by the last node.
		// This node is trickled down node by node such that heap condition is satisfied.

		Node topNode= heapArray[takeDown];
		int largerChild;
		while(takeDown<currentSize/2){
			int leftChild= 2*takeDown+1;
			int rightChild= 2*takeDown+2;

			if(rightChild < currentSize && heapArray[leftChild].getData() < heapArray[rightChild].getData()){
				largerChild= rightChild;
			}else{
				largerChild=leftChild;
			}
			if(topNode.getData()>heapArray[largerChild].getData())
				break;
			heapArray[takeDown]=heapArray[largerChild];
			takeDown=largerChild;
		}
		heapArray[takeDown]=topNode;
	}

	public boolean changeNode(int index, int newData){
		if(index<0 || index>=currentSize)
			return false;
		int oldData=heapArray[index].getData();
		heapArray[index].setData(newData);

		if(oldData<newData)
			trickleDown(index);
		else
			trickleUp(index);
		return true;
	}

	public void displayArray(){
		for(int j=0; j<maxSize; j++)
			System.out.print(heapArray[j].getData() + " ");
		System.out.println("");
	}

	public void insertAt(int index, Node newNode){
		heapArray[index] = newNode; 
	}

	public void incrementSize(){
		currentSize++; 
	}
}