class Solution {
    public int maxProduct(int[] nums) {
        int maxProduct = Integer.MIN_VALUE;
        int productStore[] = new int[nums.length];
        int product = 1;
        for(int i=0;i<nums.length;i++){
            product*=nums[i];
            productStore[i] = product;
            maxProduct = Math.max(product,maxProduct);
            if(product==0) product = 1;
        }
        product = 1;
        for(int i=nums.length-1;i>=0;i--){
            product*=nums[i];
            maxProduct = Math.max(product,maxProduct);
            if(product==0) product = 1;
        }
        return maxProduct;
    }
}