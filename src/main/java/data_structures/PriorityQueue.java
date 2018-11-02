package data_structures;

/**
 * Author: Jeremy Wiens
 * Date: Nov. 1, 2018
 * Assignment #1 (Comp 272 - Athabasca University)
 * Question 1 a
 *
 * Priority Queue - This class extends queue. It requires all nodes be of
 * type Integer to order the elements within the queue.
 */
public class PriorityQueue extends Queue<Integer> {


    // The head node never takes a value but is just a place holder
    protected PriorityNode head = new PriorityNode(1);
    // The tail node never takes a value but is just a place holder
    protected PriorityNode tail = new PriorityNode(1);


    /**
     * Priority Queue constructor - creates an empty priority queue.
     */
    public PriorityQueue() {

    }

    /**
     * Add a node to the priority queue. Each node is added in order, from least
     * to greatest based on the integer value of the node.
     *
     * @param u is of type Node, the data is required to be an integer.
     * @return the PriorityNode that is added to the queue.
     */
    @Override
    public Node add(Node u) {
        int x = (int) u.getX();
        PriorityNode node = add(x);
        return node;
    }

    /**
     * Add a node to the priority queue. Each node is added in order, from least
     * to greatest based on the integer value of the node.
     *
     * @param x is an integer.
     * @return the PriorityNode that is added to the queue.
     */
    @Override
    public PriorityNode add(int x) {
        //Create the priorty node to add
        PriorityNode u = new PriorityNode(x);

        //If the queue is empty, add node after head and before tail.
        if (n == 0) {
            head.next = u;
            u.next = tail;
        } else {
            PriorityNode node = head;

            boolean done = false;

            //This while loop adds the node such that all preceding nodes are
            //of a lower or equal integer value.
            while (!done) {
                if (u.x <= node.next.x) {
                    u.next = node.next;
                    node.next = u;
                    done = true;
                } else {
                    node = node.next;
                    if (node.next == tail) {
                        node.next = u;
                        u.next = tail;
                        done = true;
                    }
                }
            }
        }
        n++;
        return u;
    }


    /**
     * deleteMin - this deletes the minimum value stored within the queue.
     *
     * @return the PriorityNode which is being deleted and has the minimum
     * value within the queue. Returns null if the queue is empty.
     */
    public PriorityNode deleteMin() {
        if (n == 0) {
            return null;
        }
        PriorityNode node = head.next;
        head.next = node.next;
        n--;
        return node;
    }
}
