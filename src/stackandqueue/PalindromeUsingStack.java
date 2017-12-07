package stackandqueue;

import java.util.Scanner;

public class PalindromeUsingStack {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		String string=sc.nextLine();
		if(!string.equalsIgnoreCase("")){
			int size= string.length();
			StackFunctionsChar stackC = new StackFunctionsChar(size);
			for(int i=0;i<size;i++){
				char c=string.charAt(i);
				stackC.push(c);
			}
			String revString = "";
			while(!stackC.isEmpty()){
				char c = stackC.pop();
				revString=revString+c;
			}
			if(revString.equalsIgnoreCase(string))
				System.out.println("Palindrome");
			else
				System.out.println("Not Palindrome");

		}
		sc.close();
	}

}

class StackFunctionsChar{

	private int sizeOfArray;
	private char[] stackArray;
	private int top;
	public StackFunctionsChar(int sizeOfArray) {
		super();
		this.sizeOfArray = sizeOfArray;
		stackArray = new char[sizeOfArray];
		top=-1;
	}
	public void push(char alpha){
		stackArray[++top]=alpha;	//Increment top then insert the value
	}
	public char pop(){
		return stackArray[top--];
	}
	public char peek(){
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