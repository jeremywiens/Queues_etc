package data_structures;

/**
 * Author: Jeremy Wiens
 * Date: Nov. 1, 2018
 * Assignment #1 (Comp 272 - Athabasca University)
 * Question 1 a, and 2 a.
 *
 * Queue - This is a singly-linked list implementation of the queue. This queue is LIFO.
 * This is a superclass. The nodes are of generic type T.
 */

public class Queue<T> {

    // The head node never takes a value but is just a place holder
    protected Node head = new Node();
    // The tail node never takes a value but is just a place holder
    protected Node tail = new Node();
    // n stores the size of the queue.
    protected int n = 0;


    /**
     * Queue constructor - creates an empty queue.
     */
    public Queue() {

    }

    /**
     * Add a node to the queue.
     *
     * @param x is an integer.
     * @return the Node which is added to the queue.
     */
    public Node add(int x) {
        Node u = new Node(x);
        add(u);
        return u;
    }

    /**
     * Add a node to the queue, all nodes are added to the end of the queue.
     *
     * @param u is a Node with data that is of generic type.
     * @return the Node which is added to the queue.
     */
    public Node add(Node u) {


        if (n == 0) {
            head.next = u;
            u.next = tail;
        } else {
            Node previous = head.next;
            while (previous.next != tail) {
                previous = previous.next;
            }
            u.next = tail;
            previous.next = u;
        }
        n++;
        return u;
    }

    /**
     * remove returns and removes the oldest node in the queue.
     *
     * @return the Node which is being removed.
     */
    public Node remove() {
        if (n == 0) {
            return null;
        }
        Node u = head.next;
        head.next = u.next;
        n--;
        return u;
    }

    /**
     * swap finds the given node, and switches the link with the immediately following node
     * within the queue.
     * <p>
     * Ex: que = [5, 4, 7, 8]
     * que.swap(7)
     * returns 8, and the queue becomes, que = [5, 4, 8, 7]
     *
     * @param node is the node being swapped with the node which immediately follows in the queue.
     * @return the Node which was swapped with the parameter. Returns null if there is no
     * such node.
     */
    public Node swap(Node node) {
        Node previous = head;
        Node current = head.next;
        Node next = current.next;

        // return null if there is one or less node within the queue
        if (n < 2) {
            return null;
        }

        // find the node within the queue
        while (current != node && next != tail) {
            previous = current;
            current = next;
            next = next.next;
        }

        // return null if there is no following node within the queue
        if (next == tail) {
            return null;
        }

        // switch the links to re-order the queue
        current.next = next.next;
        previous.next = next;
        next.next = node;

        return next;
    }

    /**
     * size returns the size of the queue.
     *
     * @return an integer which is the size of the queue
     */
    public int size() {
        int x = n;
        return x;
    }
}


