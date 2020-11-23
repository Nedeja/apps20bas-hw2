package ua.edu.ucu.collections.immutable;

public class ImmutableLinkedList  implements ImmutableList{
    private class Node {
        private Object element;
        private Node next;
        private Node previous;

        Node(Object element, Node next, Node previous) {
            this.element = element;
            this.next = next;
            this.previous = previous;
        }

        Node(Object element) {
            this.element = element;
            this.next = null;
            this.previous = null;
        }

        public Object getElement() {
            return this.element;
        }

        public Node getNext() {
            return this.next;
        }

        public Node getPrevious() {
            return this.previous;
        }

        public void setElement(Object newElement) {
            this.element = newElement;
        }

        public void setNext(Node nextNode) {
            this.next = nextNode;
        }

        public void setPrevious(Node previousNode) {
            this.previous = previousNode;
        }

        private Node copiedNode() {
            return new Node(this.element, null, null);
        }

        public void addNextNode(Object newElement) {
            Node newNode = new Node(newElement, this.getNext(), this);
            this.setNext(newNode);
            if (this.getNext() != null) {
                this.getNext().setPrevious(newNode);
            }
        }
    }

    private final Node head;
    private final Node tail;
    private final int size;

    public ImmutableLinkedList(Object element) {
        Node node = new Node(element);
        this.head = node;
        this.tail = node;
        this.size = 1;
    }

    public ImmutableLinkedList(Node head, Node tail) {
        this.head = head;
        this.tail = tail;
        Node node = head;
        int i = 1;
        while (node.getNext() != null) {
            node = node.getNext();
            i++;
        }
        this.size = i;
    }

    public ImmutableLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    private void indexCheck(int index) throws IndexOutOfBoundsException {
        if (index > this.size - 1 || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        else if (index > this.size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
    }

    private Node goTo(int index, Node node) {
        Node newNode = node;
        for (int i = 0; i < index; i++) {
            newNode = newNode.getNext();
        }
        return newNode;
    }

    private Node[] copyAll() {
        if (this.head == null) {
            return new Node[] {null, null};
        }
        Node newHead = this.head.copiedNode();
        Node iteratedNode = this.head;
        Node previousNode = null;
        Node iterNewNode = newHead;
        while (iteratedNode.getNext() != null) {
            iterNewNode.setNext(iteratedNode.getNext().copiedNode());
            iterNewNode.setPrevious(previousNode);
            previousNode = iterNewNode;
            iterNewNode = iterNewNode.getNext();
            iteratedNode = iteratedNode.getNext();
        }
        iterNewNode.setPrevious(previousNode);
        return new Node[] {newHead, iterNewNode};
    }

    public ImmutableLinkedList addFirst(Object element) {
        if (this.isEmpty()) {
            return new ImmutableLinkedList(element);
        }
        else {
            Node[] newHeadTail = this.copyAll();
            Node newHead = new Node(element, newHeadTail[0], null);
            newHeadTail[0].setPrevious(newHead);
            return new ImmutableLinkedList(newHead, newHeadTail[1]);
        }
    }

    public ImmutableLinkedList addLast(Object element) {
        if (this.isEmpty()) {
            return new ImmutableLinkedList(element);
        }
        else{
            Node[] newHeadTail = this.copyAll();
            newHeadTail[1].addNextNode(element);
            return new ImmutableLinkedList(newHeadTail[0], newHeadTail[1].getNext());
        }
    }

    public Object getFirst() {
        if (this.isEmpty()) {
            return null;
        }
        else{
            return this.head.getElement();
        }
    }

    public Object getLast() {
        if (this.isEmpty()) {
            return null;
        }
        else{
            return this.tail.getElement();
        }
    }

    public ImmutableLinkedList removeFirst() {
        if (this.isEmpty()) {
            return new ImmutableLinkedList();
        }
        else{
            Node[] newHeadTail = this.copyAll();
            newHeadTail[0].getNext().setPrevious(null);
            return new ImmutableLinkedList(newHeadTail[0].getNext(),
                    newHeadTail[1]);
        }
    }

    public ImmutableLinkedList removeLast() {
        if (this.isEmpty()) {
            return new ImmutableLinkedList();
        }
        else {
            Node[] newHeadTail = this.copyAll();
            newHeadTail[1].getPrevious().setNext(null);
            return new ImmutableLinkedList(newHeadTail[0], newHeadTail[1].getPrevious());
        }
    }

    @Override
    public ImmutableLinkedList add(Object e) {
        return this.addLast(e);
    }

    @Override
    public ImmutableLinkedList add(int index, Object elem) throws IndexOutOfBoundsException {
        indexCheck(index);
        if (index == 0) {
            return this.addFirst(elem);
        }
        else if (index == this.size) {
            return this.addLast(elem);
        }
        else {
            Node[] newHeadTail = this.copyAll();
            Node prevNode = goTo(index - 1, newHeadTail[0]);
            prevNode.addNextNode(elem);
            return new ImmutableLinkedList(newHeadTail[0],
                    newHeadTail[1]);
        }
    }

    @Override
    public ImmutableLinkedList addAll(Object[] a) {
        Node[] newHeadTail = this.copyAll();
        for (Object elem: a) {
            if (newHeadTail[0] == null) {
                newHeadTail[0] = new Node(elem);
                newHeadTail[1] = newHeadTail[0];
            }
            else {
                newHeadTail[1].addNextNode(elem);
                newHeadTail[1] = newHeadTail[1].getNext();
            }
        }
        return new ImmutableLinkedList(newHeadTail[0], newHeadTail[1]);
    }

    @Override
    public ImmutableLinkedList addAll(int index, Object[] a)
            throws IndexOutOfBoundsException {
        indexCheck(index);
        if (index == 0) {
            Node headNode = new Node(a[0]);
            Node indexNode = headNode;
            for (int i = 1; i < a.length; i++){
                indexNode = new Node(a[i], null, indexNode);
            }
            if (this.isEmpty()) {
                return new ImmutableLinkedList(indexNode);
            }
            else {
                Node[] newHeadTail = this.copyAll();
                indexNode.setNext(newHeadTail[0]);
                newHeadTail[0].setPrevious(indexNode);
                return new ImmutableLinkedList(headNode, newHeadTail[1]);
            }
        }
        else if (index == this.size) {
            return this.addAll(a);
        }
        else {
            Node[] newHeadTail = this.copyAll();
            Node previousNode = goTo(index - 1, newHeadTail[0]);
            for (Object elem: a) {
                previousNode.addNextNode(elem);
                previousNode = previousNode.getNext();
            }
            return new ImmutableLinkedList(newHeadTail[0], newHeadTail[1]);
        }
    }

    @Override
    public Object get(int index) throws IndexOutOfBoundsException {
        indexCheck(index);
        return goTo(index, this.head).getElement();
    }

    @Override
    public ImmutableLinkedList remove(int index) throws IndexOutOfBoundsException {
        indexCheck(index);
        if (index == 0) {
            return this.removeFirst();
        }
        else if (index == this.size - 1) {
            return this.removeLast();
        }
        Node[] newHeadTail = this.copyAll();
        Node prevToRemove = goTo(index - 1, newHeadTail[0]);
        Node nextToRemove = prevToRemove.getNext().getNext();
        prevToRemove.setNext(nextToRemove);
        nextToRemove.setPrevious(prevToRemove);
        return new ImmutableLinkedList(newHeadTail[0], newHeadTail[1]);
    }

    @Override
    public ImmutableLinkedList set(int index, Object a) throws IndexOutOfBoundsException {
        indexCheck(index);
        Node[] newHeadTail = this.copyAll();
        goTo(index, newHeadTail[0]).setElement(a);
        return new ImmutableLinkedList(newHeadTail[0], newHeadTail[1]);
    }

    @Override
    public int indexOf(Object a) {
        int i = 0;
        Node indexNode = this.head;
        while (indexNode != null) {
            if (indexNode.getElement().equals(a)) {
                return i;
            }
            indexNode = indexNode.getNext();
            i++;
        }
        return -1;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public ImmutableLinkedList clear() {
        return  new ImmutableLinkedList();
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public Object[] toArray() {
        Node indexNode = this.head;
        int i = 0;
        Object[] newArray = new Object[this.size];
        while (indexNode != null) {
            newArray[i] = indexNode.getElement();
            indexNode = indexNode.getNext();
            i++;
        }
        return newArray;
    }

    @Override
    public String toString() {
        StringBuffer stbuf = new StringBuffer();
        Node indexNode = this.head;
        while (indexNode != null) {
            stbuf.append(String.valueOf(indexNode.getElement()));
            if (indexNode.getNext() != null) {
                stbuf.append(", ");
            }
            indexNode = indexNode.getNext();
        }
        return stbuf.toString();
    }
}

