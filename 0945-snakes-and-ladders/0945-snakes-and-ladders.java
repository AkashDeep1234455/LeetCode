class Solution {
    public int snakesAndLadders(int[][] board) {
        boolean forward = true;
        int n = board.length;
        int val1 = 1;
        HashMap<Integer,int[]> map = new HashMap<>();
        for(int i=n-1;i>=0;i--){
            if(forward){
                for(int j=0;j<board.length;j++){
                    map.put(val1++,new int[]{i,j});
                }
                forward = !forward;
            }else{
                for(int j=board.length-1;j>=0;j--){
                     map.put(val1++,new int[]{i,j});
                }
                forward = !forward;
            }
        }

        int visited[] = new int[n*n+1];
        Queue<Integer> pending =new LinkedList<>();
        int ans = 0;
        pending.add(1);
        visited[1] = 1;
        while(!pending.isEmpty()){
            int size = pending.size();
            for(int i=0;i<size;i++){
                int curr = pending.poll();
                if(curr==n*n) return ans;
                int from = curr+1;
                int to = Math.min(curr+6,n*n);
                for(int j=from;j<=to;j++){
                    int arr[] = map.get(j);
                    int val = board[arr[0]][arr[1]];
                    int next = val!=-1?val:j;
                    if(visited[next]==0){
                        pending.add(next);
                        visited[next] = 1; 
                    }
                }
            }
            ans++;
        }
        return -1;

    }
}