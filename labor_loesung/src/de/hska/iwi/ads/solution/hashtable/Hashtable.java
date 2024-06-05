package de.hska.iwi.ads.solution.hashtable;

import de.hska.iwi.ads.dictionary.AbstractHashMap;

public class Hashtable<K extends Comparable<K>,V> extends AbstractHashMap<K, V>{

	public Hashtable(int capacity) {
		super(capacity);
	}
	
	public V get(Object o) {
		@SuppressWarnings("unchecked")
		K key = (K)o;
		int i = 0;
		int hash;
		
		do {
			hash = quadSondieren(i,key);
		
			if(hashtable[hash] != null && hashtable[hash].getKey().compareTo(key) == 0) {
			
				return hashtable[hash].getValue();
			
			}
			i++;
		
		}while(hashtable[hash] != null && i < hashtable.length);
		
		return null;
	}

	
	public V put(K key,V value) {
		int i = 0;
		int hash;
		
		do {
		hash = quadSondieren(i,key);
		
		if(hashtable[hash] == null || hashtable[hash].getKey() == null) {
			SimpleEntry<K,V> entry = new SimpleEntry<>(key,value);
			
			hashtable[hash] = entry;
			this.size++;
			
			return null;
			
		}else if(hashtable[hash].getKey().compareTo(key)==0){
			V oldValue = hashtable[hash].getValue();
			
			hashtable[hash].setValue(value);
			
			return oldValue;
		}
		
		i++;
		
		}while(i < hashtable.length);
		
		throw new DictionaryFullException();
	}
	
	private int quadSondieren(int i,K key) {
		//hashCode() is not guaranteed to return a positive Integer
		return Math.abs((key.hashCode() + i * i) % hashtable.length);
	}
}
