package src.structure.interfaces;

/**
 * @author Tenneh Kanneh
 * Date: Fri Aug  1 18:11:59 MDT 2025
 * 
 * A generic interface for a queue data structure (FIFO - First In First Out).
 * 
 * @param <T> the type of elements held in this queue
 */
public interface QueueInterface<T> {

    /**
     * Add an element to the rear of the queue.
     * 
     * @param element the element to be added
     */
    void enqueue(T element);

    /**
     * Removes and returns the front element from the queue.
     *
     * @return the element removed from the front
     * @throws java.util.NoSuchElementException if the queue is empty
     */
    T dequeue();


    /**
     * Returns the front element without removing it.
     *
     * @return the element at the front
     * @throws java.util.NoSuchElementException if the queue is empty
     */
    T peek();

    /**
     * Removes all element from the queue.
     */
    void clear();


    /**
     * Checks whether the queue is empty.
     *
     * @return true if empty, false otherwise
     */
    boolean isEmpty();

    /**
     * Returns the number of element in the queue.
     *
     * @return the size of the queue
     */
    int size();


    /**
     * Returns a string representation of the queue.
     * 
     * @return string of elements
     */
    String toString();
    
} 