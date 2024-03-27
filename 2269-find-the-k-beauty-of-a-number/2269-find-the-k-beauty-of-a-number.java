class Solution {
    public int divisorSubstrings(int num, int k) {
        int noOfDigits = 0;
        int numCopy = num;
        while(num!=0){
            num = num/10;
            noOfDigits++;
        }
        int newCopy = numCopy;
        int arr[] = new int[noOfDigits];
        for(int i=noOfDigits-1;i>=0;i--){
            arr[i] = newCopy%10;
            newCopy = newCopy/10;
        }
        int left = 0;
        int right = k-1;
        int count = 0;
        while(right!=noOfDigits){
            int value = 0;
            int multiply = 1;
            for(int i=right;i>=left;i--){
                value+=arr[i]*multiply;
                multiply = multiply*10;
            }
            if(value!=0&&numCopy%value==0) count++;
            left++;
            right++;
        }
        return count;
    }
}