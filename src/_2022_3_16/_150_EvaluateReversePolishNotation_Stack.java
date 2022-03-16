package _2022_3_16;

import java.util.Stack;

public class _150_EvaluateReversePolishNotation_Stack {
    // Time complexity: O(n)
    // Space Complexity: O(n)
    /*
       String的比较不能直接比较，需要使用equal方法
     */
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].equals("+") || tokens[i].equals("-") ||
                    tokens[i].equals("*") || tokens[i].equals("/")) {
                int pop1 = stack.pop();
                int pop2 = stack.pop();
                if (tokens[i].equals("+")) stack.push(pop1 + pop2);
                else if (tokens[i].equals("-")) stack.push(pop2 - pop1);
                else if (tokens[i].equals("*")) stack.push(pop1 * pop2);
                else stack.push(pop2 / pop1);
            } else {
                stack.push(Integer.parseInt(tokens[i]));
            }
        }
        return stack.pop();
    }
}

