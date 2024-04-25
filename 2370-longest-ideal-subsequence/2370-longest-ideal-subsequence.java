class Solution {
    public int longestIdealString(String s, int k) {
        int dp[] = new int[26];
      int ans = 1;
      for(int i=0;i<s.length();i++){
          int index = s.charAt(i)-'a';
          for(int j=index;j>=0&&j>=index-k;j--){
              dp[index] = Math.max(dp[index],dp[j]+1);
          }
          for(int j=index+1;j<26&&j<=index+k;j++){
              dp[index] = Math.max(dp[index],dp[j]+1);
          }
          ans= Math.max(ans,dp[index]);
      }
      return ans;
    }
}