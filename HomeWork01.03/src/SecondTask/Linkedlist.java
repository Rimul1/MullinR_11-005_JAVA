package SecondTask;

import java.util.Iterator;

public class Linkedlist<T> implements Iterable<T>{

    @Override
    public Iterator iterator() {
        return new  LinkedlistIterator();
    }

    public class Node {
        private Node next;
        private T value;

        public Node(T value) {
            this.value = value;
        }

        public T getValue() {
            return value;
        }
    }

    private Node head;

    public void add(T value) {
        Node node = new Node(value);
        if (head == null) {
            head = node;
        } else {
            head.next = node;
        }
    }

    public T get(int i) {
        int size = 0;
        Node node = head;
        while (size == i) {
            node = node.next;
            size++;
        }
        return node.value;
    }

    public boolean remove(int i) {
        return false;
    }

    public class LinkedlistIterator<T> implements Iterator<T> {

        public LinkedlistIterator() {
        }

        @Override
        public boolean hasNext() {
            return head != null;
        }

        @Override
        public T next() {
            return remove();
        }
    }
}
