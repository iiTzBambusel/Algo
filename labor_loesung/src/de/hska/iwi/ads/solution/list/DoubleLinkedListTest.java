package de.hska.iwi.ads.solution.list;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;

import org.junit.jupiter.api.Test;

import de.hska.iwi.ads.dictionary.MapTest;

class DoubleLinkedListTest extends MapTest {
	
	@Override
	public <K extends Comparable<K>, V> Map<K, V> createMap() {
		return new DoubleLinkedList<K,V>();
	}

	@Test
	public void testGet_EmptyList() {
	  DoubleLinkedList<String, Integer> list = new DoubleLinkedList<>();
	  String key = "test";
	  Integer value = list.get(key);
	  assertNull(value);
	}

	@Test
	public void testGet_KeyNotFound() {
	  DoubleLinkedList<String, Integer> list = new DoubleLinkedList<>();
	  list.put("key1", 10);
	  list.put("key2", 20);
	  String key = "not_found";
	  Integer value = list.get(key);
	  assertNull(value);
	}

	@Test
	public void testGet_KeyFound() {
	  DoubleLinkedList<String, Integer> list = new DoubleLinkedList<>();
	  list.put("key1", 10);
	  list.put("key2", 20);
	  String key = "key1";
	  Integer expectedValue = 10;
	  Integer value = list.get(key);
	  assertNotNull(value);
	  assertEquals(expectedValue, value);
	}
	
	@Test
	public void testPutInEmptyList() {
	  DoubleLinkedList<String, Integer> list = new DoubleLinkedList<>();
	  String key = "testKey";
	  Integer value = 10;
	  
	  Integer oldValue = list.put(key, value);
	  
	  assertEquals(value, list.get(key));
	  
	  assertNull(oldValue);
	}
	
	@Test
	public void testPutWithExistingKey() {
	  DoubleLinkedList<String, Integer> list = new DoubleLinkedList<>();
	  String key = "testKey";
	  Integer value1 = 10;
	  Integer value2 = 20;
	  
	  list.put(key, value1);
	  Integer oldValue = list.put(key, value2);
	  
	  assertEquals(value2, list.get(key));
	  
	  assertEquals(value1, oldValue);
	}
	
	@Test
	public void testPutAtSecondPosition() {
	  DoubleLinkedList<String, Integer> list = new DoubleLinkedList<>();
	  String key1 = "testKey1";
	  Integer value1 = 10;
	  String key2 = "testKey2";
	  Integer value2 = 20;
	  
	  list.put(key1, value1);
	  list.put(key2, value2);
	  
	  assertEquals(value1, list.get(key1));
	  
	  assertEquals(value2, list.get(key2));
	}
}
