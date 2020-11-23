package ua.edu.ucu.collections.immutable;

import java.util.Arrays;

public class ImmutableArrayList implements ImmutableList {
    private final Object[] elements;

    public ImmutableArrayList() {
        this.elements = new Object[] {};
    }

    public ImmutableArrayList(Object[] a) {
        this.elements = a.clone();
    }

    @Override
    public ImmutableArrayList add(Object a) {
        return this.add(this.elements.length, a);
    }

    @Override
    public ImmutableArrayList add(int index, Object a) throws IndexOutOfBoundsException {
        if (index > this.elements.length || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        Object[] newList = Arrays.copyOf(this.elements, this.elements.length + 1);
        newList[index] = a;
        for (int i = index + 1; i < this.elements.length + 1; i++){
            newList[i] = this.elements[i - 1];
        }
        return new ImmutableArrayList(newList);
    }

    @Override
    public ImmutableArrayList addAll(Object[] a) {
        return this.addAll(this.elements.length, a);
    }

    @Override
    public ImmutableLinkedList addAll(int index, Object[] a) throws IndexOutOfBoundsException {
        if (index > this.elements.length || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        Object [] newList = Arrays.copyOf(this.elements, this.elements.length + a.length);
        for (int i = index; i < a.length + index; i++) {
            newList[i] = a[i - index];
        }
        for (int i = a.length + index; i < this.elements.length + a.length; i++) {
            newList[i] = this.elements[i - a.length];
        }
        return new ImmutableArrayList(newList);
    }

    @Override
    public Object get(int index) {
        if (index > this.elements.length - 1 || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        return this.elements[index];
    }

    @Override
    public ImmutableArrayList remove(int index) throws IndexOutOfBoundsException {
        if (index > this.elements.length - 1 || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        Object[] newList = Arrays.copyOf(this.elements,
                this.elements.length - 1);
        for (int i = index; i < this.elements.length - 1; i++) {
            newList[i] = this.elements[i+1];
        }
        return new ImmutableArrayList(newList);
    }
    @Override
    public ImmutableArrayList set(int index, Object e)
            throws IndexOutOfBoundsException {
        if (index > this.elements.length - 1 || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        Object[] newList = Arrays.copyOf(this.elements, this.elements.length);
        newList[index] = e;
        return new ImmutableArrayList(newList);
    }

    @Override
    public int indexOf(Object e) {
        for (int i = 0; i < this.elements.length; i++) {
            if (this.elements[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int size() {
        return this.elements.length;
    }

    @Override
    public ImmutableArrayList clear() {
        return new ImmutableArrayList();
    }

    @Override
    public boolean isEmpty() {
        return this.size() == 0;
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(this.elements, this.elements.length);
    }

    @Override
    public String toString() {
        StringBuffer stbuf = new StringBuffer();
        for (int i = 0; i < this.elements.length; i++) {

            stbuf.append(String.valueOf(this.elements[i]));
            if (i != this.elements.length-1) {
                stbuf.append(", ");
            }

        }
        return stbuf.toString();
    }
}



