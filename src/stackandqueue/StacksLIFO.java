package stackandqueue;

public class StacksLIFO {

	public static void main(String[] args) {
		StackFunctions stackX= new StackFunctions(10);
		if(stackX.isEmpty())
			System.out.println("Empty stack");

		stackX.push(10);	// Call isFull() for error handling to check if the stack is already full
		stackX.push(20);
		stackX.push(30);
		stackX.push(40);
		stackX.push(50);

		if(!stackX.isFull())
			System.out.println("Stack not full");

		System.out.println(stackX.peek());

		while(!stackX.isEmpty()){
			System.out.println("Pop value"+stackX.pop());
		}
	}
}

class StackFunctions{

	private int sizeOfArray;
	private int[] stackArray;
	private int top;
	public StackFunctions(int sizeOfArray) {
		super();
		this.sizeOfArray = sizeOfArray;
		stackArray = new int[sizeOfArray];
		top=-1;
	}
	public void push(int num){
		stackArray[++top]=num;	//Increment top then insert the value
	}
	public int pop(){
		return stackArray[top--];
	}
	public int peek(){
		return stackArray[top];
	}
	public boolean isEmpty(){
		if(top==-1)
			return true;
		else 
			return false;
	}
	public boolean isFull(){
		if(top==sizeOfArray-1)
			return true;
		else
			return false;
	}
}
