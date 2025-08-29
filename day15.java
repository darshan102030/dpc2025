import java.util.*;
class LongestSubstring {
    public static int lengthOfLongestSubstring(String s) {
        // HashSet to store unique characters in the current window
        Set<Character> set = new HashSet<>();

        int left = 0, right = 0, maxLen = 0;

        // Expand the window by moving right pointer
        while (right < s.length()) {
            char c = s.charAt(right);

            // If duplicate found, shrink window from the left
            while (set.contains(c)) {
                set.remove(s.charAt(left));
                left++;
            }

            // Add the current character to the window
            set.add(c);

            // Update max length
            maxLen = Math.max(maxLen, right - left + 1);

            // Move right pointer
            right++;
        }

        return maxLen;
    }

    public static void main(String[] args) {
        String s1 = "abcabcbb";
        String s2 = "bbbbb";
        String s3 = "pwwkew";

        System.out.println(lengthOfLongestSubstring(s1)); // 3 ("abc")
        System.out.println(lengthOfLongestSubstring(s2)); // 1 ("b")
        System.out.println(lengthOfLongestSubstring(s3)); // 3 ("wke")
    }
}
