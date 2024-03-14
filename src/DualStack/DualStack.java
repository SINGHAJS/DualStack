package dualstack;

/**
 *
 * @author Ajit Singh
 * 
 */
public class DualStack<E> implements DualStackADT {
    private int numElements;

    private Node<E> front;
    private Node<E> rear;

    public DualStack() {
        this.front = null;
        this.rear = null;
        this.numElements = 0;
    }

    @Override
    public boolean isEmpty() {
        return this.numElements == 0;
    }

    @Override
    public int size() {
        return this.numElements;
    }

    @Override
    public Object peekTop() {
        return this.front;
    }

    @Override
    public Object peekBottom() {
        return this.rear;
    }

    @Override
    public Object popTop() {
        Node<E> currentNode = this.front;

        this.front = currentNode.next;
        this.numElements--;

        return currentNode;
    }

    @Override
    public Object popBottom() {
        Node<E> currentNode = this.rear;

        this.rear = currentNode.prev;
        this.rear.next = null;
        this.numElements--;

        return currentNode;

    }

    @Override
    public void pushTop(Object element) {
        if (element == null)
            throw new IllegalArgumentException();

        if (element == null)
            throw new IllegalArgumentException();

        Node<E> newNode = new Node<E>((E) element);
        if (this.front == null) {
            this.front = newNode;
            this.rear = newNode;
            return;
        }

        Node<E> currentNode = this.front;

        newNode.next = currentNode;
        currentNode.prev = newNode;
        this.front = newNode;
        this.numElements++;
    }

    @Override
    public void pushBottom(Object element) {

        if (element == null)
            throw new IllegalArgumentException();

        Node<E> newNode = new Node<E>((E) element);
        if (this.front == null) {
            this.front = newNode;
            this.rear = newNode;
            return;
        }

        Node<E> currentNode = this.rear;

        currentNode.next = newNode;
        newNode.prev = currentNode;
        this.rear = newNode;
        this.numElements++;
    }

    public void clear() {
        Node<E> currentNode = this.front;

    }

    @Override
    public String toString() {
        Node<E> currentNode = this.front;
        String str = "[";

        while (currentNode != null) {
            str += currentNode + ", ";
            currentNode = currentNode.next;
        }

        return str + "]";
    }

    private class Node<E> {
        private E value;
        private Node<E> next;
        private Node<E> prev;

        public Node(E value) {
            this.value = value;
            this.next = null;
            this.prev = null;
        }

        @Override
        public String toString() {
            return this.value + "";
        }
    }

    public static void main(String[] args) {
        DualStack<Integer> stacky = new DualStack<Integer>();
        stacky.pushTop(10);
        stacky.pushTop(20);
        stacky.pushTop(30);
        stacky.pushTop(40);
        stacky.pushBottom(50);

        stacky.pushBottom(60);
        stacky.pushBottom(80);
        stacky.pushBottom(70);
        stacky.pushBottom(90);

        System.out.println("original: " + stacky);

        /* size() test */
        System.out.println("size(): " + stacky.size());

        /* isEmpty() test */
        System.out.println("isEmpty(): " + stacky.isEmpty());

        /* peekBottom() test */
        System.out.println("peekBottom(): " + stacky.peekBottom());

        /* peekTop() test */
        System.out.println("peekTop(): " + stacky.peekTop());

        /* popTop() test */
        System.out.println("popTop(): " + stacky.popTop());
        System.out.println("popTop(): " + stacky.popTop());

        /* popBottom() test */
        System.out.println("popBottom(): " + stacky.popBottom());
        System.out.println("popBottom(): " + stacky.popBottom());

        System.out.println("After Operations: " + stacky);

    }
}
