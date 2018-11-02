package test;

import static org.junit.Assert.*;

import org.junit.Test;

import words.*;

/*
Author: Jeremy Wiens
Date: Nov. 1, 2019
Assignment #1 (Comp 272 - Athabasca University)

This is the full testing for the Bag class. It's format can be copied
to include more test cases.
 */

public class BagTesting {

    @Test
    public void Test(){
        Bag<Integer> bag = new Bag();
        bag.add(5);
        bag.add(5);
        assertEquals(null, bag.find(6));
        bag.remove(5);
        assertEquals(5, bag.remove(5).getData());
        assertTrue(bag.size() == 0);
        bag.add(6);
        bag.add(8);
        bag.add(9);
        bag.add(5);

        bag.add(23);
        bag.add(5);
        bag.add(5);
        bag.add(49);
        int expected = bag.size() - 2;
        assertTrue((int)bag.findAll(5)[2].getData() == 5);
        assertTrue(bag.findAll(5)[3] == null);
        bag.remove(5);
        bag.add(26);
        assertTrue((int)bag.findAll(5)[1].getData() == 5);
        assertTrue(bag.findAll(5)[2] == null);
        assertEquals(26, bag.find(26).getData());
    }
}
