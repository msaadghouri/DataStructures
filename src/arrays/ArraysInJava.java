package arrays;

public class ArraysInJava {

	/*
	 * Basic linear search and deleting an element from array
	 * */

	public static void main(String[] args) {

		int[] array = {0,1,2,3,4,5,6,7,8,9};

		//Linear Search for a key
		int searchKey = 8, i;
		for(i=0;i<array.length;i++){
			if(array[i]==searchKey)
				break;
		}
		if(i==array.length)
			System.out.println("cant find search key");
		else
			System.out.println("found search key");

		//Delete a key
		int deleteKey=4,j;
		for(j=0;j< array.length;j++){
			if(array[j]==deleteKey)
				break;
		}
		for(int k=j;k<array.length-1;k++){
			array[k]=array[k+1];
		}

	}
}
