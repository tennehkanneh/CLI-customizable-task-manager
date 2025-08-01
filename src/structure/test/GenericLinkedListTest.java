package src.structure.test;

import src.structure.GenericLinkedList;

public class GenericLinkedListTest {
    
    private GenericLinkedList<Integer> list = new GenericLinkedList<Integer>();

    private static final Integer ELEMENT_A = 1;
	private static final Integer ELEMENT_B = 2;
	private static final Integer ELEMENT_C = 3;
	private static final Integer ELEMENT_D = 4;
	private static final Integer ELEMENT_X = -1;
	private static final Integer ELEMENT_Z = -2;

    /***** 0-ELEMENT LINKED LIST TESTS ******/
    @Test
    public void add0ElementList() {
        list.add(ELEMENT_A);
    }

    @Test
    public void insert0ElementList() {
        list.insert(0, ELEMENT_A);
    }
    
    /**
     * Adds an item to the end of the list.
     *
     * @param item the item to be added
     */
    void add(T item);

    /**
     * Inserts an item at the specified index.
     *
     * @param index the position to insert at
     * @param item the item to be inserted
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    void insert(int index, T item);

    /**
     * Removes the first occurrence of the specified item from the list.
     *
     * @param item the item to be removed
     * @return true if removal was successful, false otherwise
     */
    boolean remove(T item);

    /**
     * Gets the item at the specified index.
     *
     * @param index the index of the item
     * @return the item at the index
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    T get(int index);

    /**
     * Returns true if the list contains the specified item.
     *
     * @param item the item to check
     * @return true if found, false otherwise
     */
    boolean contains(T item);

    /**
     * Returns the number of elements in the list.
     *
     * @return the size of the list
     */
    int size();

    /**
     * Checks whether the list is empty.
     *
     * @return true if empty, false otherwise
     */
    boolean isEmpty();

    /**
     * Removes all elements from the list.
     */
    void clear();
}


    /***** SINGLE LINKED LIST TESTS ******/

    /***** TWO ELEMENT LINKED LIST TESTS ******/

    /***** THRE ELEMENT SINGLE LINKED LIST TESTS ******/


   


}