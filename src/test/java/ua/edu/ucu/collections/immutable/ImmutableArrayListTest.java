package ua.edu.ucu.collections.immutable;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class ImmutableArrayListTest {

    @Test
    public void testAdd() {
        ImmutableArrayList a = new ImmutableArrayList();
        ImmutableList b = a.add(1);
        assertEquals(b.toString(), new ImmutableArrayList(new Object[] {1}).toString());
        assertNotEquals(b.toString(), a.toString());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddWithIndexException() {
        ImmutableArrayList a = new ImmutableArrayList();
        ImmutableList b = a.add(3, 1);
    }

    @Test
    public void testAddWithIndex() {
        ImmutableArrayList a = new ImmutableArrayList(new Object[] {1,2,3});
        ImmutableList b = a.add(1, 7);
        assertEquals(b.toString(), new ImmutableArrayList(new Object[] {1,7,2,3}).toString());
        assertNotEquals(b.toString(), a.toString());
    }

    @Test
    public void testAddAll() {
        ImmutableArrayList a = new ImmutableArrayList(new Object[] {1,2,3});
        ImmutableList b = a.addAll(new Object[] {4,5,6});
        assertEquals(b.toString(), new ImmutableArrayList(new Object[] {1,2,3,4,5,6}).toString());
        assertNotEquals(b.toString(), a.toString());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddAllWithIndexException() {
        ImmutableArrayList a = new ImmutableArrayList(new Object[] {1,2,3});
        ImmutableList b = a.addAll(5, new Object[] {4,5,6});
    }

    @Test
    public void testAddAllWithIndex() {
        ImmutableArrayList a = new ImmutableArrayList(new Object[] {1,2,3});
        ImmutableList b = a.addAll(2, new Object[] {4,5,6});
        assertEquals(b.toString(), new ImmutableArrayList(new Object[] {1,2,4,5,6,3}).toString());
        assertNotEquals(b.toString(), a.toString());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetException() {
        ImmutableArrayList a = new ImmutableArrayList(new Object[] {1,2,3});
        Object elem = a.get(7);
    }

    @Test
    public void testGet() {
        ImmutableArrayList a = new ImmutableArrayList(new Object[] {1,2,3});
        Object elem = a.get(2);
        assertEquals(elem, 3);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveException() {
        ImmutableArrayList a = new ImmutableArrayList(new Object[] {1,2,3});
        Object elem = a.remove(7);
    }

    @Test
    public void testRemove() {
        ImmutableArrayList a = new ImmutableArrayList(new Object[] {1,2,3});
        ImmutableList b = a.remove(1);
        assertEquals(b.toString(), new ImmutableArrayList(new Object[] {1,3}).toString());
        assertNotEquals(b.toString(), a.toString());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveMinusOne() {
        ImmutableArrayList a = new ImmutableArrayList(new Object[] {1,2,3});
        ImmutableList b = a.remove(-1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveLastLast() {
        ImmutableArrayList a = new ImmutableArrayList(new Object[] {1,2,3});
        ImmutableList b = a.remove(3);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testSetException() {
        ImmutableArrayList a = new ImmutableArrayList(new Object[] {1,2,3});
        Object elem = a.set(7, 100);
    }

    @Test
    public void testSet() {
        ImmutableArrayList a = new ImmutableArrayList(new Object[] {1,2,3});
        ImmutableList b = a.set(1, 100);
        assertEquals(b.toString(), new ImmutableArrayList(new Object[] {1,100,3}).toString());
        assertNotEquals(b.toString(), a.toString());
    }

    @Test
    public void testIndexOfNotFound() {
        ImmutableArrayList a = new ImmutableArrayList(new Object[] {1,2,3});
        int res = a.indexOf(100);
        assertEquals(res, -1);
    }

    @Test
    public void testIndexOf() {
        ImmutableArrayList a = new ImmutableArrayList(new Object[] {1,2,3});
        int res = a.indexOf(1);
        assertEquals(res, 0);
    }

    @Test
    public void testSize() {
        ImmutableArrayList a = new ImmutableArrayList(new Object[] {1,2,3});
        int size = a.size();
        assertEquals(size, 3);
    }

    @Test
    public void testClear() {
        ImmutableArrayList a = new ImmutableArrayList(new Object[] {1,2,3});
        ImmutableList b = a.clear();
        assertEquals(b.toString(), "");
        assertNotEquals(b.toString(), a.toString());
    }

    @Test
    public void testIsEmptyTrue() {
        ImmutableArrayList a = new ImmutableArrayList();
        assertTrue(a.isEmpty());
    }

    @Test
    public void testIsEmptyFalse() {
        ImmutableArrayList a = new ImmutableArrayList(new Object[] {1,2,3});
        assertFalse(a.isEmpty());
    }

    @Test
    public void testToArray() {
        ImmutableArrayList a = new ImmutableArrayList(new Object[] {1,2,3});
        assertArrayEquals(a.toArray(), new Object[] {1,2,3});
    }

    @Test
    public void testToString() {
        ImmutableArrayList a = new ImmutableArrayList(new Object[] {1,2,3});
        assertEquals(a.toString(), "1, 2, 3");
    }


}

