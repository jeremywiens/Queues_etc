package data_structures;

/**
 * Author: Jeremy Wiens
 * Date: Nov. 1, 2018
 * Assignment #1 (Comp 272 - Athabasca University)
 *
 * Node is of generic type T, Node is a super class used by queues in this package.
 *
 * @param <T> is of generic type anre represents the data of the node.
 */
public class Node<T> {

    //Next is the node which this node will point to.
    protected Node next;
    // The data is the value stored in this node.
    protected T data;

    /**
     * a Node constructor which does not have any data
     */
    public Node() {

    }

    /**
     * a Node constructor which does have data
     *
     * @param data is of generic type T and is the value stored in this node.
     */
    public Node(T data) {

        this.data = data;


    }

    /**
     * getX gets the value stored in this node
     *
     * @return the specified type T which is the value in this node.
     */
    public T getX() {
        return data;
    }
}
