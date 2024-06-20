class Solution {
     public static boolean canPlaceBall(int []position,int m,int mid){
        m = m-1;
        int lastPosition = position[0];
        for(int i=1;i<position.length;i++){
            if(position[i]-lastPosition>=mid){
                m--;
                lastPosition = position[i];
                if(m==0) return true;
            }
        }
        return false;
    }
    public int maxDistance(int[] position, int m) {
          Arrays.sort(position);
        int left = 1;
        int right = position[position.length-1] - position[0];
        int output = 0;
        while(left<=right){
            int mid = left + (right-left)/2;
            if(canPlaceBall(position,m,mid)){
                output = mid;
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        return output;
    }
}