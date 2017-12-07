package arrays;

import java.util.Scanner;
import java.util.Stack;

public class Test {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int Q = in.nextInt();
		for(int a0 = 0; a0 < Q; a0++){
			int N = in.nextInt();
			if(N<=3){
				System.out.println(N);
			}else{
				steps(N);

			}
		}
		in.close();
	}
	static int count=0;
	private static void steps(int n) {
		Stack<Integer> array= new Stack<>();
		if(n<=3){
			System.out.println(count+n);
		}
		if(n%2!=0){
			n--;
			count++;

		}

		for(int i=2;i<=Math.sqrt(n);i++){
			if(n%i==0){
				int max= Math.max(i, n/i);
				array.push(max);
			}
		}
		count++;
		int[] intArray= new int[array.size()];
		int sizeOfArray=array.size();
		for(int i=0;i<sizeOfArray;i++){
			intArray[i]=array.pop();
		}

		int minValue=Integer.MAX_VALUE;
		if(intArray.length==1){
			if(intArray[0]<=3){
				count=count+intArray[0];
				System.out.println(count);

			}else{
				steps(intArray[0]);
			}
		}else{
			for(int i=0;i<intArray.length-1;i++){
				int min=Math.min(intArray[i], intArray[i+1]);
				if(min<minValue)
					minValue=min;
			}

			steps(minValue);
		}

	}
}