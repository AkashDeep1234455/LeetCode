class Solution {
     public static int helper(int i,int pos,String ring,char[]key,List<Integer> []index,int dp[][]){
        if(i==key.length) return 0;
        if(dp[i][pos]>0) return dp[i][pos];
        int minimum = Integer.MAX_VALUE;
        char target = key[i];
        List<Integer> possiblepositions = index[target-'a'];
        for(int allPos:possiblepositions){
            int step = Math.min(Math.abs(allPos-pos),ring.length()-(Math.abs(allPos-pos)));
            int totalSteps = step+helper(i+1,allPos,ring,key,index,dp);
            minimum = Math.min(totalSteps,minimum);
        }
        return dp[i][pos] = minimum;
    }
    public int findRotateSteps(String ring, String key) {
        List<Integer> arr[] = new List[26];
        for(int i=0;i<ring.length();i++){
            int index = ring.charAt(i)-'a';
            if(arr[index]==null) arr[index] = new ArrayList<>();
            arr[index].add(i);
        }
        return helper(0,0,ring,key.toCharArray(),arr,new int[key.length()][ring.length()])+key.length();
    }
}