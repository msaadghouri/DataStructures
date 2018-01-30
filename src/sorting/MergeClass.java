package sorting;

public class MergeClass {

	public static void main(String args[]){
		int[] array1={2,4,6,8,10};
		int[] array2= {1,3,5,7,9};
		int[] randomArray={78,34,10,39,76,20,3,0,100,99};

		int[] mergedArray= mergeArrays(array1, array1.length, array2, array2.length);
		for(int i=0;i<mergedArray.length;i++){
			System.out.print(mergedArray[i]+ " ");
		}
		System.out.println();
		sortedArrays(randomArray,0 , randomArray.length-1);
		for(int i=0;i<randomArray.length;i++){
			System.out.print(randomArray[i]+ " ");
		}
	}

	private static void sortedArrays(int[] randomArray, int i, int length) {
		if(i<length){
			int mid=(i+length)/2;
			sortedArrays(randomArray, i, mid);
			sortedArrays(randomArray, mid+1, length);
			merge(randomArray,i,mid,length);
		}

	}

	private static void merge(int[] randomArray, int low, int mid, int high) {
		int size1= mid-low+1;
		int size2=high-mid;

		int[] array1= new int[size1];
		int[] array2= new int[size2];

		for(int j=0; j<size1; j++){
			array1[j]=randomArray[low+j];
		}
		for(int k=0; k<size2; k++){
			array2[k]=randomArray[mid+1+k];
		}
		int i=0, j=0, k=low;
		while(i<size1 && j<size2){
			if(array1[i] <= array2[j]){
				randomArray[k]=array1[i];
				i++;
			}else{
				randomArray[k]=array2[j];
				j++;
			}
			k++;
		}
		while(i<size1){
			randomArray[k]=array1[i];
			i++; k++;
		}
		while(j<size2){
			randomArray[k]=array2[j];
			j++; k++;
		}
	}

	private static int[] mergeArrays(int[] array1, int length1, int[] array2, int length2) {
		int[] arrayC=new int[10];
		int i=0, j=0, k=0;
		while(i<length1 && j<length2){
			if(array1[i] < array2[j]){
				arrayC[k]=array1[i];
				i++;
			}else{
				arrayC[k]=array2[j];
				j++;
			}
			k++;
		}
		while(i<length1){
			arrayC[k]=array1[i];
			i++; k++;
		}
		while(j<length2){
			arrayC[k]=array2[j];
			j++; k++;
		}
		return arrayC;
	}
}
