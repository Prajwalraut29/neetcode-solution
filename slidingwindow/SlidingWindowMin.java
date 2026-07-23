package neetcode.slidingwindow;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class SlidingWindowMin {
    public static void main(String[] args) {
        System.out.println("enjoy");
        Solution obj = new Solution();
        int[] nums = new int[] { 1, 3, -1, -3, 5, 3, 6, 7 };
        int k = 3;
        int[] result = obj.maxSlidingWindow(nums, k);
        for (int value : result) {
            System.out.print(value + " ");
        }
    }

   static public class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            int n = nums.length;
            Deque<Integer> deq = new ArrayDeque<>();

            List<Integer> result = new ArrayList<>();

            for (int i = 0; i < nums.length; i++) {
                while (!deq.isEmpty() && deq.getFirst() <= i - k) {
                    deq.removeFirst();
                }

                while (!deq.isEmpty() && nums[i] >= nums[deq.getLast()]) {
                    deq.pollLast();
                }

                deq.addLast(i);

                if (i >= k - 1) {
                    result.add(nums[deq.getFirst()]);
                }
            }

            return result.stream().mapToInt(i -> i).toArray();
        }
    }
}
