package de.hska.iwi.ads.solution.list;

import de.hska.iwi.ads.dictionary.AbstractDoubleLinkedList;

public class DoubleLinkedList <K extends Comparable<K>, V> extends AbstractDoubleLinkedList<K, V>{

	private ListElement search(K key) {
		ListElement x = this.head;
		
		while(x != null) {
			if(x.entry.getKey().compareTo(key) == 0) {
				return x;
				}
			x = x.next;
		
		}
		return null;
	}
	
	
	
	
	public V get(Object o) {
		@SuppressWarnings("unchecked")
		K key = (K)o;
		ListElement element = search(key);
		
		if(element == null) {return null;}
		
		return element.entry.getValue();
	}
	
	
	
	public V put(K key, V value) {
		
		ListElement newElement = new ListElement(new SimpleEntry<>(key,value),null,this.head);
		
		
		if(this.head != null) {
			
			ListElement element = search(key);
		
			if(element != null) {
				
				V oldV = element.entry.getValue();
				
				element.entry.setValue(value);
				
				return oldV;
			}
			
			this.head.previous = newElement;
			
		}
		
		this.size ++;
		this.head = newElement;
		return null;
	}
}
