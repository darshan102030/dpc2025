class LCMofTwoNumbers {

    static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b; 
            a = temp;
        }
        return a;
    }

    static int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }

    public static void main(String[] args) {
        int N = 4, M = 6;

        int result = lcm(N, M);

        System.out.println("LCM is : " + result);
    }
}
