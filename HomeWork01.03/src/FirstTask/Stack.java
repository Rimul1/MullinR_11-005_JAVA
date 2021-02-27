package FirstTask;

public class Stack<T> {
    private class Node {
        private Node next;
        private T value;

        public Node(T value) {
            this.value = value;
        }

        public T getValue() {
            return value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }


    }

    private Node head;

    public void push(T value) {
        Node node = new Node(value);

        if (head != null){
            node.next = head;
        }
        this.head = node;
    }

    public T peek(){
        if (head != null) {
            return head.getValue();
        }
        throw new MyEmptyStackException("Стек пустой");
    }

    public T pop(){
        if (head != null) {
            Node node = head;
            this.head = head.next;
            return node.getValue();
        }
        throw new  MyEmptyStackException("Стек пустой");
    }



}

