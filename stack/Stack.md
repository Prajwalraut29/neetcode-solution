# Stack

## 1. Valid Parentheses (LeetCode 20)

**Problem:** Given a string `s` containing just the characters `(`, `)`, `{`, `}`, `[` and `]`, determine if the input string is valid.

**Approach:** Use a stack. Push opening brackets onto the stack. For each closing bracket, check if it matches the top of the stack.

```java
public boolean isValid(String s) {
    java.util.Stack<Character> stack = new java.util.Stack<>();

    for (char c : s.toCharArray()) {
        if (c == '(' || c == '{' || c == '[') {
            stack.push(c);
        } else {
            if (stack.isEmpty()) return false;
            char top = stack.pop();
            if (c == ')' && top != '(') return false;
            if (c == '}' && top != '{') return false;
            if (c == ']' && top != '[') return false;
        }
    }
    return stack.empty();
}
```

**Time Complexity:** O(n) | **Space Complexity:** O(n)

---

## 2. Evaluate Reverse Polish Notation (LeetCode 150)

**Problem:** You are given an array of strings `tokens` that represents an arithmetic expression in Reverse Polish Notation. Evaluate the expression and return an integer.

**Approach:** Use a stack. Push numbers onto the stack. When an operator is encountered, pop two operands, apply the operator, and push the result back.

```java
public int evalRPN(String[] tokens) {
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
        } else {
            stack.push(Integer.parseInt(c));
        }
    }
    return stack.pop();
}
```

**Time Complexity:** O(n) | **Space Complexity:** O(n)
