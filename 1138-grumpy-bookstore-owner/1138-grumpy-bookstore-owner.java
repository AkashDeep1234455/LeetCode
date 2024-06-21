class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int length = customers.length;
        int sum = 0;
        boolean notGrumpy[] = new boolean[length];
        for(int i=0;i<length;i++){
            if(grumpy[i]==0){
                sum+=customers[i];
                notGrumpy[i] = true;
            }
        }
        int start = 0;
        int end = minutes-1;
        int output = sum;
        while(end<length){
            int copySum = 0;
            for(int i=start;i<=end;i++){
                if(!notGrumpy[i]){
                    copySum+=customers[i];
                }
            }
            output = Math.max(output,(sum+copySum));
            start++;
            end++;
        }
        return output;
    }
}