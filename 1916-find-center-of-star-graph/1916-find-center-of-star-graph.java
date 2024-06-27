class Solution {
    public int findCenter(int[][] edges) {
         int n=0;
         int size = edges.length;
         for(int i=0;i<size;i++){
             n = Math.max(n,Math.max(edges[i][1],edges[i][0]));
         }
         int arr[] = new int[n+1];
         for(int i=0;i<size;i++){
             arr[edges[i][1]]++;
             arr[edges[i][0]]++;
         }
         int output = 0;
         int index = 0;
         for(int i=0;i<=n;i++){
             if(arr[i]>output){
                 output = arr[i];
                 index = i;
             }
         }
         return index;
    }
}