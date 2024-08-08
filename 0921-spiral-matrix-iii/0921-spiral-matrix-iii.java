class Solution {
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
         List<int[]> list = new LinkedList<>();
        int directions[][] = {{0,1},{1,0},{0,-1},{-1,0}};
        boolean[][] visited = new boolean[rows][cols];
        int currDirection = 0;
        int steps = 1;

        int totalBox = rows * cols;
        int[] location = new int[]{rStart, cStart};
        visited[rStart][cStart] = true;
        list.add(location);
        totalBox--;
        while (totalBox >0) {
            for(int i=0;i<2;i++){
                for(int j=0;j<steps;j++){
                    rStart +=directions[currDirection][0];
                    cStart +=directions[currDirection][1];
                    if(rStart>=0&&rStart<rows&&cStart>=0&&cStart<cols){
                        list.add(new int[] {rStart, cStart});
                        visited[rStart][cStart] = true;
                        totalBox--;
                    }
                }
                currDirection = (currDirection+ 1) % 4;
            }
            steps+=1;
        }
        return list.toArray(new int[list.size()][]);
    }
}