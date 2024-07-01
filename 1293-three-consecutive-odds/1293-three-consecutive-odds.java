class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        for(int i=0;i<arr.length;i++){
            if(arr[i]%2!=0&&i+2<arr.length){
                int count=0;
                for(int j=i;j<=i+2;j++){
                    if(arr[j]%2!=0) count++;
                    else break;
                }
                if(count==3) return true;
            }
        }
        return false;
    }
}