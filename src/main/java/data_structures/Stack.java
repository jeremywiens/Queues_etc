package data_structures;


/**
 * Author: Jeremy Wiens
 * Date: Nov. 1, 2018
 * Assignment #1 (Comp 272 - Athabasca University)
 * Question 1 b.
 *
 * Stack - This is a implementation of stack using two queues. This stack is FIFO.
 * This is a superclass. The nodes are of generic type T.
 */

public class Stack {

    // Create two queues to store the data within this stack.
    protected Queue queue1 = new Queue();
    protected Queue queue2 = new Queue();


    /**
     * Stack constructor creates an empty stack.
     */
    public Stack() {

    }

    /**
     * push adds a node to the top of the stack.
     *
     * @param x is an integer and will be added to the stack as a node.
     * @return the Node which is added to the stack.
     */
    public Node push(int x) {
        Node node = queue1.add(x);
        return node;
    }

    /**
     * push adds a node to the top of the stack.
     *
     * @param u is the Node which will be added to the stack, the data can be generic.
     * @return the Node which is added to the stack.
     */
    public Node push(Node u) {
        Node node = queue1.add(u);
        return node;
    }

    /**
     * pop returns the node which is on the top of the stack and which was add
     * most recently.
     *
     * @return the Node which is removed from the stack. Returns null if the stack is
     * empty.
     */
    public Node pop() {
        if (queue1.size() == 0) {
            return null;
        }
        //Add all but one of the elements to the queue2 from queue1
        while (queue1.size() > 1) {
            queue2.add(queue1.remove());
        }

        // switch the queues so that queue one stores all of the nodes.
        Queue temp = queue1;
        queue1 = queue2;
        queue2 = temp;
        assert queue2.size() == 1;
        // return the left over node which was the most recently added to queue1.
        return queue2.remove();
    }

    /**
     * size returns the size of the stack.
     *
     * @return an integer which is the size of the stack.
     */
    public int size() {
        int x;
        //queue2 will be empty, all nodes are in queue1.
        x = queue1.size();
        return x;
    }
}

