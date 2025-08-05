package src.structure.interfaces;

/**
 * @author Tenneh Kanneh
 * Date: Fri Aug  1 18:44:05 MDT 2025
 * A generic interface for a double linked list data structure.
 *
 * @param <T> the type of elements held in this list
 */


public interface GenericDoubleLinkedListInterface<T> {
    
    /**
     * Adds an element to the front of the list.
     *
     * @param element the element to add
     */
    void addToFront(T element);

    /**
     * Adds an element to the end of the list.
     *
     * @param element the element to add
     */
    void addToRear(T element);

    /**
     * Adds an element to the end of the list.
     *
     * @param element the element to be added
     */
    void add(T element);

    /**
     * Adds an element at the specified index.
     *
     * @param index the index at which to insert the element
     * @param element the element to be inserted
     * @throws IndexOutOfBoundsException if the index is out of bounds
     */
    void add(int index, T element);


    /**
     * Adds the specified element after the current (or a specific) element.
     *
     * @param element the element to add after
     */
    void addAfter(T element);


    /**
     * Removes and returns the first element in the list.
     *
     * @return the removed element
     */
    T removeFirst();

    /**
     * Removes and returns the last element in the list.
     *
     * @return the removed element
     */
    T removeLast();

    /**
     * Removes the first occurrence of the specified element from the list.
     *
     * @param element the element to be removed
     * @return true if removal was successful, false otherwise
     */
    boolean remove(T element);


    /**
     * Removes the element at the specified index.
     *
     * @param index the index of the element to remove
     * @return the removed element
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    T remove(int index);


    void set(int index, T element);


    /**
     * Gets the element at the specified index.
     *
     * @param index the index of the element
     * @return the element at the index
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    T get(int index);

    /**
     * Replaces the element at the specified index with the specified element.
     *
     * @param index the index of the element to replace
     * @param element the new element
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    int indexOf(T element);

    /**
     * Returns the first element in the list.
     *
     * @return the first element
     */
    T first();

    /**
     * Returns the las element in the list.
     *
     * @return the last element
     */
    T last();

    /**
     * Returns true if the list contains the specified element.
     *
     * @param element the element to check
     * @return true if found, false otherwise
     */
    boolean contains(T element);

    /**
     * Checks whether the list is empty.
     *
     * @return true if empty, false otherwise
     */
    boolean isEmpty();


    /**
     * Returns the number of elements in the list.
     *
     * @return the size of the list
     */
    int size();

    /**
     * Removes all elements from the list.
     */
    void clear();

    /**
     * Returns a string representation of the list.
     *
     * @return a string representing the list
     */
    String toString();
}
