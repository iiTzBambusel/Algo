package de.hska.iwi.ads.solution.sorting;

import de.hska.iwi.ads.sorting.Reverse;

public class ReverseArray<E extends Comparable<E>> implements Reverse<E> {

	@Override
	public void reverse(E[] a, int from, int to) {
        //consatnt additional storage
		E tmp;
        
		//loop through half of the array and swapping elements
        
        for (int j = to, i=from;i<=j;i++,j--) {
        	tmp=a[i];
            a[i] = a[j];
            a[j] = tmp;
		
	}

}
}
