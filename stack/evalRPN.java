package neetcode.stack;
public class evalRPN {
    public int evalRPN(String[] tokens) {
        System.out.println("token => " + tokens);
        java.util.Stack<Integer> stack = new java.util.Stack<>();

        for (String c : tokens) {
            if (c.equals("+")) {
                stack.push(stack.pop() + stack.pop());
            } else if (c.equals("-")) {
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a - b);

            } else if (c.equals("*")) {
                stack.push(stack.pop() * stack.pop());
            } else if (c.equals("/")) {
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a / b);
            }else {
                stack.push(Integer.parseInt(c));
            }

        }
        return stack.pop();
    }

    public static void main(String[] args) {
        evalRPN obj = new evalRPN();
        String[] tokens = { "2", "1", "+", "3", "*" };
        System.out.println(obj.evalRPN(tokens));
    }
}
