package dsalgo.learning.io.linkedlists;

import java.util.HashSet;
import java.util.Set;

import dsalgo.learning.io.ds.LinkedList;


public class RemoveDuplicates<T> extends LinkedList<T> {
	
	public void removeDuplicate(LinkedList<T> linkedList) {
		Set<T> uniqSet = new HashSet<T>();
		
		Node<T> current = linkedList.getFirstNode();
		Node<T> previous = null;
		while (null != current) {
			if (uniqSet.contains(current.getValue())) {
				previous.setNext(current.getNext()); //skip this to next
			} else {
				uniqSet.add((T) current.getValue());
				previous = current;
			}
			current = current.getNext();
		}
	}

}
