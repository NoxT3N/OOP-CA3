import java.util.Scanner;
import java.util.Stack;

public class CA3_Question8 {
    public static Stack<Double> nums = new Stack<>();
    public static Stack<Character> ops = new Stack<>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Please enter equation");
        String equation = in.nextLine().trim();

        calculate(equation);

        System.out.println(nums.pop());
    }

    public static void calculate(String equation) {
        char[] tokens = equation.toCharArray();

        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i] == ' ') continue; // skips to next loop iteration

            if (Character.isDigit(tokens[i])) {
                StringBuilder strNum = new StringBuilder(String.valueOf(tokens[i]));
                while (i + 1 < tokens.length && (Character.isDigit(tokens[i + 1]) || tokens[i + 1] == '.')) {
                    strNum.append(tokens[i + 1]);
                    i++;
                }
                nums.push(Double.parseDouble(strNum.toString()));
            } else if (tokens[i] == '(') {
                ops.push(tokens[i]);
            } else if (isOperator(tokens[i])) {
                while (!ops.isEmpty() && hasPrecedence(ops.peek(), tokens[i])) {
                    evaluateTop();
                }
                ops.push(tokens[i]);
            } else if (tokens[i] == ')') {
                while (!ops.isEmpty() && ops.peek() != '(') {
                    evaluateTop();
                }
                ops.pop();  //removes the closing bracket from the ops stack
            } else {
                while (!ops.isEmpty()) {
                    evaluateTop();
                }
            }
        }

        while (!ops.isEmpty()) {
            evaluateTop();
        }
    }

    public static void evaluateTop() {
        if (nums.size() >= 2 && !ops.isEmpty()) {
            double b = nums.pop();
            double a = nums.pop();
            char op = ops.pop();

            switch (op) {
                case '+' -> nums.push(a + b);
                case '-' -> nums.push(a - b);
                case '*' -> nums.push(a * b);
                case '/' -> nums.push(a / b);
            }
        }
    }

    private static boolean isOperator(char op) {
        return op == '+' || op == '-' || op == '*' || op == '/';
    }

    private static boolean hasPrecedence(char op1, char op2) {
        if (op2 == '(' || op2 == ')') {
            return false;
        }
        return (op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-');
    }
}
