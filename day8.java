class Solution {
    public String reverseWords(String s) {
        int n = s.length();
        StringBuilder result = new StringBuilder();

        int i = n - 1;
        while (i >= 0) {
            // Skip spaces
            while (i >= 0 && s.charAt(i) == ' ') i--;

            if (i < 0) break;

            // Mark end of word
            int j = i;

            // Find start of word
            while (i >= 0 && s.charAt(i) != ' ') i--;

            // Append word
            result.append(s.substring(i + 1, j + 1)).append(" ");
        }

        // Remove trailing space
        return result.toString().trim();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.reverseWords("the sky is blue"));
        System.out.println(sol.reverseWords("  hello world  "));  
        System.out.println(sol.reverseWords("    "));             
    }
}
