class Solution {
    public void rotate(int[][] matrix) {
        List<List<Integer>> value = new LinkedList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        for(int i=0;i<m;i++){
            List<Integer> entry = new LinkedList<>();
            for(int j=0;j<n;j++){
                entry.add(matrix[i][j]);
            }
            value.add(entry);
        }
        int index = n-1;
        for(int i=0;i<value.size();i++){
            List<Integer> entry = value.get(i);
            int index2 = 0;
            for(int j=0;j<entry.size();j++){
                matrix[index2][index] = entry.get(j);
                index2++;
            }
            index--;
        }
    }
}