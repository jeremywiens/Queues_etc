package data_structures;

/**
 * Author: Jeremy Wiens
 * Date: Nov. 1, 2018
 * Assignment #1 (Comp 272 - Athabasca University)
 *
 * PriorityNode - This is a subclass of type Node, all priority nodes must have
 * data of type integer.
 */

public class PriorityNode extends Node {

    //Next is the node which this node will point to.
    protected PriorityNode next;
    // x is the data for this node.
    protected int x;

    /**
     * PriorityNode constructor confirms the data will be of type integer.
     *
     * @param data is the integer which will become the Node
     */
    public PriorityNode(int data) {
        this.data = data;
        x = data;
    }
}
