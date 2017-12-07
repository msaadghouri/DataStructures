package linkedlist;

import java.util.LinkedList;

public class LinkedLists {
	public static void main(String[] args){

		LinkedList<Integer> linkedList= new LinkedList<>();
		
		linkedList.add(1);
		linkedList.add(2);
		linkedList.add(3);
		linkedList.add(4);
		linkedList.add(3, 30);
		linkedList.addFirst(10);
		linkedList.addLast(20);

		linkedList.remove();

		System.out.println(linkedList.size()+ " " +linkedList.contains(1));
		Object object=linkedList.get(2);
		System.out.println(object);
		linkedList.set(2, 40);
		for(int i =0;i<linkedList.size();i++){
			System.out.println(linkedList.get(i));
		}
	}
}
