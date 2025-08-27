class LongestPalindromicSubstring {

    // Method to find longest palindromic substring
    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        
        int start = 0, end = 0; // boundaries of the longest palindrome
        
        for (int i = 0; i < s.length(); i++) {
            // Odd length palindrome (center at i)
            int len1 = expandAroundCenter(s, i, i);
            
            // Even length palindrome (center between i and i+1)
            int len2 = expandAroundCenter(s, i, i + 1);
            
            int len = Math.max(len1, len2);
            
            if (len > end - start) {
                // update start & end based on expanded palindrome length
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        
        return s.substring(start, end + 1);
    }
    
    // Helper function to expand from center
    private static int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1; // length of palindrome
    }

    // Main method to test
    public static void main(String[] args) {
        String s1 = "babad";
        String s2 = "cbbd";
        String s3 = "a";
        String s4 = "forgeeksskeegfor";
        
        System.out.println("Input: " + s1 + " → Longest Palindrome: " + longestPalindrome(s1));
        System.out.println("Input: " + s2 + " → Longest Palindrome: " + longestPalindrome(s2));
        System.out.println("Input: " + s3 + " → Longest Palindrome: " + longestPalindrome(s3));
        System.out.println("Input: " + s4 + " → Longest Palindrome: " + longestPalindrome(s4));
    }
}
