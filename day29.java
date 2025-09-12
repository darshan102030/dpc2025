import java.util.Scanner;
import java.math.BigInteger;

class FibonacciDP {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // Read input: the nth Fibonacci number to compute

        // Call the function to compute Fibonacci and print result
        System.out.println(fibonacci(n));
    }

    // Function to compute nth Fibonacci number using DP
    public static BigInteger fibonacci(int n) {
        // Handle base cases directly
        if (n == 0) return BigInteger.ZERO;
        if (n == 1) return BigInteger.ONE;

        // Create an array to store Fibonacci numbers up to n
        BigInteger[] fib = new BigInteger[n + 1];

        // Initialize the first two Fibonacci numbers
        fib[0] = BigInteger.ZERO;
        fib[1] = BigInteger.ONE;

        // Build the sequence from bottom-up
        for (int i = 2; i <= n; i++) {
            // F(n) = F(n-1) + F(n-2)
            fib[i] = fib[i - 1].add(fib[i - 2]);
        }

        // Return the nth Fibonacci number
        return fib[n];
    }
}
