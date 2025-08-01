package src.structure.interfaces;

/**
 * A generic interface for a queue data structure (FIFO - First In First Out).
 * 
 * @param <T> the type of elements held in this queue
 */
public interface GenericQueueInterface<T> {

    /**
     * Add an item to the rear of the queue.
     * 
     * @param item the item to be added
     */
    public void enqueue(T item);

    /**
     * Removes and returns the front item from the queue.
     *
     * @return the item removed from the front
     * @throws java.util.NoSuchElementException if the queue is empty
     */
    public T dequeue();

    /**
     * Returns the front item without removing it.
     *
     * @return the item at the front
     * @throws java.util.NoSuchElementException if the queue is empty
     */
    public T peek();

    /**
     * Checks whether the queue is empty.
     *
     * @return true if empty, false otherwise
     */
    public boolean isEmpty();

    /**
     * Returns the number of elements in the queue.
     *
     * @return the size of the queue
     */
    public int size();

    /**
     * Removes all elements from the queue.
     */
    public void clear();
}
