package test;
import static org.junit.Assert.*;

import org.junit.Test;

import words.PriorityQueue;
import words.*;

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
}
