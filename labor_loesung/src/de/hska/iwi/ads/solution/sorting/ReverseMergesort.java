package de.hska.iwi.ads.solution.sorting;

import de.hska.iwi.ads.sorting.AbstractMergesort;

public class ReverseMergesort<E extends Comparable<E>> extends AbstractMergesort<E> {


	@Override
	protected void mergesort(E[] a, int left, int right) {
		
		int mid;
		
		if(left<right) {
			
			//calculate the middle index
			mid = (left+right)/2;
			
			//Recursively sort the left Array
			mergesort(a,left,mid);
			
			//Recusively the right Array
			mergesort(a,mid+1,right);
			
			//Merging both sorted subarrays
			merge(a,left,mid,right);
			}
	}
	

	protected void merge(E[] a,int left,int mid,int right) {
		//Initialize pointers for left and right subarrays
		
		//l = left because the left subarray is sorted in ascending order
		int l = left;
		
		//r = right because the right subarray is sorted in descending order
		int r = right;
		
		//reversing the right array to descending order
		ReverseArray<E> ra = new ReverseArray<>();
		
		ra.reverse(a, mid+1, right);
		
		//loop through the subarrays and comparing, copying elements
		for(int i = left; i <= right ; i++) {
			
			//check if right subarray is empty or
			//if the left element is less than or equal to the right element
			if(a[l].compareTo(a[r])<=0) {
			
				//This is stable because the element of the left array is copyed first
				
				b[i] = a[l]; //copy element from left array
				
				l++; //move pointer to the next element
			
			}else {
				
				b[i] = a[r]; // copy element from right array
				
				r--; // move pointer to the next element
			}
		}
		
		//Copy merged elements back to the original array
		for(int i = left; i<= right;i++) {
			a[i]=b[i];
		}
	}
	}
