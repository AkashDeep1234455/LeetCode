class Solution {
    public int maximumSum(int[] nums) {
        int n= nums.length;
        int digitSum[] = new int[n];
        for(int i=0;i<n;i++){
            int curr = nums[i];
            int sum = 0;
            while(curr!=0){
                int rem = curr%10;
                sum+=rem;
                curr=curr/10;
            }
            digitSum[i] = sum;
        }

        HashMap<Integer,int[]> map = new HashMap<>();
        for(int i=0;i<n;i++){
            int sum = digitSum[i];
            int num = nums[i];
            if (!map.containsKey(sum)) {
                map.put(sum, new int[] {num, Integer.MIN_VALUE});
            } else {
                int[] top2 = map.get(sum);
                if (num > top2[0]) {
                    top2[1] = top2[0];
                    top2[0] = num;
                } else if (num > top2[1]) {
                    top2[1] = num;
                }
            }
        }
        int output = -1;
         for (int[] top2 : map.values()) {
            if (top2[1] != Integer.MIN_VALUE) {
                output = Math.max(output, top2[0] + top2[1]);
            }
        }
        return output;
    }
}