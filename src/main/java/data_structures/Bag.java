package data_structures;

/**
 * Author: Jeremy Wiens
 * Date: Nov. 1, 2018
 * Assignment #1 (Comp 272 - Athabasca University)
 * Question 3
 *
 * Bag is of generic type T. Bag extends the doubly linked list implementation of queue.
 * But offers more support for finding all nodes of a certain value.
 *
 * @param <T> is generic
 */
public class Bag<T> extends DLinkedList<T> {

    /**
     * Bag constructor that creates an empty bag.
     */
    public Bag() {
        head.previous = tail;
        head.next = tail;
        tail.next = head;
        tail.previous = head;
    }

    /**
     * Finds and removes the node from the bag based on the data given.
     *
     * @param data is the value stored in the node
     * @return returns the node which is removed from the bag. Or null if the node does not exist.
     */
    public NodeDLL remove(T data) {
        NodeDLL node = find(data);
        if (node == null) {
            return null;
        }
        return remove(node, true);

    }

    /**
     * Finds and removes the node from the bag based on the data given.
     *
     * @param node is a node who's data will be extracted to remove that data from the bag.
     * @return returns the node which is removed from the bag. Or null if the node does not exist.
     */
    public NodeDLL remove(NodeDLL node) {
        return remove((T) node.getData());
    }

    /**
     * Finds and removes the node from the bag based on the data given.
     *
     * @param node  is a node who's data will be extracted to remove that data from the bag.
     * @param inBag is the boolean which confirms the node is in the bag.
     * @return the node which is removed from the bag. Returns null if the node
     * is not in the bag.
     */
    public NodeDLL remove(NodeDLL node, boolean inBag) {
        if (!inBag) {
            return null;
        }
        node.previous.next = node.next;
        node.next.previous = node.previous;
        n--;
        return node;
    }

    /**
     * find the given node in the bag based on the data in the given node. The
     * node will be the first instance of it found in the bag.
     *
     * @param node will not be used, but the data inside of it will be
     * @return a NodeDLL if the data is in the bag, null if no such node exists.
     */
    public NodeDLL find(NodeDLL node) {
        return find(head, (T) node.getData());
    }

    /**
     * find the node in the bag based on the data given. The
     * node will be the first instance of it found in the bag.
     *
     * @param data if a node with this data exists in the bag, it will be returned.
     * @return a NodeDLL if the data is in the bag, null if no such node exists.
     */
    public NodeDLL find(T data) {
        return find(head, data);
    }


    /**
     * find the node in the bag based on the data given. The
     * node will be the first instance after the given node in the bag.
     *
     * @param node is the node which the search will start
     * @param data if a node with this data exists in the bag, it will be returned.
     * @return a NodeDLL if the data is in the bag, null if no such node exists.
     */
    public NodeDLL find(NodeDLL node, T data) {
        while (node != tail) {
            if (node.getData() == data) {
                return node;
            }
            if (node.next == tail) {
                return null;
            }
            node = node.next(reversed);
        }
        return null;
    }

    /**
     * findAll finds all the nodes in the bag with the data given.
     *
     * @param data is of type T and will be searched for in the bag.
     * @return and array of NodeDLL which is all the found nodes within the bag
     * with the same data as give.
     */
    public NodeDLL[] findAll(T data) {
        NodeDLL bag[] = new NodeDLL[this.size()];
        int x = 0;
        NodeDLL node = head;
        while (node != tail) {
            if (node.getData() == data) {
                bag[x] = node;
                x++;
            }
            node = node.next(reversed);

        }

        NodeDLL reducedBag[] = new NodeDLL[x];
        System.arraycopy(bag, 0, reducedBag, 0, x);
        return reducedBag;

    }

}
