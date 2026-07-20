package neetcode.slidingwindow;

import java.util.HashMap;
import java.util.HashSet;

public class LongestRepeatingChar {
    public static void main(String[] args) {
        Solution obj = new Solution();
        // int arr[] = [7,1,5,3,6,4];
        String s = "AABABBA";
        int k = 1;
        int ans = obj.LongestRepeatingChar(s, k);
        System.out.println("ans => " + ans);
    }

    static class Solution {
        public int LongestRepeatingChar(String arr, int k) {
            int res = 0;
            HashSet<Character> charSet = new HashSet<>();
            for (char c : arr.toCharArray()) {
                charSet.add(c);
            }

            for (char x : charSet) {
                // System.out.println("x =>" + x);
                int count = 0;
                int l = 0;
                for (int r = 0; r < arr.length(); r++) {
                    if (arr.charAt(r) == x) {
                        count++;
                    }

                    while ((r - l + 1) - count > k) {

                        if (arr.charAt(l) == x) {
                            count--;
                        }

                        l++;
                    }
                    res = Math.max(res, r - l + 1);
                }
            }

            return res;
        }
    }
}