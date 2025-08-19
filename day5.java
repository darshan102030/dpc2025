import java.util.*;

public class LeaderInArray {
    public static List<Integer> findLeaders(int[] arr) {
        List<Integer> leaders = new ArrayList<>();
        int n = arr.length;
        
        int maxRight = arr[n - 1];
        leaders.add(maxRight); // no element to the right of last element so last element will always be leader

        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] > maxRight) {
                leaders.add(arr[i]); // if found greater element adding it to leader list
                maxRight = arr[i];
            }
        }

        Collections.reverse(leaders); //reversing the list
        return leaders;
    }

    public static void main(String[] args) {
        int[] arr = {16, 17, 4, 3, 5, 2};
        List<Integer> result = findLeaders(arr);
        System.out.println("Leaders:" + result);

        int[] arr1 = {7, 10, 4, 10, 6, 5, 2};
        List<Integer> result1 = findLeaders(arr1);
        System.out.println("Leaders:" + result1);
    }
}
