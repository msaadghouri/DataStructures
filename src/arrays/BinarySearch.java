package arrays;

public class BinarySearch {

	public static void main(String[] args) {
		int[] array = {0,11,21,33,47,51,62,75,81,99};
		int searchkey =62;
		int foundAt=findKey(array,searchkey);
		System.out.println(foundAt);
	}

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

}
