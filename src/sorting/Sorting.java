package sorting;

public class Sorting {

	public static void main(String[] args) {
		int[] array = {8,4,0,1,5,6,2,3,9,7};

		bubbleSort(array);
		selectionSort(array);
		insertionSort(array);

		for (int i =0;i<array.length;i++){
			System.out.print(array[i]);
		}
	}

	private static void selectionSort(int[] array) {

		for(int i=0;i<array.length-1;i++){
			int min=i;
			for(int j=i+1;j<array.length;j++){
				if(array[j]<array[min]){
					min=j;
				}
			}
			int temp=array[min];
			array[min]=array[i];
			array[i]=temp;

		}

	}

	private static void insertionSort(int[] array) {
		for (int i=1;i<array.length;i++)
		{
			int key=array[i];
			int j=i-1;
			while(j>-1 && array[j]>key){
				array[j+1]=array[j];
				j--;
			}
			array[j+1]=key;
		}
	}

	private static void bubbleSort(int[] array) {
		for(int i=0;i<array.length-1;i++){
			for(int j=0;j<array.length-i-1;j++){
				if(array[j]>array[j+1]){
					int temp=array[j];
					array[j]=array[j+1];
					array[j+1]=temp;
				}
			}
		}
	}

}
