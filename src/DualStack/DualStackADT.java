package dualstack;

/**
 *
 * @author Seth
 */
public interface DualStackADT<E> {   
    public boolean isEmpty();
    public int size();
    public E peekTop();
    public E peekBottom();
    public E popTop();
    public E popBottom();
    public void pushTop(E element);
    public void pushBottom(E element);
}
