class Solution {
    public int countTriplets(int[] arr) {
        int count = 0,size = arr.length;
        int []prefixXor = new int[size+1];
        for(int i=0;i<size;i++) prefixXor[i+1] = prefixXor[i]^arr[i];

        for(int i=0;i<size;i++){
            for(int j=i+1;j<size;j++){
                if (prefixXor[i]==prefixXor[j+1]) count+=j-i;
            }
        }
        return count;
    }
}