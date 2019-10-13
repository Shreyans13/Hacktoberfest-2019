package Sorting;

import java.util.*;
public class Heap_Sort {
	
	public static void inplaceHeapSort(int[] arr) {

		for(int i=1; i<arr.length;i++) {
			
			int childIndex= i;
			int parentIndex= (childIndex-1)/2;
			
			while(childIndex>0) {
				
				if(arr[parentIndex]>arr[childIndex]) {
					int temp= arr[parentIndex];
					arr[parentIndex]=arr[childIndex];
					arr[childIndex]=temp;
					childIndex=parentIndex;
					parentIndex=(childIndex-1)/2;
				}
				else {
					break;
				}
			}
		}
				
		for(int i=arr.length-1; i>0;i--) {
		
		int removedElement= arr[0];
		arr[0]= arr[i];
		arr[i]=removedElement;

		downheapify(0, arr,i);
		}
	}
	
	public static void downheapify(int index, int[] arr, int lastIndex) {
		
		int leftChild= (2*index)+1;
		int rightChild= (index*2)+2;
		int minIndex=index;
		
		if(leftChild>=lastIndex) {
			return;
		}
		
		if(arr[leftChild]<arr[index]) {
			minIndex=leftChild;
		}
		if(rightChild<lastIndex && arr[rightChild]<arr[minIndex]) {
			minIndex=rightChild;
		}
		
		if(minIndex!=index) {
			
			int temp=arr[minIndex];
			arr[minIndex]=arr[index];
			arr[index]=temp;
			
			downheapify(minIndex, arr, lastIndex);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s= new Scanner(System.in);
		
		int n= s.nextInt();
		int[] arr= new int[n];

		for(int i=0; i<arr.length;i++) {
			arr[i]= s.nextInt();
		}	

		inplaceHeapSort(arr);
		
		for(int i=0; i<(n+1)/2; i++) {
			
			int temp = arr[i];
			arr[i]= arr[n-1-i];
			arr[n-1-i]= temp;
		}
		
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}	
	}

}
