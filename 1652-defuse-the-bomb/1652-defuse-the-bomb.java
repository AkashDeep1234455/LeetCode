class Solution {
    public int[] decrypt(int[] code, int k) {
        int n = code.length;
        if(k==0){
            int ans[] =new int[n];
            for(int i=0;i<n;i++){
                ans[i] = 0;
            }
            return ans;
        }
        int ans[] = new int[n];
        for(int i=0;i<n;i++){
            if(k>0){
                int index = i+1;
                if(i==n-1) index = 0;
                int count = 0;
                int newSum=0;
                while(count!=k){
                    if(index==n) index = 0;
                    newSum += code[index];
                    count++;
                    index++;
                }
                ans[i] = newSum;
            }else{
                int index = i-1;
                if(i==0) index = n-1;
                int count = 0;
                int newSum=0;
                int comp = Math.abs(k);
                while(count!=comp){
                    newSum += code[index];
                    count++;
                    index--;
                    if(index<0) index = n-1;
                }
                ans[i] = newSum;
            }
        }
        return ans;

    }
}