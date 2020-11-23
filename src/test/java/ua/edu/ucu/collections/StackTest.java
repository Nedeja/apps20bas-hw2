package ua.edu.ucu.collections;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class StackTest {
    private Stack s;

    @Before
    public void setUp() {
        s = new Stack();
    }
    
    @Test
    public void testStackDifferent() {
        int[] elements = new int[]{1, 2, 3};
        for (int i : elements) {
            s.push(i);
            assertEquals(i, s.peek());
        }
        for (int i = 0; i < 3; i++) {
            assertEquals(elements[2 - i], s.peek());
            assertEquals(elements[2 - i], s.pop());
        }
    }

    @Test
    public void testStackSimilar() {
        int[] elements = new int[]{1, 1, 1};
        for (int i : elements) {
            s.push(i);
        }
        for (int i = 0; i < 3; i++) {
            assertEquals(elements[i], s.peek());
            assertEquals(elements[i], s.pop());
        }
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testQueueError() {
        s.pop();
    }


}

