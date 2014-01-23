package arrays;

import java.util.Arrays;
import java.util.Iterator;

/*
 * Head maintains the pointer for the start of the circular array..
 * 
 * CircluarArray is : CircularArray [items=[null, 1, 2, 3, 4, 5, 6], head=0]
 * CircluarArray after rotation of 2 is : CircularArray [items=[null, 1, 2, 3, 4, 5, 6], head=2]
 * CircluarArray get 3rd item : 5
 */
public class CircularArray<T> implements Iterable<T> {
	private T[] items;
	private int head = 0;
	
	public CircularArray(int size) {
		items = (T[]) new Object[size];
	}
	
	private int convert(int index) {
		if (index < 0) {
			index += items.length;
		}
		return (head + index) % items.length;
	}
	
	public void rotate(int shiftRight) {
		head = convert(shiftRight);
	}
	
	public T get(int i) {
		if (i < 0 || i >= items.length) {
			throw new java.lang.IndexOutOfBoundsException("Index " + i + " is out of bounds");
		}
		return items[convert(i)];
	}
	
	public void set(int i, T item) {
		items[convert(i)] = item;
	}
	
	public Iterator<T> iterator() {
		return new CircularArrayIterator<T>(this);
	}
	
	@Override
	public String toString() {
		return "CircularArray [items=" + Arrays.toString(items) + ", head="
				+ head + "]";
	}
	
	private class CircularArrayIterator<TI> implements Iterator<TI> {
		private int _current = -1;
		private TI[] _items;
		
		public CircularArrayIterator(CircularArray<TI> circularArray) {
			_items = circularArray.items;
		}
		
		@Override
		public boolean hasNext() {
			return _current < items.length - 1;
		}
		
		@Override
		public TI next() {
			_current++;
			TI item = (TI) _items[convert(_current)];
			return item;
		}
		
		@Override
		public void remove() {
			throw new UnsupportedOperationException("Remove is not supported by CircularArray");
		}
	}
	
	public static void main(String[] args){
		CircularArray<Integer> circularArray = new CircularArray<>(7);
		circularArray.set(1, 1);
		circularArray.set(2, 2);
		circularArray.set(3, 3);
		circularArray.set(4, 4);
		circularArray.set(5, 5);
		circularArray.set(6, 6);
	    System.out.println("CircluarArray is : " + circularArray);
	    circularArray.rotate(2);
	    System.out.println("CircluarArray after rotation of 2 is : " + circularArray);
	    System.out.println("CircluarArray get 3rd item : " + circularArray.get(3));
	}
}
