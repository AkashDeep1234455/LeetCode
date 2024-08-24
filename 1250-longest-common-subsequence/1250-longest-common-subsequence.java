class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] output = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            char curr = text1.charAt(i - 1);
            for (int j = 1; j <= n; j++) {
                if (curr == text2.charAt(j - 1)) {
                    output[i][j] = output[i - 1][j - 1] + 1;
                } else {
                    output[i][j] = Math.max(output[i - 1][j], output[i][j - 1]);
                }
            }
        }
        return output[m][n];
    }
}
