class Solution {
    public boolean judgeSquareSum(int c) {
        int end =(int) Math.sqrt(c);
        int start = 0;
        while (start<=end){
            long sum = (long)(start*start)+(long)(end*end);
            if(sum==c) return true;
            else if (sum>c) {
                end--;
            }else{
                start++;
            }
        }
        return false;
    }
}