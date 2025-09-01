class DivisorCount {
    
    public static int countDivisors(int n) {
        int count = 0;

        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {

              //square number
                if (i == n / i) {
                    count++; 
                } else {
                    count += 2;  //pair {(1,12),(2,6)..}
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int n = 12;
        int divisors = countDivisors(n);
        System.out.println("Number of divisors : "+ divisors);
    }
}
