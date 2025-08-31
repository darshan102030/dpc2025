import java.util.*;

class PrimeFactorization {
    
    public static List<Integer> primeFactors(int n) {
        List<Integer> factors = new ArrayList<
          
        while (n % 2 == 0) {
            factors.add(2);
            n /= 2;
        }

        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            while (n % i == 0) {
                factors.add(i);
                n /= i;
            }
        }

        if (n > 2) {
            factors.add(n);
        }

        return factors;
    }

    public static void main(String[] args) {
        int n = 18;
        List<Integer> result = primeFactors(n);
        System.out.println("Prime factors of n: " + result);
    }
}
