package ua.edu.ucu.collections;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class QueueTest {
    private Queue q;

    @Before
    public void setUp() {
        q = new Queue();
    }
    
    @Test
    public void testQueueDifferent() {
        int[] elems = new int[] {1, 2, 3};
        for (int i : elems) {
            q.enqueue(i);
        }
        for (int i = 0; i < 3; i++) {
            assertEquals(elems[i], q.peek());
            assertEquals(elems[i], q.dequeue());
        }
    }

    @Test
    public void testQueueSimilar() {
        int[] elements = new int[]{1, 1, 1};
        for (int i : elements) {
            q.enqueue(i);
        }
        for (int i = 0; i < 3; i++) {
            assertEquals(elements[i], q.peek());
            assertEquals(elements[i], q.dequeue());
        }
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testQueueError() {
        q.dequeue();
    }
    
}

