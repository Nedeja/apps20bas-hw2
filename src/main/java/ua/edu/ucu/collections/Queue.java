package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

public class Queue {
    private ImmutableLinkedList lst;

    public Queue() {
        lst = new ImmutableLinkedList();
    }

    public Object peek() {
        return this.lst.getFirst();
    }

    public Object dequeue() {
        Object element = this.lst.getFirst();
        this.lst = this.lst.removeFirst();
        return element;
    }

    public void enqueue(Object element) {
        lst = lst.addLast(element);
    }
}
