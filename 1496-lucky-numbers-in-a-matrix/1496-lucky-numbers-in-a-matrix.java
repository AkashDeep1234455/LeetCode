class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        HashMap<Integer,Integer>min = new HashMap<>();
        HashMap<Integer,Integer>max = new HashMap<>();
        for(int i=0;i<matrix.length;i++){
            int[] curr =matrix[i];
            int minN = Integer.MAX_VALUE;
            for(int j=0;j<curr.length;j++){
                minN = Math.min(minN,curr[j]);
            }
            min.put(i,minN);
        }
        for(int i=0;i<matrix[0].length;i++){
            int maxN = Integer.MIN_VALUE;
            for(int j=0;j<matrix.length;j++){
                maxN= Math.max(maxN,matrix[j][i]);
            }
            max.put(i,maxN);
        }
        List<Integer> output = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == min.get(i) && matrix[i][j] == max.get(j)) {
                    output.add(matrix[i][j]);
                }
            }
        }

        return output;
    }
}