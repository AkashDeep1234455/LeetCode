class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        HashMap<Double,int[]> map = new HashMap<>();

        for(int i=0;i<arr.length;i++){
            double num = arr[i];
            for(int j=i+1;j<arr.length;j++){
                double num2 = arr[j];
                double val = num/num2;
                int value[] = {arr[i],arr[j]};
                map.put(val, value);
            }
        }
        double []output = new double[map.size()];
        int key = 0;
        for(double val:map.keySet()){
            output[key] = val;
            key++;
        }
        Arrays.sort(output);
        double key2 = output[k-1];
        return map.get(key2);
    }
}