package sorting;

public class QuickSort {

	public static void main(String[] args) {
		int[] array = {8,4,0,1,7,6,2,3,9,5};
		quickSort(array, 0, array.length-1);
		for (int k =0;k<array.length;k++){
			System.out.print(array[k]);
		}
	}

	private static void quickSort(int[] array, int i, int j) {
		if(i<j){
			int partition= partition(array, i, j);
			quickSort(array, i, partition-1);
			quickSort(array, partition+1, j);
		}

	}

	private static int partition(int[] array, int left, int right) {
		int pivot= array[right];
		int shiftVariable=left-1;
		for(int i=left; i<right; i++){
			if(array[i]<=pivot){
				shiftVariable++;
				swap(array, shiftVariable, i);
			}
		}
		swap(array, shiftVariable+1, right);
		return shiftVariable+1;
	}

	private static void swap(int[] array, int shiftVariable, int i) {
		int temp = array[shiftVariable];
		array[shiftVariable]=array[i];
		array[i]=temp;

	}

}
