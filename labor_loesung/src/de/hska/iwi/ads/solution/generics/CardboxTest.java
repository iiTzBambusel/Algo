package de.hska.iwi.ads.solution.generics;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CardboxTest {

	@Test
	void testCompareToGt() {
		Cardbox<String> box1 = new Cardbox<String>(20, "Hallo");
		Cardbox<String> box2 = new Cardbox<String>(10, "Hallo");
		
		assertEquals(1, box1.compareTo(box2));
	}
	@Test
	void testCompareToEq() {
		Cardbox<String> box1 = new Cardbox<String>(20, "Hallo");
		Cardbox<String> box2 = new Cardbox<String>(20, "Hallo");
		
		assertEquals(0, box1.compareTo(box2));
	}
	@Test
	void testCompareToLt() {
		Cardbox<String> box1 = new Cardbox<String>(10, "Hallo");
		Cardbox<String> box2 = new Cardbox<String>(20, "Hallo");
		
		assertEquals(-1, box1.compareTo(box2));
	}
	
}
