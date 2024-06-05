package de.hska.iwi.ads.solution.sorting;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ReverseArrayTest {

    @Test
    void reverseArray() {
        ReverseArray<Integer> r = new ReverseArray<>();
        Integer[] arr = new Integer[]{1,2,3,4,5};
        r.reverse(arr,0,4);
        Integer[] exp = new Integer[]{5,4,3,2,1};
        assertArrayEquals(arr,exp);
    }
    @Test
    void partialReverse() {
        ReverseArray<Integer> r = new ReverseArray<>();
        Integer[] arr = new Integer[]{1,2,3,4,5,6,7};
        r.reverse(arr,3,6);
        Integer[] exp = new Integer[]{1,2,3,7,6,5,4};
        assertArrayEquals(arr,exp);
    }
    @Test
    void singleElementArray() {
        ReverseArray<Character> r = new ReverseArray<>();
        Character[] arr = new Character[]{'A'};
        r.reverse(arr, 0, 0); // Reverse array with single element (no change)
        assertArrayEquals(arr, new Character[]{'A'});
    }
}
