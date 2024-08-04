class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {
        List<Integer> sumValue = new ArrayList<>();
        for(int i=0;i<n;i++){
            int sum = 0;
            for(int j=i;j<n;j++){
                sum+=nums[j];
                sumValue.add(sum);
            }
        }
        Collections.sort(sumValue);
        int output = 0;
        int modulo = (int)Math.pow(10,9)+7;
        for(int i=left-1;i<right;i++){
            output=(output+sumValue.get(i))%modulo;
        }
        return output;
    }
}