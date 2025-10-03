package src.structure.generic;

import java.util.NoSuchElementException;

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
		if (isEmpty()) {
			head = new LinearNode<T>(element);
			tail = head;
		} else {
			LinearNode<T> temp = new LinearNode<>(element);
			
			temp.setNext(head);
			head = temp;
		}

		size++;
	}

	@Override
	public void addToRear(T element) {
		if (isEmpty()) {
			tail = new LinearNode<T>(element);
			head = tail;
		} else {
			LinearNode<T> temp = new LinearNode<>(element);
			
			tail.setNext(temp);
			tail = temp;
		}

		size++;
	}

	@Override
	public void add(T element) {
		addToRear(element);
		
	}

	@Override
	public void add(int index, T element) {
		if (index < 0 || index > size()) { throw new IndexOutOfBoundsException(); }

		if (isEmpty() || index == 0) {
			addToFront(element);
			
		} else {
			LinearNode<T> current = head;
			LinearNode<T> next = current.getNext();



			while (next != null) {
				if (indexOf(next.getElement()) == index) {
					LinearNode<T> temp = current;
					temp.setNext(current);
					temp.setElement(element);
					size++;

					if (indexOf(element) == size - 1) {
						tail = temp;
					}

					return;
				}
			}
			
		}

		size++;
		
	}

	@Override
	public void addAfter(T element, T target) {
		if (!contains(target)) { throw new NoSuchElementException(); }

		LinearNode<T> current = head;

		while (current != null) {
			if (current.getElement() == target){

				LinearNode<T> temp = new LinearNode<T>(element);
				temp.setNext(current.getNext());
				current.setNext(temp);
				size++;

				if (indexOf(element) == size - 1) {
					tail = temp;
				}

				return;
			} else {
				current = current.getNext();
			}
			
		}
	}

	@Override
	public T removeFirst() {
		if (isEmpty()) { throw new NoSuchElementException(); }

		LinearNode<T> temp = head;
		head = head.getNext();
		size--;

		return temp.getElement();
	}

	@Override
	public T removeLast() {
		if (isEmpty()) { throw new NoSuchElementException(); }

		T element;

		if (head == tail) {
			element = head.getElement();
			head = tail = null;
			size--;

			return element;
		}
		
		LinearNode<T> current = head;
		LinearNode<T> next = current.getNext();

			
		while (current.getNext() != null && next.getNext() != null) {
			current = current.getNext();
			next = next.getNext();
		}

		element = next.getElement();
		next.setElement(null);
		tail = current;
		size--;

		return element;
	}

	@Override
	public T remove(T element) {
		if (!contains(element)) { throw new  NoSuchElementException(); }

		if (head == tail && head.getElement() == element) {
			element = head.getElement();
			head = tail = null;
			size--;

			return element;
		}
		
		LinearNode<T> current = head;
		LinearNode<T> next = current.getNext();

			
		while (current.getNext() != null && next.getNext() != null) {
			if (next.getElement() == element) {
				current.setNext(next.getNext());
				next = null;
				size--;
				return element;

			}
		}

		return element;
	}

	@Override
	public T remove(int index) {
		if (isEmpty() || index < 0 || index > size()) { throw new  IndexOutOfBoundsException(); }

		T element;
		if (head == tail && indexOf(head.getElement()) == index) {
			element = head.getElement();
			head = tail = null;
			size--;

			return element;
		}
		
		LinearNode<T> current = head;
		LinearNode<T> next = current.getNext();

			
		while (current.getNext() != null && next.getNext() != null) {
			if (indexOf(next.getElement()) == index) {
				break;
			}

			current = current.getNext();
			next = next.getNext();
		}

		element = next.getElement();
		current.setNext(next.getNext());
		next = null;

		return element;
	}

	@Override
	public void set(int index, T element) {
		if (isEmpty() || index < 0 || index > size) { throw new IndexOutOfBoundsException(); }
		
		LinearNode<T> current = head;

		while (current != null) {
			if (indexOf(current.getElement()) == index) {
				
				current.setElement(element);
			}
			current = current.getNext();
			
		}
	}

	@Override
	public T get(int index) {
		if (isEmpty() || index < 0 || index > size) { throw new IndexOutOfBoundsException();}
		
		LinearNode<T> current = head;
		T element = null;

		while (current != null) {
			if (indexOf(current.getElement()) == index) {
				
				element = current.getElement();
				return element;
			}
			current = current.getNext();
			
		}

		return element;
	}

	@Override
	public int indexOf(T element) {
		if (isEmpty()) { return NOT_FOUND; }

		int index = 0;
		LinearNode<T> current = head;

		do {
			
			if (current.getElement() == element) {
				return index;
			}

			current = current.getNext();
			index++;
		} while (!(index >= size));

		return NOT_FOUND;
	}

	@Override
	public T first() {
		if (isEmpty()) { throw new NoSuchElementException(); }

		return head.getElement();
	}

	@Override
	public T last() {
		if (isEmpty()) { throw new NoSuchElementException(); }

		return tail.getElement();
	}

	@Override
	public boolean contains(T element) {
		return indexOf(element) != NOT_FOUND;
	}

	@Override
	public boolean isEmpty() {
		return size() == 0;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public void clear() {
		head = tail = null;
		size = 0;
	}

	public String toString() {
		String list = "[";

		LinearNode<T> current = head;
		
		while (current != null) {
			list += current.getElement();

			if (current.getNext() != null) {
				list += ", ";
			}
			current = current.getNext();
		}

		list += "]";

		return list;
	}

}