class Solution {
    public static void helper(int[][]land,int[]output,boolean[][]visited,int i,int j){
        if(i<0||i>=land.length||j<0||j>=land[0].length||visited[i][j]||land[i][j]==0) return;
        visited[i][j] = true;
        if(i>=output[2]&&j>=output[3]) {
            output[2] = i;
            output[3] = j;
        }
        helper(land,output,visited,i+1,j);
        helper(land,output,visited,i,j+1);
       
    }
    public int[][] findFarmland(int[][] land) {
        ArrayList<int[]> outputCont = new ArrayList<>();
        int index = 0;
        int row =land.length;
        int column = land[0].length;
        boolean [][]visited = new boolean[row][column];
        for(int i=0;i<row;i++){
            for(int j=0;j<column;j++){
                if(land[i][j]==1&&!visited[i][j]){
                    int []output = new int[4];
                    output[0]=i;
                    output[1]=j;
                    helper(land,output,visited,i,j);
                    outputCont.add(output);
                }
            }
        }
        int sizeofOutputCont = outputCont.size();
        int [][]ans = new int[sizeofOutputCont][4];
        for(int i=0;i<sizeofOutputCont;i++){
            int []copy = outputCont.get(i);
            for(int j=0;j<4;j++){
                ans[i][j] = copy[j];
            }
        }
        return ans;
    }
}