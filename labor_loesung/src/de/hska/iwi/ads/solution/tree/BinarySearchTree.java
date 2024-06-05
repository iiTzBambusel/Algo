package de.hska.iwi.ads.solution.tree;

import de.hska.iwi.ads.dictionary.AbstractBinaryTree;

public class BinarySearchTree<K extends Comparable<K>,V> extends AbstractBinaryTree<K, V> {
	

	public V get(Object o) {
		@SuppressWarnings("unchecked")
		K key = (K) o;
		Node x = this.root;
		
		while (x != null) {
			
			if(x.entry.getKey().compareTo(key) < 0 ) {
				
				x = x.left;
			}
			
			else if(x.entry.getKey().compareTo(key) > 0) {
			
				x = x.right;
			}
			
			else {
				
				return x.entry.getValue();
			}
		}
		
		return null;
	}
	
	
	public V put(K key,V value) {
		Node x = this.root;
		Node y = null;
		Node z = new Node(key,value);
		
		while(x != null) {
			
			if(x.entry.getKey().compareTo(key) == 0) {
			
				V oldValue = x.entry.getValue();
				
				x.entry.setValue(value);
				
				return oldValue;
			}
			
			y = x;
			
			if(x.entry.getKey().compareTo(key) < 0) {
			
				x = x.left;
			}else {
				
				x = x.right;
			}
		}
		
		if(y == null) {
			
			this.root = z;
			
		}
		else if(y.entry.getKey().compareTo(key) < 0) {
			
			y.left = z;
		}
		else {
			
			y.right = z;
		}
		this.size ++;
		return null;
	}
}
