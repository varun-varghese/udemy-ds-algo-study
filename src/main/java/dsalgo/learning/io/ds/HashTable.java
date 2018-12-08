package dsalgo.learning.io.ds;

import java.util.Objects;

public class HashTable<K, V> {
	
	private int intialSize = 16;
	private HashEntry<K, V>[] data;
	
	@SuppressWarnings("hiding")
	class HashEntry<K, V> {
		K key;
		V value;
		HashEntry<K, V> next;
		
		HashEntry(K key, V value) {
			this.key = key;
			this.value = value;
			next = null;
		}
	}
	
	@SuppressWarnings("unchecked")
	public HashTable() {
		data = (HashEntry<K, V>[]) new HashEntry[intialSize];
	}
	
	private int getIndex(K key) {
		// simulate collision
		if (key.getClass().getTypeName().contains("String")) {
			String strKey = (String) key;
			if (strKey.contains("Collide") || strKey.contains("collide")) {
				return 4;
			}
		}
		return Objects.hashCode(key) % intialSize;
	}
	
	public void put(K key, V value) {
		// calculate index
		int index = getIndex(key);
		
		// put the entry in the correct index
		// if collision, look for next
		HashEntry<K, V> newEntry = new HashEntry<K, V>(key, value);
		
		if (null == data[index]) {
			data[index] = newEntry;
		} else {
			HashEntry<K, V> existingEntries = data[index];
			while (!Objects.equals(existingEntries.key, key) && existingEntries.next != null) {
				existingEntries = existingEntries.next;
			}
			existingEntries.next = newEntry;
		}
	}
	
	public V get(K key) {
		int index = getIndex(key);
		HashEntry<K, V> entries = data[index];
		
		if (null != entries) {
			while (!Objects.equals(entries.key, key) && entries.next != null) {
				entries = entries.next;
			}
			return entries.value;
		} else {
			return null;
		}
	}
	
	public boolean contains(K key) {
		int index = getIndex(key);
		HashEntry<K, V> entries = data[index];
		
		if (null != entries) {
			while (!Objects.equals(entries.key, key) && entries.next != null) {
				entries = entries.next;
			}
			return Objects.equals(entries.key, key);
		}
		
		return false;
	}

}
