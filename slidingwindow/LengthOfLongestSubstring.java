package neetcode.slidingwindow;
import java.util.HashMap;

public class LengthOfLongestSubstring {

    public static void main(String[] args) {
        Solution obj = new Solution();

        String s = "abcabcbb";
        int ans = obj.lengthOfLongestSubstring(s);

        System.out.println("Answer: " + ans);
    }
}

class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> mp = new HashMap<>();
        int i = 0;
        int j = 0;
        int ans = 0;

        while (j < s.length()) {
            char ch = s.charAt(j);
            mp.put(ch, mp.getOrDefault(ch, 0) + 1);

            int windowSize = j - i + 1;

            if (mp.size() == windowSize) {
                ans = Math.max(ans, windowSize);
                j++;
            } else {
                while (mp.size() < windowSize) {
                    char left = s.charAt(i);
                    mp.put(left, mp.get(left) - 1);

                    if (mp.get(left) == 0) {
                        mp.remove(left);
                    }

                    i++;
                    windowSize = j - i + 1;
                }

                if (mp.size() == windowSize) {
                    ans = Math.max(ans, windowSize);
                }

                j++;
            }
        }

        return ans;
    }
}