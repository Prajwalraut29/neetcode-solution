package neetcode.stack;

public class ValidParetheses {
    public boolean isValid(String s) {
        java.util.Stack<Character> stack = new java.util.Stack<>();
        System.out.println("s =>" + s);

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }

                char top = stack.pop();

                if (c == ')' && top != '(') {
                    return false;
                }
                if (c == '}' && top != '{') {
                    return false;
                }
                if (c == ']' && top != '[') {
                    return false;
                }
            }
        }

        return stack.empty();
    }

    public static void main(String[] args) {
        ValidParetheses obj = new ValidParetheses();
    
        System.out.println(obj.isValid("()[]{}"));
    }
}
