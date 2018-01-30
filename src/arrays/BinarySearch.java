package arrays;

public class BinarySearch {

	/*
	 * Binary Search requires a sorted array for search
	 * */

	public static void main(String[] args) {
		int[] array = {0,11,21,33,47,51,62,75,81,99};
		int searchkey =62;
		findKey(array,searchkey);
		findKeyR(array,searchkey);
	}

	// Iterative binary search
	private static int findKey(int[] array, int key) {
		int lowerBound=0, upperBound=array.length-1;
		while(lowerBound<=upperBound){
			int pivot=(lowerBound+upperBound)/2;
			if(array[pivot]==key)
				return pivot;
			else if(lowerBound>upperBound)
				return array.length;
			else
			{
				if( array[pivot] > key)
					upperBound= pivot-1;
				else
					lowerBound=pivot+1;
			}
		}
		return -1;
	}

	// Recursive binary search 
	private static int findKeyR(int[] array, int key) {
		int lowerBound=0, upperBound=array.length-1;
		return recursiveFind(array,lowerBound,upperBound,key);
	}
	private static int recursiveFind(int[] array, int lowerBound, int upperBound, int key) {
		int pivot=(lowerBound+upperBound)/2;
		if(array[pivot]==key)
			return pivot;
		else if(lowerBound>upperBound)
			return array.length;
		else
		{
			if( array[pivot] > key)
				return recursiveFind(array, lowerBound, pivot-1, key);
			else
				return recursiveFind(array, pivot-1, upperBound, key);
		}
	}

}
