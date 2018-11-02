package test;
import static org.junit.Assert.*;

import data_structures.Stack;
import org.junit.Test;

/*
Author: Jeremy Wiens
Date: Nov. 1, 2018
Assignment #1 (Comp 272 - Athabasca University)

This is the full testing for the Stack class. It's format can be copied
to include more test cases.
 */

public class StackTesting {
    @Test
    public void test() {
        Stack stack = new Stack();
        assertTrue(stack.pop() == null);
        assertTrue(stack.size() == 0);
        stack.push(5);
        stack.push(4);
        stack.push(7);
        assertEquals(7, stack.pop().getX());
        stack.push(2);
        assertTrue(stack.size() == 3);
        assertEquals(2, stack.pop().getX());
        assertTrue(stack.size() == 2);
        assertEquals(4, stack.pop().getX());
        assertEquals(5, stack.pop().getX());
        assertTrue(stack.size() == 0);
        assertTrue(stack.pop() == null);
        stack.push(3);
        assertEquals(3, stack.pop().getX());



    }
}
