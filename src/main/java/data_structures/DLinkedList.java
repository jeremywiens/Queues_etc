package data_structures;


/**
 * Author: Jeremy Wiens
 * Date: Nov. 1, 2018
 * Assignment #1 (Comp 272 - Athabasca University)
 * Question 2 b, and 5

 * DLinkedList is of generic type T. It is a doubly linked queue implemented as LIFO.
 *
 * @param <T> is generic
 */
public class DLinkedList<T> {

    // The head node never takes a value but is just a place holder
    protected NodeDLL head = new NodeDLL();
    // The tail node never takes a value but is just a place holder
    protected NodeDLL tail = new NodeDLL();
    // n stores the size of the queue.
    int n = 0;
    // reversed is a boolean that is toggled true if the order of the queue is opposite
    // that which it started in, and can be toggled to false if the order is the
    // original order.
    boolean reversed = false;

    /**
     * DLinkedList constructor to create an empty queue.
     */
    public DLinkedList() {
        head.previous = tail;
        head.next = tail;
        tail.next = head;
        tail.previous = head;
    }

    /**
     * add a new Node to the queue
     *
     * @param data is the value which will be stored in the node of type <T></T>
     * @return a NodeDLL which is the node added to the queue
     */
    public NodeDLL add(T data) {
        NodeDLL node = new NodeDLL<T>(data);
        addNode(node);
        return node;
    }

    /**
     * add a new Node to the queue
     *
     * @param data is the value which will be stored in the node of type <T></T>
     * @return a NodeDLL which is the node added to the queue
     */
    public NodeDLL add(NodeDLL node) {
        node = addNode(node);
        return node;
    }


    //Adds a node that will be of type NodeDLL, this is private to
    //ensure all nodes will be a NodeDLL
    private NodeDLL addNode(NodeDLL node) {

        //Set the value of the nodes, reversed is required to ensure correct order.
        NodeDLL previous = tail.previous(reversed);
        previous.setNext(reversed, node);
        node.setPrevious(reversed, previous);
        node.setNext(reversed, tail);
        tail.setPrevious(reversed, node);
        n++;
        return node;
    }

    /**
     * pop returns the most recently added node from the queue,
     * unless the order has been reversed
     *
     * @return a NodeDLL which has been removed from the queue
     */
    public NodeDLL pop() {
        NodeDLL node = head.next(reversed);
        head.setNext(reversed, node.next(reversed));
        node.next(reversed).setPrevious(reversed, head);
        n--;
        return node;
    }

    /**
     * getNode finds a specific node within the queue
     *
     * @param data is the data stored within this node
     * @return the NodeDLL of which has the given data in the parameter
     */
    public NodeDLL getNode(T data) {
        NodeDLL node = head.next(reversed);
        while (true) {
            if (node.getData() == data) {
                return node;
            }
            if (node.next(reversed) == tail) {
                return null;
            }
            node = node.next(reversed);
        }
    }

    /**
     * swaps the given node with the node that follows in the queue.
     *
     * @param data is the value stored in the node
     * @return returns the NodeDLL which the given node was swapped
     * with. Returns null if no such node exists.
     */
    public NodeDLL swap(T data) {
        NodeDLL node = getNode(data);
        return swap(node);
    }

    /**
     * swaps the given node with the node that follows in the queue.
     *
     * @param node is the node which will be swapped with the following node.
     * @return returns the NodeDLL which the given node was swapped
     * with. Returns null if no such node exists.
     */
    public NodeDLL swap(NodeDLL node) {

        NodeDLL previous = head;
        NodeDLL current = head.next(reversed);
        NodeDLL next = current.next(reversed);

        //Return null if the queue has one or less nodes
        if (n < 2) {
            return null;
        }
        //Find the given node
        while (current != node) {
            //Return null if the node is not in this queue
            if (next.next(reversed) == tail) {
                return null;
            }
            previous = current;
            current = next;
            next = next.next(reversed);
        }

        //Re-arrange the links within the necessary nodes
        //Reversed is used to ensure the order remains correct
        previous.setNext(reversed, next);
        next.setPrevious(reversed, previous);
        current.setNext(reversed, next.next(reversed));
        next.next(reversed).setPrevious(reversed, current);
        next.setNext(reversed, current);
        current.setPrevious(reversed, next);
        return next;

    }

    /**
     * reverse flips the order of the queue. This is done only when necessary in order
     * to keep reverse in constant time. The boolean is changed and will be used to flip
     * the link of each individual node.
     *
     *
     * @return returns the state of the queue, true if the order is reversed, false
     * if the order is the same as the original.
     */
    public boolean reverse() {
        NodeDLL temp = tail;
        tail = head;
        head = temp;
        reversed = !reversed;
        return reversed;
    }

    /**
     * size gives the size of the queue.
     *
     * @return an integer which is the size of the queue
     */
    public int size() {
        return n;
    }

    /**
     * toString converts the queue to a string to help visualize the process.
     *
     * @return returns a string of the queue, with an extra comma and space for fun.
     */
    public String toString() {
        String DLL = "[";
        NodeDLL node = head.next(reversed);
        while (node != tail) {
            DLL = DLL + node.toString() + ", ";
            node = node.next(reversed);
        }
        DLL = DLL + "]";
        return DLL;
    }
}
