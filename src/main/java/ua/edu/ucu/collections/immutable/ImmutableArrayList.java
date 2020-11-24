package ua.edu.ucu.collections.immutable;

import org.junit.Test;
import static org.junit.Assert.*;

public class ImmutableLinkedListTest {

    @Test
    public void testToStringEmpty() {
        ImmutableLinkedList a = new ImmutableLinkedList();
        assertEquals("", a.toString());
    }

    @Test
    public void testToStringOneElem() {
        Object[] list = {1};
        ImmutableLinkedList a = new ImmutableLinkedList(list);
        assertEquals("1", a.toString());
    }

    @Test
    public void testGetFirstEmpty() {
        ImmutableLinkedList a = new ImmutableLinkedList();
        Object b = a.getFirst();
        assertNull(b);
    }

    @Test
    public void testGetFirstOneElem() {
        Object[] list = {1};
        ImmutableLinkedList a = new ImmutableLinkedList(list);
        Object b = a.getFirst();
        assertEquals(1, b);
    }

    @Test
    public void testGetFirst() {
        ImmutableLinkedList a = new ImmutableLinkedList().addAll(new Object[] {1,2,3});
        Object b = a.getFirst();
        assertEquals(1, b);
    }

    @Test
    public void testGetLastEmpty() {
        ImmutableLinkedList a = new ImmutableLinkedList();
        Object b = a.getLast();
        assertNull(b);
    }

    @Test
    public void testGetLastOneElem() {
        Object[] list = {1};
        ImmutableLinkedList a = new ImmutableLinkedList(list);
        Object b = a.getLast();
        assertEquals(1, b);
    }

    @Test
    public void testGetLast() {
        ImmutableLinkedList a = new ImmutableLinkedList().addAll(new Object[] {1,2,3});
        Object b = a.getLast();
        assertEquals(3, b);
    }

    @Test
    public void testAddEmpty() {
        ImmutableLinkedList a = new ImmutableLinkedList();
        ImmutableLinkedList b = a.add(1);
        assertEquals("1", b.toString());
        assertNotEquals(a.toString(), b.toString());
    }

    @Test
    public void testAddOneElem() {
        Object[] list = {1};
        ImmutableLinkedList a = new ImmutableLinkedList(list);
        ImmutableLinkedList b = a.add(2);
        assertEquals("1, 2", b.toString());
        assertNotEquals(a.toString(), b.toString());
    }

    @Test
    public void testAddIndexEmpty() {
        ImmutableLinkedList a = new ImmutableLinkedList();
        ImmutableLinkedList b = a.add(0, 1);
        assertEquals("1", b.toString());
        assertNotEquals(a.toString(), b.toString());
    }

    @Test
    public void testAddIndexOneElementFirst() {
        Object[] list = {2};
        ImmutableLinkedList a = new ImmutableLinkedList(list);
        ImmutableLinkedList b = a.add(0, 1);
        assertEquals("1, 2", b.toString());
        assertNotEquals(a.toString(), b.toString());
    }

    @Test
    public void testAddIndexOneElementLast() {
        Object[] list = {1};
        ImmutableLinkedList a = new ImmutableLinkedList(list);
        ImmutableLinkedList b = a.add(1, 2);
        assertEquals("1, 2", b.toString());
        assertNotEquals(a.toString(), b.toString());
    }

    @Test
    public void testAddIndexBetween() {
        Object[] list = {1};
        ImmutableLinkedList a = new ImmutableLinkedList(list);
        ImmutableLinkedList b = a.add(3);
        ImmutableLinkedList c = b.add(1,2);
        assertEquals("1, 2, 3", c.toString());
        assertNotEquals(a.toString(), b.toString());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddIndexException() {
        Object[] list = {1};
        ImmutableLinkedList a = new ImmutableLinkedList(list);
        ImmutableLinkedList b = a.add(3);
        ImmutableLinkedList c = b.add(100,2);
    }

    @Test
    public void testAddAllEmpty() {
        ImmutableLinkedList a = new ImmutableLinkedList();
        ImmutableLinkedList b = a.addAll(new Object[] {1,2,3});
        assertEquals("1, 2, 3", b.toString());
        assertNotEquals(a.toString(), b.toString());
    }

    @Test
    public void testAddAllOneElem() {
        Object[] list = {1};
        ImmutableLinkedList a = new ImmutableLinkedList(list);
        ImmutableLinkedList b = a.addAll(new Object[] {2,3,4});
        assertEquals("1, 2, 3, 4", b.toString());
        assertNotEquals(a.toString(), b.toString());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddAllIndexException() {
        Object[] list = {1};
        ImmutableLinkedList a = new ImmutableLinkedList(list);
        ImmutableLinkedList b = a.addAll(100, new Object[] {2,3,4});
    }

    @Test
    public void testAddAllIndexEmpty() {
        ImmutableLinkedList a = new ImmutableLinkedList();
        ImmutableLinkedList b = a.addAll(0, new Object[] {1,2,3});
        assertEquals("1, 2, 3", b.toString());
        assertNotEquals(a.toString(), b.toString());
    }

    @Test
    public void testAddAllIndexLast() {
        Object[] list = {1};
        ImmutableLinkedList a = new ImmutableLinkedList(list);
        ImmutableLinkedList b = a.addAll(1, new Object[] {2,3,4});
        assertEquals("1, 2, 3, 4", b.toString());
        assertNotEquals(a.toString(), b.toString());
    }

    @Test
    public void testAddAllIndexMiddle() {
        ImmutableLinkedList a = new ImmutableLinkedList().addAll(new Object[] {1,2,6,7});
        ImmutableLinkedList b = a.addAll(2, new Object[] {3,4,5});
        assertEquals("1, 2, 3, 4, 5, 6, 7", b.toString());
        assertNotEquals(b.toString(), a.toString());
    }

    @Test
    public void testAddAllIndexFirst() {
        ImmutableLinkedList a = new ImmutableLinkedList().addAll(new Object[] {4,5,6,7});
        ImmutableLinkedList b = a.addAll(0, new Object[] {1,2,3});
        assertEquals("1, 2, 3, 4, 5, 6, 7", b.toString());
        assertNotEquals(b.toString(), a.toString());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetException() {
        Object[] list = {1};
        ImmutableLinkedList a = new ImmutableLinkedList(list);
        Object b = a.get(100);
    }

    @Test
    public void testGet() {
        ImmutableLinkedList a = new ImmutableLinkedList().addAll(new Object[] {1,2,3,4,5,6});
        Object b = a.get(3);
        assertEquals(4, b);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveException() {
        Object[] list = {1};
        ImmutableLinkedList a = new ImmutableLinkedList(list);
        Object b = a.remove(100);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveExceptionMinusOne() {
        Object[] list = {1};
        ImmutableLinkedList a = new ImmutableLinkedList(list);
        Object b = a.remove(-1);
    }

    @Test
    public void testRemoveFirst() {
        ImmutableLinkedList a = new ImmutableLinkedList().addAll(new Object[] {1,2,3,4,5,6});
        ImmutableLinkedList b = a.remove(0);
        assertEquals("2, 3, 4, 5, 6", b.toString());
    }

    @Test
    public void testRemoveLast() {
        ImmutableLinkedList a = new ImmutableLinkedList().addAll(new Object[] {1,2,3,4,5,6});
        ImmutableLinkedList b = a.remove(5);
        assertEquals("1, 2, 3, 4, 5", b.toString());
    }

    @Test
    public void testRemove() {
        ImmutableLinkedList a = new ImmutableLinkedList().addAll(new Object[] {1,2,3,4,5,6});
        ImmutableLinkedList b = a.remove(3);
        assertEquals("1, 2, 3, 5, 6", b.toString());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testSetException() {
        Object[] list = {1};
        ImmutableLinkedList a = new ImmutableLinkedList(list);
        Object b = a.set(100, 1);
    }

    @Test
    public void testSetFirst() {
        ImmutableLinkedList a = new ImmutableLinkedList().addAll(new Object[] {1,2,3,4,5,6});
        ImmutableLinkedList b = a.set(0, 100);
        assertEquals("100, 2, 3, 4, 5, 6", b.toString());
    }

    @Test
    public void testSetLast() {
        ImmutableLinkedList a = new ImmutableLinkedList().addAll(new Object[] {1,2,3,4,5,6});
        ImmutableLinkedList b = a.set(5, 600);
        assertEquals("1, 2, 3, 4, 5, 600", b.toString());
    }

    @Test
    public void testSetMiddle() {
        ImmutableLinkedList a = new ImmutableLinkedList().addAll(new Object[] {1,2,3,4,5,6});
        ImmutableLinkedList b = a.set(2, 300);
        assertEquals("1, 2, 300, 4, 5, 6", b.toString());
    }

    @Test
    public void testIndexOfElemNotInList() {
        Object[] list = {1};
        ImmutableLinkedList a = new ImmutableLinkedList(list);
        int b = a.indexOf(100);
        assertEquals(-1, b);
    }

    @Test
    public void testIndexOfFirst() {
        ImmutableLinkedList a = new ImmutableLinkedList().addAll(new Object[] {1,2,3,4,5,6});
        int b = a.indexOf(1);
        assertEquals(0, b);
    }

    @Test
    public void testIndexOfLast() {
        ImmutableLinkedList a = new ImmutableLinkedList().addAll(new Object[] {1,2,3,4,5,6});
        int b = a.indexOf(6);
        assertEquals(5, b);
    }

    @Test
    public void testIndexOfMiddle() {
        ImmutableLinkedList a = new ImmutableLinkedList().addAll(new Object[] {1,2,3,4,5,6});
        int b = a.indexOf(3);
        assertEquals(2, b);
    }

    @Test
    public void testIndexOfEmpty() {
        ImmutableLinkedList a = new ImmutableLinkedList();
        int b = a.size();
        assertEquals(0, b);
    }

    @Test
    public void testIndexOf() {
        ImmutableLinkedList a = new ImmutableLinkedList().addAll(new Object[] {1,2,3,4,5,6});
        int b = a.size();
        assertEquals(6, b);
    }

    @Test
    public void testIsEmptyEmpty() {
        ImmutableLinkedList a = new ImmutableLinkedList();
        boolean b = a.isEmpty();
        assertTrue(b);
    }

    @Test
    public void testIsEmptyNotEmpty() {
        ImmutableLinkedList a = new ImmutableLinkedList().addAll(new Object[] {1,2,3,4,5,6});
        boolean b = a.isEmpty();
        assertFalse(b);
    }

    @Test
    public void testClearEmpty() {
        ImmutableLinkedList a = new ImmutableLinkedList();
        ImmutableLinkedList b = a.clear();
        assertEquals("", b.toString());
        assertNotEquals(b, a);
    }

    @Test
    public void testClear() {
        ImmutableLinkedList a = new ImmutableLinkedList().addAll(new Object[] {1,2,3,4,5,6});
        ImmutableLinkedList b = a.clear();
        assertEquals("", b.toString());
        assertNotEquals(b, a);
        assertEquals("1, 2, 3, 4, 5, 6", a.toString());
    }

    @Test
    public void testToArrayEmpty() {
        ImmutableLinkedList a = new ImmutableLinkedList();
        Object[] b = a.toArray();
        assertArrayEquals(new Object[] {}, b);
    }

    @Test
    public void testToArray() {
        ImmutableLinkedList a = new ImmutableLinkedList().addAll(new Object[] {1,2,3,4,5,6});
        Object[] b = a.toArray();
        assertArrayEquals(new Object[] {1,2,3,4,5,6}, b);
    }


}
