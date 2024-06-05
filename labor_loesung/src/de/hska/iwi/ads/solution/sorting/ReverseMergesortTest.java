package de.hska.iwi.ads.solution.sorting;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ReverseMergesortTest {
	   @Test
	    void sortNoDoubles() {
	        ReverseMergesort<Integer> rms = new ReverseMergesort<>();
	        Integer[] arr = new Integer[]{4,3,2,1};
	        rms.sort(arr);
	        Integer[] exp = new Integer[]{1,2,3,4};
	        assertArrayEquals(exp,arr);
	    }
	    
	    @Test
	    void sortDoubles(){
	        ReverseMergesort<Integer> rms = new ReverseMergesort<>();
	        Integer[] a = {2,3,4,3,1};
	        rms.sort(a);
	        Integer[] b = {1,2,3,3,4};
	        assertArrayEquals(b,a);
	    }
	    @Test
	    void emptyArray() {
	    	ReverseMergesort<Integer> rms = new ReverseMergesort<>();
	        Integer[] a = {};
	        rms.sort(a);
	        assertArrayEquals(a, a); // Prüfen, ob die leere Eingabe unverändert bleibt
	    }
	    @Test
	    void singleElementArray() {
	    	ReverseMergesort<Integer> rms = new ReverseMergesort<>();
	        Integer[] a = {5};
	        rms.sort(a);
	        assertArrayEquals(a, new Integer[]{5}); // Prüfen, ob die Sortierung eines Elements korrekt funktioniert
	    }
	    @Test
	    void alreadySortedArray() {
	    	ReverseMergesort<Integer> rms = new ReverseMergesort<>();
	        Integer[] a = {1, 3, 5, 7, 9};
	        rms.sort(a);
	        assertArrayEquals(a, new Integer[]{1, 3, 5, 7, 9}); // Prüfen, ob die Sortierroutine bereits sortierte Eingabe unverändert lässt
	    }
	    @Test
	    void negativeNumbers() {
	    	ReverseMergesort<Integer> rms = new ReverseMergesort<>();
	        Integer[] a = {-5, -2, 0, 3, 1};
	        rms.sort(a);
	        Integer[] expected = {-5, -2, 0, 1, 3}; // Richtige Sortierung mit negativen Zahlen
	        assertArrayEquals(expected, a);
	    }
	    @Test
	    void stability() {
	    	//The objects of this class are sorted only by value 
	    	class indexedValue implements Comparable<indexedValue>{
	    		int value;
				int index;
	    		
				
	    		indexedValue(int value,int index) {
	    			this.value = value;
	    			this.index = index;
	    		}
				@Override
				public int compareTo(indexedValue o) {
					if(this.value > o.value)return 1;
					if(this.value == o.value)return 0;
					if(this.value < o.value)return -1;
					return 0;
				}
	    		
	    	}
	    	ReverseMergesort<indexedValue> rms = new ReverseMergesort<>();
	    	indexedValue iv1_1 = new indexedValue(1,1);
	    	indexedValue iv2_1 = new indexedValue(2,1);
	    	indexedValue iv1_2 = new indexedValue(1,2);
	    	indexedValue iv3_1 = new indexedValue(3,1);
	    	indexedValue iv0_1 = new indexedValue(0,1);
	    	indexedValue iv1_3 = new indexedValue(1,3);
	        indexedValue[] a = {iv1_1,iv2_1,iv0_1,iv1_2,iv3_1,iv1_3};
	        rms.sort(a);
	        //If the object with the value 1 and index 2 is infront of the object with value 1 and index 1 ReverseMergesort is unstable
	        indexedValue[] expected = {iv0_1,iv1_1,iv1_2,iv1_3,iv2_1,iv3_1}; 
	        
	        assertArrayEquals(expected, a);
	    }
}
