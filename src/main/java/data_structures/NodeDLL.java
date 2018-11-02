package data_structures;

/**
 * Author: Jeremy Wiens
 * Date: Nov. 1, 2018
 * Assignment #1 (Comp 272 - Athabasca University)
 *
 * NodeDLL is of generic type T, these are nodes specifically for the doubly linked
 * list implementation of the queue.
 *
 * @param <T>
 */
public class NodeDLL<T> {

    //Next is the node which this node will point to.
    protected NodeDLL next;
    //Previous is the node which will point to this node, but this node also
    // points backwards to it.
    protected NodeDLL previous;
    // The data is the value of the node
    protected T data;

    /**
     * NodeDLL constructor with no value
     */
    public NodeDLL() {

    }

    /**
     * NodeDLL constructor with data value
     *
     * @param data is generic type and will be stored as the node's data.
     */
    public NodeDLL(T data) {
        this.data = data;
    }

    /**
     * getData returns the value stored in the node's data
     *
     * @return T is of generic type
     */
    public T getData() {
        return data;
    }

    /**
     * setNext is a method to select which node (parameter) this node (instance) points to.
     *
     * @param reversed is a boolean which is true if the order of the DLL has been reversed.
     * @param node     is the NodeDLL which will follow the node acted upon.
     * @return returns the given NodeDLL.
     */
    public NodeDLL setNext(boolean reversed, NodeDLL node) {
        if (reversed == true) {
            this.previous = node;
        } else {
            this.next = node;
        }
        return node;
    }

    /**
     * setPrevious is a method to select which node (parameter) this node (instance)
     * has as its previous node.
     *
     * @param reversed is a boolean which is true if the order of the DLL has been reversed.
     * @param node     is the NodeDLL which will precede the node acted upon.
     * @return the given NodeDLL.
     */
    public NodeDLL setPrevious(boolean reversed, NodeDLL node) {
        if (reversed == true) {
            this.next = node;
        } else {
            this.previous = node;
        }
        return node;
    }

    /**
     * next gets the next node for this Node (instance.
     *
     * @param reversed is a boolean which is true if the order of the DLL has been reversed.
     * @return returns the NodeDLL which is following the node acted on.
     */
    public NodeDLL next(boolean reversed) {
        if (reversed == true) {
            return previous;
        }
        return next;
    }

    /**
     * toString turns the node into a string representation of the data within the node.
     *
     * @return a String of the data within the node.
     */
    public String toString() {
        String node = data.toString();
        return node;
    }

    /**
     * previous gets the preceding NodeDLL which is preceding the node acted on.
     *
     * @param reversed is a boolean which is true if the order of the DLL has been reversed.
     * @return the NodeDLL which is previous to the instance acted on.
     */
    public NodeDLL previous(boolean reversed) {
        if (reversed == true) {
            return next;
        }
        return previous;
    }
}
