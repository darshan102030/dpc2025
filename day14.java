import java.util.*;
class CountKDistinctSubstrings {

    private static int atMostKDistinct(String s, int k) {
        int n = s.length();
        int left = 0, count = 0;
        Map<Character, Integer> freq = new HashMap<>();

        for (int right = 0; right < n; right++) {
            char ch = s.charAt(right);
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);

            while (freq.size() > k) {
                char leftChar = s.charAt(left);
                freq.put(leftChar, freq.get(leftChar) - 1);
                if (freq.get(leftChar) == 0) {
                    freq.remove(leftChar);
                }
                left++;
            }
            count += (right - left + 1);
        }

        return count;
    }
    public static int exactlyKDistinct(String s, int k) {
        return atMostKDistinct(s, k) - atMostKDistinct(s, k - 1);
    }


    public static void main(String[] args) {
        String s = "pqpqs";
        int k = 2;
        System.out.println("Count: " + exactlyKDistinct(s, k)); // Output: 7
    }
}
