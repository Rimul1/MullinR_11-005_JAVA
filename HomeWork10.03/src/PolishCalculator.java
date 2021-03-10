import java.util.Scanner;
import java.util.Stack;

public class PolishCalculator {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String string = in.nextLine();

        String[] strings = string.split(" ");

        Stack<Double> stack = new Stack<Double>();

        for (int i = 0; i < strings.length; i++) {
            if (isNumber(strings[i])) {
                stack.push(Double.parseDouble(strings[i]));
            } else {
                double tmp1 = stack.pop();
                double tmp2 = stack.pop();

                switch (strings[i]) {
                    case "+":
                        stack.push(tmp1 + tmp2);
                        break;

                    case "-":
                        stack.push(tmp2 - tmp1);
                        break;

                    case "*":
                        stack.push(tmp1 * tmp2);
                        break;

                    case "/":
                        stack.push(tmp2 / tmp1);
                        break;

                }
            }
        }

        if (!stack.empty()) {
            System.out.println(stack.pop());
        } else {
            System.out.println("Ошибка!");
        }
    }

    private static boolean isNumber(String string) {
        try {
            Double.parseDouble(string);

            return true;
        } catch (NumberFormatException exception) {
            return false;
        }
    }


}
