import java.util.*;

class AnagramsGroup {
    public List<List<String>> anagramsGroup(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            // sorting string
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);

            // adding words
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
        }

        return new ArrayList<>(map.values());
    }
  
    public static void main(String[] args) {
        AnagramsGroup ga = new AnagramsGroup();
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        System.out.println(ga.anagramsGroup(strs));
    }
}
