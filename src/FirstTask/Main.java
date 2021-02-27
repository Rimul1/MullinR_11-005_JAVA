package FirstTask;

public class Main {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        Stack<String> stringStack = new Stack<>();

        System.out.println(stack.pop());
        System.out.println(stack.peek());
        System.out.println(stringStack.peek());
        System.out.println(stack.peek());


    }
}
