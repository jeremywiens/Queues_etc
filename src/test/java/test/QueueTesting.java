package test;
import static org.junit.Assert.*;

import org.junit.Test;

import words.PriorityQueue;
import words.*;

/*
Author: Jeremy Wiens
Date: Nov. 1, 2019
Assignment #1 (Comp 272 - Athabasca University)

This is the full testing for the singly linked list implementation of the queue.
This includes testing for the swap function. It's format can be copied to
include more test cases.
 */

public class QueueTesting {

    @Test
    public void test() {
        Queue que = new Queue();

        que.add(5);
        que.add(3);
        assertTrue(que.size() == 2);
        assertEquals(5, que.remove().getX());
        assertTrue(que.size() == 1);
        que.add(6);
        que.add(5);
        que.add(4);
        que.add(8);
        assertEquals(3, que.remove().getX());
        assertEquals(6, que.remove().getX());
        assertEquals(5, que.remove().getX());
        assertTrue(que.size() == 2);
        assertEquals(4, que.remove().getX());
        assertEquals(8, que.remove().getX());
        assertTrue(que.size() == 0);
        que.add(26);
        assertTrue(que.size() == 1);
        assertEquals(26, que.remove().getX());





    }

    @Test
    public void SwapTest(){
        Queue que = new Queue();

        Node u1 = que.add(5);
        Node u2 = que.add(3);

        que.swap(u1);
        assertTrue(que.size() == 2);
        assertEquals(3, que.remove().getX());
        assertTrue(que.size() == 1);
        assertEquals(null, que.swap(u2));
        assertEquals(5, que.remove().getX());

        Node u3 = que.add(5);
        Node u4 = que.add(3);
        Node u5 = que.add(9);
        Node u9 = que.add(25);
        Node u10 = que.add(7);

        que.swap(u10);

        que.swap(u3);
        que.swap(u3);
        que.swap(u4);
        assertEquals(9, que.remove().getX());
        que.swap(u5);
        que.swap(u9);
        assertEquals(3, que.remove().getX());
        assertEquals(5, que.remove().getX());
        assertEquals(7, que.remove().getX());
        assertEquals(25, que.remove().getX());
        assertEquals(null, que.remove());





    }
}
