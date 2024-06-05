package de.hska.iwi.ads.solution.sorting;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;

class MergesortTest {

    @Test
    void sortNoDoubles(){
        Mergesort<Integer> ms = new Mergesort<>();
        Integer[] a = {2,3,4,5,1};
        ms.sort(a);
        Integer[] b = {1,2,3,4,5};
        assertArrayEquals(b,a);
    }
    
    @Test
    void sortDoubles(){
        Mergesort<Integer> ms = new Mergesort<>();
        Integer[] a = {2,3,4,3,1};
        ms.sort(a);
        Integer[] b = {1,2,3,3,4};
        assertArrayEquals(b,a);
    }
    @Test
    void emptyArray() {
        Mergesort<Integer> ms = new Mergesort<>();
        Integer[] a = {};
        ms.sort(a);
        assertArrayEquals(a, a); // Prüfen, ob die leere Eingabe unverändert bleibt
    }
    @Test
    void singleElementArray() {
        Mergesort<Integer> ms = new Mergesort<>();
        Integer[] a = {5};
        ms.sort(a);
        assertArrayEquals(a, new Integer[]{5}); // Prüfen, ob die Sortierung eines Elements korrekt funktioniert
    }
    @Test
    void alreadySortedArray() {
        Mergesort<Integer> ms = new Mergesort<>();
        Integer[] a = {1, 3, 5, 7, 9};
        ms.sort(a);
        assertArrayEquals(a, new Integer[]{1, 3, 5, 7, 9}); // Prüfen, ob die Sortierroutine bereits sortierte Eingabe unverändert lässt
    }
    @Test
    void negativeNumbers() {
        Mergesort<Integer> ms = new Mergesort<>();
        Integer[] a = {-5, -2, 0, 3, 1};
        ms.sort(a);
        Integer[] expected = {-5, -2, 0, 1, 3}; // Richtige Sortierung mit negativen Zahlen
        assertArrayEquals(expected, a);
    }
    @Test
    void stability() {
    	//The objects of this class are sorted only by value 
    	class indexedValue implements Comparable<indexedValue>{
    		int value;
    		int index;
    		
    		//Constructor
    		indexedValue(int value,int index) {
    			this.value = value;
    			this.index = index;
    		}
			@Override
			public int compareTo(indexedValue o) {
				//Only compares the Value field}
				
				if(this.value > o.value) {return 1;}
				
				else if(this.value < o.value) {return -1;}
				
				else {return 0;}
				
			}
    		
    	}
    	Mergesort<indexedValue> ms = new Mergesort<>();
    	indexedValue iv1_1 = new indexedValue(1,1);
    	indexedValue iv2_1 = new indexedValue(2,1);
    	indexedValue iv1_2 = new indexedValue(1,2);
    	indexedValue iv3_1 = new indexedValue(3,1);
    	indexedValue iv0_1 = new indexedValue(0,1);
    	
        indexedValue[] a = {iv1_1,iv2_1,iv0_1,iv1_2,iv3_1};
        ms.sort(a);
        //If the object with the value 1 and index 2 is infront of the object with value 1 and index 1 ReverseMergesort is unstable
        indexedValue[] expected = {iv0_1,iv1_1,iv1_2,iv2_1,iv3_1}; // Richtige Sortierung mit negativen Zahlen
        
        assertArrayEquals(expected, a);
    }
  
  
    }
