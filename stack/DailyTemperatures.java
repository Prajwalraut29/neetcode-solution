package neetcode.stack;

import java.util.Arrays;
import java.util.Stack;

public class DailyTemperatures {
    
    public static void main(String[] args) {
         Solution solution = new Solution();
         int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
         int[] result = solution.dailyTemperatures(temperatures);
         System.out.println(Arrays.toString(result));
    }

    static class Solution {
        public int[] dailyTemperatures(int[] temperatures){
            Stack<Integer> stack = new Stack<>();
            int n = temperatures.length;
            int[] result = new int[n];
            
            for(int i = 0; i < n; i++){
                System.out.println("\nChecking temperature at day " + i + ": " + temperatures[i]);
                
                // Print elements being compared safely inside the while condition loop
                while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                    System.out.println(" -> Warmer than top of stack day " + stack.peek() + " (" + temperatures[stack.peek()] + ")");
                    
                    int prevIndex = stack.pop();
                    result[prevIndex] = i - prevIndex;
                }
                
                stack.push(i);
                System.out.println("Pushed day " + i + " to stack. Current stack indices: " + stack);
            }
            return result;
        }
    }
}
