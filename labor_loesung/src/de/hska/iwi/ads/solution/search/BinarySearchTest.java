package de.hska.iwi.ads.solution.search;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import de.hska.iwi.ads.search.Search;
import de.hska.iwi.ads.search.SearchTest;

class BinarySearchTest extends SearchTest{

	@Override
	public <E extends Comparable<E>> Search<E> createSearch()  {
		return new BinarySearch<>();
	}

	 @Test
	  void elementNotFound() {
	    Search<Integer> search = createSearch();
	    Integer [] a = {1, 1, 1, 1, 2, 3, 5, 7, 9};
	    
	    assertEquals(7, search.search(a, 6));
	  }
	 @Test
	  void charFind() {
	    Search<Character> search = createSearch();
	    Character [] a = {'1','1', '1', '1', '1', '1', '1', 'a', 'b'};
	    
	    assertEquals(7, search.search(a, 'a'));
	  }
	 @Test
	  void keyEqualsRight() {
	    Search<Integer> search = createSearch();
	    Integer [] a = {1,2,3,4,5,6,7,8,9};
	    
	    assertEquals(8, search.search(a, 9));
	  }
	 @Test
	  void keyEqualsLeft() {
	    Search<Integer> search = createSearch();
	    Integer [] a = {1,2,3,4,5,6,7,8,9};
	    
	    assertEquals(0, search.search(a, 1));
	  }
	 @Test
	 void notFoundMultipleBigger() {
		    Search<Integer> search = createSearch();
		    Integer [] a = {1,2,3,5,5,5,7,8,9};
		    
		    assertEquals(3, search.search(a, 4));
		  }
	 @Test
	 void notFoundMultipleSmaller() {
		    Search<Integer> search = createSearch();
		    Integer [] a = {1,2,3,5,5,5,5,8,9};
		    
		    assertEquals(7, search.search(a, 7));
		  }
	

}
