package dsalgo.learning.io.ds;

public class DynamicArray<T> {
	
	private T[] data;
	private int size;
	private int initialCapacity;
	
	@SuppressWarnings("unused")
	private DynamicArray() {
		//
	}
	
	@SuppressWarnings("unchecked")
	public DynamicArray (int initialCapacity) {
		this.size = 0;
		this.initialCapacity = initialCapacity;
		this.data = (T[]) new Object[initialCapacity];
	}
	
	public void add(T value) {
		data[size] = value;
		size++;
	}
	
	public T get(int index) {
		if (index < size) {
			return data[index];
		} else {
			return null;
		}
	}
	
	public void insert(int index, T value) {
		// resize if necessary
		if (size == initialCapacity) {
			resize();
		}
		
		// shift elements
		for (int i = size; i > index; i--) {
			data[i] = data[i - 1];
		}
		
		// insert
		data[index] = value;
		size++;
	}
	
	public void delete(int index) {
		if (index < size) {
			for (int i = index; i < size - 1; i++) {
				data[i] = data[i + 1];
			}
			data[size - 1] = null;
			size--;
		}
	}
	
	public boolean isEmpty() {
		if(size <= 0) {
			return true;
		} else {
			return false;
		}
	}
	
	public int size() {
		return size;
	}

	@SuppressWarnings("unchecked")
	private void resize() {
		T[] newData = (T[]) new Object[initialCapacity * 2];
		for (int i = 0; i < size; i++) {
			newData[i] = data[i];
		}
		data = newData;
		initialCapacity = initialCapacity * 2;
	}

}
