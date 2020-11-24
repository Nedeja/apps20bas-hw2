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
        this.lst = this.lst.remove(0);
        return element;
    }

    public void push(Object element) {
        this.lst = this.lst.add(0, element);
    }
}

