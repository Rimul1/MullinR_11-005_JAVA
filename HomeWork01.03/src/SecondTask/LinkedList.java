package SecondTask;

import java.util.Iterator;

public class LinkedList<T> implements Iterable<T> {

    @Override
    public Iterator<T> iterator() {
        return new LinkedListIterator();
    }

    public class Node {
        private Node next;
        private Node prev;
        private T value;

        public Node(T value) {
            this.value = value;
        }

        public T getValue() {
            return value;
        }
    }

    private Node first;
    private Node last;
    private int count;

    public void add(T value) {
        Node node = new Node(value);
        if (first == null) {
            first = node;
        } else {
            last.next = node;
            node.prev = last;
        }
        last = node;
        count++;
    }


    public T get(int i) {
        if (i < 0) {
            throw new IllegalArgumentException();
        }
        if (i > count) {
            throw new IndexOutOfBoundsException();
        }

        int size = 0;
        Node node = first;
        while (size != i) {
            size++;
            node = node.next;
        }
        return node.value;
    }

    public void remove(int i) {
        if (i < 0) {
            throw new IllegalArgumentException();
        }

        if (i > count) {
            throw new IndexOutOfBoundsException();
        }

        int size = 0;
        Node node = first;
        while (size != i) {
            size++;
            node = node.next;
        }

        Node prev = node.prev;
        Node next = node.next;

        prev.next = next;
        next.prev = prev;
        count--;
    }

    public class LinkedListIterator implements Iterator<T> {

        public LinkedListIterator() {
        }

        Node copyOfHead = first;

        @Override
        public boolean hasNext() {
            return copyOfHead != null;
        }

        @Override
        public T next() {
            T value = copyOfHead.value;
            copyOfHead = copyOfHead.next;
            return value;
        }
    }
}
