class Solution {
    public int heightChecker(int[] heights) {
       int expected[] = Arrays.copyOfRange(heights,0,heights.length);
       Arrays.sort(expected);
       int count=0;
       for(int i=0;i<expected.length;i++){
           if(expected[i]!=heights[i]) count++;
       }
       return count;
    }
}