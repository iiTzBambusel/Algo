package de.hska.iwi.ads.solution.search;

import de.hska.iwi.ads.search.Search;

public class BinarySearch<E extends Comparable<E>> implements Search<E> {
	@Override
	public int search(E[] a, E key, int left, int right) {
		
		//Calculating mid
		int mid = (left+right)/2;
		
		//Special case 1 key is smaller than value a[left]
		if(key.compareTo(a[left])< 0) return left-1;
		
		
		//Special case 2 key is bigger than value a[right]
		if(key.compareTo(a[right]) > 0) return right+1;
		
		//Key found
		if(key.compareTo(a[mid]) == 0) {
			//if key is not at the first positions and the value a[mid] equals the value a[mid -1]
			
			if(mid > 0 && a[mid].compareTo(a[mid -1]) ==0 ) {
				
				//search for the smallest index of Key
				return search(a,key,left,mid--);
				
			}
			//return found index
			return mid;
		}
		
		//Special case 3 only occurs if the  Key is not found
		
		if(right-left == 1) {
			return left+1;
		
		}
		
		//Default BinarySearch\\
		
		//if key is bigger than the value a[mid] ignore every value smaller than a[mid]
		if(key.compareTo(a[mid])> 0 ) {
			
			//mid+1 no need to check the mid twice 
			return search(a,key,mid++,right);
		
		}
		//if key is smaller than the value a[mid] ignore every value bigger than a[mid]
	else if(key.compareTo(a[mid]) < 0  && left != mid) {
		
		//mid+1 no need to check the mid twice
		return search(a,key,left, mid--);
	
	}
return mid;
}
	}
