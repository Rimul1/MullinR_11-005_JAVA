package FirstTask;

public class Main {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        Stack<String> stringStack = new Stack<>();

        for (Integer i: stack){
            System.out.println(i);
        }
    }
}
