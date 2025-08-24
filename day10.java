import java.util.*;

class AnagramGroup {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            int[] count = new int[26];
            for (char c : s.toCharArray()) {
                count[c - 'a']++;
            }
            // creating unique key
            StringBuilder keyBuilder = new StringBuilder();
            for (int num : count) {
                keyBuilder.append("#").append(num); 
            }
            String key = keyBuilder.toString();

            // Adding words to map
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
        }

        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        AnagramGroup ga = new AnagramGroup();

        String[] input1 = {"eat","tea","tan","ate","nat","bat"};
        String[] input2 = {"abc","bca","cab","xyz","zyx","yxz"};
        String[] input3 = {"a"};

        System.out.println(ga.groupAnagrams(input1));
        System.out.println(ga.groupAnagrams(input2));
        System.out.println(ga.groupAnagrams(input3));
    }
}
