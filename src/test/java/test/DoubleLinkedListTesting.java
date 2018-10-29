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
        NodeDLL node3 = DLL.add(1000);
        DLL.add(99);

        assertEquals("[50, 43, 58, 1, 1000, 99, ]", DLL.toString());
        DLL.reverse();
        assertEquals("[99, 1000, 1, 58, 43, 50, ]", DLL.toString());
        DLL.reverse();
        assertEquals("[50, 43, 58, 1, 1000, 99, ]", DLL.toString());
        DLL.pop();

        DLL.reverse();
        DLL.pop();
        assertEquals("[1000, 1, 58, 43, ]", DLL.toString());
        DLL.add(70);
        DLL.swap(node3);
        DLL.swap(node2);
        DLL.swap(node2);
        DLL.swap(node2);
        DLL.swap(node2);
        DLL.swap(node2);
        DLL.swap(node3);
        DLL.swap(node1);
        assertEquals("[58, 1000, 43, 70, 1, ]", DLL.toString());
        DLL.reverse();
        DLL.swap(node2);
        DLL.swap(node2);
        DLL.swap(node2);
        DLL.swap(node2);
        DLL.swap(node2);
        assertEquals("[70, 43, 1000, 58, 1, ]", DLL.toString());
        DLL.swap(node3);
        DLL.reverse();
        DLL.swap(node3);
        DLL.reverse();
        DLL.swap(node3);
        assertEquals(70, DLL.pop().getData());
        DLL.reverse();
        assertEquals(1, DLL.pop().getData());
        DLL.swap(node3);
        assertEquals(58, DLL.pop().getData());
        assertEquals(1000, DLL.pop().getData());
        assertEquals(43, DLL.pop().getData());
        assertEquals(null, DLL.pop().getData());

    }

}
