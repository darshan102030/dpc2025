import java.util.*;

class Greatest_Element_In_Window {

    public static void greatElementInWindow(int[] arr, int k) {
        int n = arr.length;
        if (k > n) {
            System.out.println("Window size is bigger than Array");
            return;
        }

        Deque<Integer> dq = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            // Removing indices of elements not in current window
            while (!dq.isEmpty() && dq.peekFirst() <= i - k) {
                dq.pollFirst();
            }

            // Removing indices of all elements smaller than current
            while (!dq.isEmpty() && arr[dq.peekLast()] < arr[i]) {
                dq.pollLast();
            }

            // Adding current element's index to deque
            dq.offerLast(i);

            // Printing max of current window
            if (i >= k - 1) {
                System.out.print(arr[dq.peekFirst()] + " ");
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = { 1, 3, -1, -3, 5, 3, 6, 7 };
        int k = 3;
        greatElementInWindow(arr, k);
    }
}
