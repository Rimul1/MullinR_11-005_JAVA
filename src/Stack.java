public class Stack {
    private class Node {
        private Node prev;
        private Node next;
        private Integer value;

        public Node(Integer value) {
            this.value = value;
        }

        public Integer getValue() {
            return value;
        }

        public Node getPrev() {
            return prev;
        }

        public void setPrev(Node prev) {
            this.prev = prev;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }


    }

    private Node head;

    public void push(Integer value) {
        Node node = new Node(value);

        if (head != null){
            node.next = head;
        }
        this.head = node;
    }

    public Integer peek(){
        if (head != null) {
            return head.getValue();
        }
        throw new MyEmptyStackException("Стек пустой");
    }

    public Integer pop(){
        if (head != null) {
            Node node = head;
            this.head = head.next;
            return node.getValue();
        }
        throw new  MyEmptyStackException("Стек пустой");
    }



}

