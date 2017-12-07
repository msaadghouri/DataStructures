package arrays;

public class InsertInArray {


	public static void main(String[] args) {

		int[] array = new int[10];
		array[0]=1;
		array[1]=2;
		array[2]=3;
		array[3]=5;
		array[4]=6;
		int ele=5;
		insert(ele,array, 4);

	}

	private static void insert(int elements, int[] array, int value) {
		elements++;
		for(int i=0;i<elements;i++){
			if(array[i]>value){
				int temp=array[i];
				array[i]=value;
				value=temp;
			}
		}
		array[elements-1] = value;
		for (int i =0;i<elements;i++){
			System.out.print(array[i]);
		}
	}
}
