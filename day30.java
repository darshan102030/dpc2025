class CoinChange {
    public int coinChange(int[] coins, int amount) {
        // Create DP array and initialize with amount+1 (impossible high value)
        int[] dp = new int[amount + 1];
        for (int i = 1; i <= amount; i++) {
            dp[i] = amount + 1;
        }
        dp[0] = 0; // base case

        // Fill the dp array
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }

    // Example usage and test cases
    public static void main(String[] args) {
        CoinChange cc = new CoinChange();

        System.out.println(cc.coinChange(new int[]{1, 2, 5}, 11)); // Output: 3
        System.out.println(cc.coinChange(new int[]{2}, 3));        // Output: -1
        System.out.println(cc.coinChange(new int[]{1}, 0));        // Output: 0
    }
}
