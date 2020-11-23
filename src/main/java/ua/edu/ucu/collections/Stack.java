package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

public class Stack {
    private ImmutableLinkedList lst;

    public Stack() {
        lst = new ImmutableLinkedList();
    }

    public Object peek() {
        return this.lst.getFirst();
    }

    public Object pop() {
        Object element = this.lst.getFirst();
        this.lst = this.lst.removeFirst();
        return element;
    }

    public void push(Object element) {
        this.lst = this.lst.addFirst(element);
    }
}

