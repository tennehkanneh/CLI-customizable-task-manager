package src.structure.interfaces;

/**
 * @author Tenneh Kanneh
 * Date: Fri Aug  1 18:22:37 MDT 2025
 * 
 * A generic interface for a stack data structure (LIFO - Last In First Out).
 *
 * @param <T> the type of elements held in this stack
 */
public interface GenericStackInterface<T> {
    
    /**
     * Adds the specified element to the top of the stack.
     * 
     * @param element to be pushed onto the stack
     */
    void push(T element);

    /**
     * Removes and returns the top element from the stack.
     * 
     * @return the element remvoed from the stack.
     */
    T pop();

    
    /**
     * Returns without removing the top element of the stack.
     * 
     * @return the element of top of the stack
     */
    T peek();

    /**
     * Returns true if the stack contains no elements.
     * 
     * @return true if the stack is empty
     */
    boolean isEmpty();


    /**
     * Returns the number of elements in the stack.
     * @Return the number of elements in the stack
     * @return
     */
    int size();

    /**
     * Returns a string representation of this stack.
     * 
     * @return a string representation of the stack
     */
    String toString();
}
