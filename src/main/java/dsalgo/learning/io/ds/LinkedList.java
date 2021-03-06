package dsalgo.learning.io.ds;

public class LinkedList<T> {
	
	protected class Node<T> {
		Node<T> next;
		T value;
		
		Node() {
			// empty
		}
		
		Node(T value) {
			this.value = value;
		}
		
		public Node<T> getNext() {
			return next;
		}
		
		public void setNext(Node<T> another) {
			next = another;
		}
		
		public T getValue() {
			return value;
		}
	}
	
	private Node<T> head;
	
	public LinkedList() {
		this.head = new Node<T>();
	}
	
	public Node<T> addFirst(T value) {
		Node<T> newNode = new Node<T>(value);
		Node<T> oldNext = head.next;
		// swap
		newNode.next = oldNext;
		head.next = newNode;
		return newNode;
	}
	
	public Node<T> addLast(T value) {
		Node<T> newLast = new Node<T>(value);
		Node<T> oldLast = getLastNode(head);
		oldLast.next = newLast;
		return newLast;
	}
	
	public T getFirst() {
		return head.next.value;
	}
	
	public T getLast() {
		return getLastNode(head).value;
	}
	
	public Node<T> getFirstNode() {
		return head.next;
	}
	
	public Node<T> getLastNode(Node<T> node) {
		if (null == node.next) {
			return node;
		} else {
			return getLastNode(node.next);
		}
	}
	
	public int size() {
		return sizeOfNode(head);
	}
	
	private int sizeOfNode(Node<T> node) {
		if (null == node.next) {
			return 0;
		} else {
			return 1 + sizeOfNode(node.next);
		}
	}
	
	public void deleteFirst() {
		if (null != head.next) {
			Node<T> oldFirst = head.next;
			Node<T> newFirst = oldFirst.next;
			// swap
			head.next = newFirst;
			oldFirst = null;
		}
	}
	
	public void deleteLast() {
		if (null != head.next) {
			Node<T> first = head;
			for (int i = 0; i < size() - 1; i++) {
				Node<T> next = first.next;
				first = next;
			}
			first.next = null;
		}
	}
	
	public void print() {
		StringBuilder sb = new StringBuilder();
		Node<T> current  = head;
		while (null != current.next) {
			current = current.next;
			sb.append(current.value).append(",");
		}
		int index = sb.lastIndexOf(",");
		sb.delete(index, index + 1);
		System.out.println(sb.toString());
	}

}
