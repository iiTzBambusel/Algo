package de.hska.iwi.ads.solution.hashtable;



import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;

import org.junit.jupiter.api.Test;

import de.hska.iwi.ads.dictionary.MapTest;

class HashtableTest extends MapTest {

	@Override
	public <K extends Comparable<K>, V> Map<K, V> createMap() {
		return new Hashtable<K,V>(11);
	}
	

    @Test
    public void testSetup() {
    	Hashtable<String, Integer> hashtable;
    	hashtable = new Hashtable<>(10);
        assertNotNull(hashtable);
    }
    @Test
    public void testGetExistingKey() {
    	Hashtable<String, Integer> hashtable;
    	hashtable = new Hashtable<>(10);
    	hashtable.put("zehn", 10);
        assertEquals(10, hashtable.get("zehn"));
    }

    @Test
    public void testGetNonExistingKey() {
    	Hashtable<String, Integer> hashtable;
    	hashtable = new Hashtable<>(10);
    	assertNull(hashtable.get("test"));
    }
    
    @Test
    public void testPutNewKey() {
    	Hashtable<String, Integer> hashtable;
    	hashtable = new Hashtable<>(10);
        int sizeBefore = hashtable.size();
        hashtable.put("orange", 20);
        assertEquals(sizeBefore + 1, hashtable.size());
        assertEquals(20, hashtable.get("orange"));
    }

    @Test
    public void testPutExistingKey() {
    	Hashtable<String, Integer> hashtable;
    	hashtable = new Hashtable<>(10);
        hashtable.put("grape", 30);
        int oldValue = hashtable.put("grape", 40);
        assertEquals(30, oldValue);
        assertEquals(40, hashtable.get("grape"));
    }
}
