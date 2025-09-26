package src.structure.generic;

import src.model.LinearNode;
import src.structure.interfaces.SingleLinkedListInterface;

public class SingleLinkedList<T> implements SingleLinkedListInterface<T> {
	private LinearNode<T> head, tail;
	private int size;
	private final int NOT_FOUND = -1;

	public SingleLinkedList() {
		head = tail = null;
		size = 0;
	}
	
	@Override
	public void addToFront(T element) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'addToFront'");
	}

	@Override
	public void addToRear(T element) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'addToRear'");
	}

	@Override
	public void add(T element) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'add'");
	}

	@Override
	public void add(int index, T element) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'add'");
	}

	@Override
	public void addAfter(T element, T target) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'addAfter'");
	}

	@Override
	public T removeFirst() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'removeFirst'");
	}

	@Override
	public T removeLast() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'removeLast'");
	}

	@Override
	public T remove(T element) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'remove'");
	}

	@Override
	public T remove(int index) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'remove'");
	}

	@Override
	public void set(int index, T element) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'set'");
	}

	@Override
	public T get(int index) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'get'");
	}

	@Override
	public int indexOf(T element) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'indexOf'");
	}

	@Override
	public T first() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'first'");
	}

	@Override
	public T last() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'last'");
	}

	@Override
	public boolean contains(T element) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'contains'");
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'isEmpty'");
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'size'");
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'clear'");
	}

	public String toString() {
		String list = "";

		return list;
	}

}