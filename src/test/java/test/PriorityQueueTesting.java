package test;
import static org.junit.Assert.*;

import org.junit.Test;

import words.PriorityQueue;
import words.*;


public class PriorityQueueTesting {
    @Test
    public void test() {
        PriorityQueue que = new PriorityQueue();
        que.add(5);
        que.add(3);
        assertTrue(que.size() == 2);
        assertEquals(3, que.deleteMin().getX());
        assertTrue(que.size() == 1);
        que.add(6);
        que.add(5);
        que.add(4);
        que.add(8);
        assertEquals(4, que.deleteMin().getX());
        assertEquals(5, que.deleteMin().getX());
        assertEquals(5, que.deleteMin().getX());
        assertTrue(que.size() == 2);

    }
    @Test
    public void test1(){
        PriorityQueue que = new PriorityQueue();
        assertTrue(que.size() == 0);
        que.add(0);
        que.deleteMin();
        assertTrue(que.size() == 0);
        assertEquals(null, que.deleteMin());
        que.add(6);
        que.add(5);
        que.add(4);
        que.add(8);
        assertTrue(que.size() == 4);
        assertEquals(4, que.deleteMin().getX());
        assertEquals(5, que.deleteMin().getX());
        assertEquals(6, que.deleteMin().getX());
        assertEquals(8, que.deleteMin().getX());
        assertTrue(que.size() == 0);
        assertEquals(null, que.deleteMin());



    }
}
