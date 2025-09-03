import java.util.Stack;

class SortStackRecursion {

    // Function to sort the stack
    public static void sortStack(Stack<Integer> stack) {
        if (!stack.isEmpty()) {
            // Step 1: Pop the top element
            int top = stack.pop();

            // Step 2: Sort the remaining stack
            sortStack(stack);

            // Step 3: Insert the popped element back in sorted order
            insertInSortedOrder(stack, top);
        }
    }

    // Helper function to insert element into sorted stack
    private static void insertInSortedOrder(Stack<Integer> stack, int value) {
        // If stack is empty OR top element <= value → push value
        if (stack.isEmpty() || stack.peek() <= value) {
            stack.push(value);
            return;
        }

        // Otherwise, pop top and recurse
        int top = stack.pop();
        insertInSortedOrder(stack, value);

        // Push back the popped element
        stack.push(top);
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.push(1);
        stack.push(4);
        stack.push(2);

        System.out.println("Original Stack: " + stack);

        sortStack(stack);

        System.out.println("Sorted Stack: " + stack);
    }
}
