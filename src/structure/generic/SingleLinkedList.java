package src.structure.generic;

import java.util.NoSuchElementException;

import src.model.LinearNode;
import src.structure.interfaces.SingleLinkedListInterface;

public class SingleLinkedList<T> implements SingleLinkedListInterface<T> {
    LinearNode<T> head, tail;
    private int size;
	private static final int NOT_FOUND = -1;
	

	public SingleLinkedList() {
		head = tail = null;
		size = 0;
	}

     @Override
    public void addToFront(T element) {
        
        if (isEmpty()) {
            head = new LinearNode<T>(element);
        } else {
            LinearNode<T> retval = new LinearNode<T>(element);
            retval.setNext(head);
            head = retval;
        }

        
    }

    @Override
    public void addToRear(T element) {
		tail = new LinearNode<T>(element);
		tail.setNext(null);
		if (head == null){
			head = tail;
		} else {
			LinearNode<T> temp = head;
			while(temp.getNext() != null){
				 temp = temp.getNext();
			}
		}
		size++;
		
        
    }

    @Override
    public void add(T element) {
        addToRear(element);
        
    }

    @Override
    public void add(int index, T element) {
		if (index != 0) {
			if (index < 0 || index > size()) { throw new IndexOutOfBoundsException(); }
		}

		if (head == null) {
			head = new LinearNode<T>();
			tail = head;
		}
		
    	LinearNode<T> current = head;
		if (current.getElement() == null){
			current.setElement(element);
		} else {
			current.getElement().equals(index);
			current.setElement(element);
		}
		
		size++;
        
    }

     @Override
    public void addAfter(T element, T target) {
		if (isEmpty() || !contains(target)) {
            throw new NoSuchElementException();
        }

        LinearNode<T> current = head;

        while (current != null && ! current.getElement().equals(target)) {
            current = current.getNext();
        }

        if (current == null) {
            throw new NoSuchElementException();
        }

        LinearNode<T> newNode = new LinearNode<T>(element);
        if (current.getNext() == null) {
            current.setNext(newNode);
            tail = newNode;
        } else {
            newNode.setNext(current.getNext());
            current.setNext(newNode);
        }

        size++;
        
    }

    @Override
    public T removeFirst() {
        // TODO 
		// Grab element
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		LinearNode<T> current = head.getNext(), previous = head;
		// Grab element
		T result = previous.getElement();
		// If not the first element in the list
		if (current != null) {
			previous.setNext(current.getNext());
		} else { // If the first element in the list
			previous = previous.getNext();
		}

		size--;
	

		return result;
    }

    @Override
    public T removeLast() {
    
		if (isEmpty()) {
			throw new NoSuchElementException();
		}

		if (head == tail) {
			T element = head.getElement();
			head = tail = null;
			size--;
			
			return element;
		}

		LinearNode<T> current = head, next = current.getNext();
		if(next == null) {
			next = tail;
			T element = next.getElement();
			current.setElement(null);
			tail = current;
			size--;
			

			return element;
		}
		while (current.getNext() != null && next.getNext() != null) {
			current = current.getNext();
			next = next.getNext();
		}

		T element = next.getElement();
		current.setElement(null);
		tail = current;
		size--;
		
		return element;
    }

    @Override
    public T remove(T element) {
       if (isEmpty()) {
			throw new NoSuchElementException();
		}
		LinearNode<T> current = head, previous = null;
		while (current != null && !current.getElement().equals(element)) {
			previous = current;
			current = current.getNext();
		}
		// Matching element not found
		if (current == null) {
			throw new NoSuchElementException();
		}
		
		return removeElement(previous, current);
    }

    @Override
    public T remove(int index) {
        if (isEmpty() || index < 0 || index >= size) { throw new IndexOutOfBoundsException();}
		
		if (index == 0) {
			return removeFirst();
		}

		LinearNode<T> current = head;
		int i = 0;
		while (i < index - 1 && current != null) {
			current = current.getNext();
			i++;
		}

		if (current == null) {
			throw new IndexOutOfBoundsException();
		}
		size--;
		
		return removeElement(current, current.getNext());
    }

    private T removeElement(LinearNode<T> previous, LinearNode<T> current) {
		// Grab element
		T result = current.getElement();
		// If not the first element in the list
		if (previous != null) {
			previous.setNext(current.getNext());
		} else { // If the first element in the list
			head = current.getNext();
		}
		// If the last element in the list
		if (current.getNext() == null) {
			tail = previous;
		}
		size--;
		

		return result;
	}

    @Override
    public void set(int index, T element) {
        if (isEmpty() || index < 0 || index >= size()) {
			throw new IndexOutOfBoundsException();
		}

		if (head == null) {
			head = new LinearNode<T>();
		}
		
    	LinearNode<T> current = head;
		if (current.getElement() == null){
			current.setElement(element);
		} else {
			current.getElement().equals(index);
			current.setElement(element);
		}
        
    }

    @Override
    public T get(int index) {
        if (isEmpty() || index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
		
		LinearNode<T> current = head;
		if (current.getElement() == null){
			throw new IndexOutOfBoundsException();
		} else {
			current.getElement().equals(index);
			return current.getElement();
		}
    }

    @Override
    public int indexOf(T element) {
        int index = -1;

        if (isEmpty() || element.equals(-1)) {
			int temp = index;
            return temp;
        }

        LinearNode<T> current = head;
		index = 0;

        while (current != null) {
            if (current.getElement().equals(element)) {
                return index;
            }
            current = current.getNext();
            index++;
        }

		

        return index;
    }

    @Override
    public T first() {
        if (isEmpty()) { throw new NoSuchElementException(); }

        return this.head.getElement();
    }

    @Override
    public T last() {
        if (isEmpty()) { throw new NoSuchElementException(); }

        return this.tail.getElement();
    }

    @Override
    public boolean contains(T element) {
        return (indexOf(element) != NOT_FOUND);
    }

    @Override
    public boolean isEmpty() {
        return size() == 0 || head == null || tail == null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        // TODO Auto-generated method stub
        
    }
    
    @Override
    public String toString() {
        String list = "[";
		LinearNode<T> current = head;

        do {
            list += current;

            if (current.getNext() != null) {
                list += ", ";
            }

            current = current.getNext();

        } while (current != null);
		
		list += "]";

        return list;
    }
    
}