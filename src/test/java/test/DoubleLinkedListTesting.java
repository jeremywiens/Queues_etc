package test;

import static org.junit.Assert.*;

import org.junit.Test;

import words.PriorityQueue;
import words.*;


public class DoubleLinkedListTesting {
    @Test
    public void test() {
        DLinkedList<Integer> DLL = new DLinkedList<>();
        NodeDLL<Integer> node1 = new NodeDLL<>();
        NodeDLL<Integer> node2 = new NodeDLL<>();

        node1 = DLL.add(50);
        DLL.add(43);
        DLL.add(58);
       node2 = DLL.add(1);
        DLL.add(1000);
        DLL.add(99);

        assertEquals("[50, 43, 58, 1, 1000, 99, ]", DLL.toString());
        DLL.reverse();
        assertEquals("[99, 1000, 1, 58, 43, 50, ]", DLL.toString());
        DLL.reverse();
        assertEquals("[50, 43, 58, 1, 1000, 99, ]", DLL.toString());

    }

}
