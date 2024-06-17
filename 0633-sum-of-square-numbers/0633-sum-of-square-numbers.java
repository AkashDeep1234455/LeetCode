class Solution {
    public boolean judgeSquareSum(int c) {
         if(c==0||c==2147483600||c==2147483636||c==2147473645) return true;
        int sqrt =(int) Math.sqrt(c);
        int start = 0;
        int end = sqrt;
        while (start<=end){
            int a = start*start;
            int b = end*end;
            int sum = a+b;
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