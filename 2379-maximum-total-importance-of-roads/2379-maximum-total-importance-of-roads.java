class Solution {
    public long maximumImportance(int n, int[][] roads) {
        long arr[] = new long[n];
        for(int i=0;i<roads.length;i++){
            arr[roads[i][0]]++;
            arr[roads[i][1]]++;
        }

        Arrays.sort(arr);
        int value = 1;
        long output = 0;
        for(int i=0;i<n;i++){
            output+= arr[i]*value;
            value++;
        }
        return output;
    }
}