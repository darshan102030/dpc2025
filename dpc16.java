class LCMofTwoNumbers {

    // Function to find GCD using Euclidean Algorithm
    static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;  // remainder
            a = temp;
        }
        return a;
    }

    // Function to find LCM
    static int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }

    public static void main(String[] args) {
        int N = 4, M = 6;

        int result = lcm(N, M);

        System.out.println("LCM of " + N + " and " + M + " is: " + result);
    }
}
