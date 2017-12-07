package stackandqueue;

public class QueuesFIFO {

	public static void main(String[] args) {

		QueueFunctions queueX= new QueueFunctions(10);
		if(queueX.isEmpty())
			System.out.println("Empty queue");

		queueX.insert(10);	
		queueX.insert(20);
		queueX.insert(30);
		queueX.insert(40);
		queueX.insert(50);

		if(!queueX.isFull())
			System.out.println("Queue not full");

		System.out.println(queueX.peekFront());

		while(!queueX.isEmpty()){
			System.out.println("Remove value"+queueX.remove());
		}
	}
}

class QueueFunctions{
	private int arraySize;
	private int front,rear;
	private int[] queueArray;
	private int count;

	public QueueFunctions(int size) {
		super();
		arraySize=size;
		queueArray= new int[arraySize];
		front=0;
		rear=-1;
		count=0;
	}

	public void insert(int num){
		if(rear==arraySize-1)
			rear=-1;
		queueArray[++rear]=num;
		count++;
	}

	public int remove(){
		int temp=queueArray[front++];
		if(front==arraySize)
			front=0;
		count--;
		return temp;
	}

	public int peekFront(){
		return queueArray[front];
	}

	public boolean isEmpty(){
		return (count==0);
	}

	public boolean isFull(){
		return (count==arraySize);
	}

	public int sizeOfQueue(){
		return count;
	}
}