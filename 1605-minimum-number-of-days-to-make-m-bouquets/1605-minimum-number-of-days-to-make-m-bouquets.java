class Solution {
    public static boolean helperFlower(int currDay,int []bloomDay,int m,int k){
        int n = bloomDay.length;
        int flower = 0;
        for(int i = 0;i<bloomDay.length;i++){
            if(bloomDay[i]<=currDay){
                flower++;
                if(flower==k){
                    m--;
                    flower=0;
                }
            }else{
                flower = 0;
            }
            if(m==0) return true;
        }
        return false;
    }
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        //if no of flower needed is more than available flower
        if(m*k>n) return -1;
        ///finding max
        int right = Integer.MIN_VALUE;
        int left = Integer.MAX_VALUE;
        for(int day:bloomDay){
            right = Math.max(right,day);
            left = Math.min(left,day);
        }
        //if no of flower needed is just equal to number of flower available
        if(m*k==n){
            return right;
        }
        //if no of flowers available is more than no of flower needed

        while (left<right){
            int mid = left+(right-left)/2;
            if(helperFlower(mid,bloomDay,m,k)){
                right = mid;
            }else{
                left = mid+1;
            }
        }
        if(helperFlower(left,bloomDay,m,k)) return left;
        return -1;
    }
}