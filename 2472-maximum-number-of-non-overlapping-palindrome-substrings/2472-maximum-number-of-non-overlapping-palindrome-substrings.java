class Solution {
    public int maxPalindromes(String s, int k) {

        int n = s.length();

        // pal[i][j] = true if s.substring(i, j + 1) is palindrome
        boolean[][] pal = new boolean[n][n];

        // Build palindrome table
        for (int len = 1; len <= n; len++) {

            for (int i = 0; i + len - 1 < n; i++) {

                int j = i + len - 1;

                if (len == 1) {
                    pal[i][j] = true;
                }
                else if (len == 2) {
                    pal[i][j] = (s.charAt(i) == s.charAt(j));
                }
                else {
                    pal[i][j] =
                        (s.charAt(i) == s.charAt(j)) &&
                        pal[i + 1][j - 1];
                }
            }
        }

        // dp[i] = maximum palindromes using first i characters
        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {

            // Don't choose a palindrome ending at i-1
            dp[i] = dp[i - 1];

            // Try every possible starting position
            for (int start = 0; start < i; start++) {

                int len = i - start;

                if (len >= k && pal[start][i - 1]) {
                    dp[i] = Math.max(
                        dp[i],
                        dp[start] + 1
                    );
                }
            }
        }

        return dp[n];
    }
}