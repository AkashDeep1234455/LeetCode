

import java.util.Arrays;

public class DisjointSet {
    private int parent[];
    private int component;
    public DisjointSet(int n){
         parent = new int[n+1];
         component = n;
         Arrays.fill(parent,-1);
    }
    private int find(int n){
        if(this.parent[n]<0) return n;
        return this.parent[n] = find(parent[n]);
    }
    public int union(int u,int v){
        int uParent = find(u);
        int vParent  =find(v);
        if(uParent==vParent) return 0;
        else{
            int weightU = Math.abs(parent[uParent]);
            int weightV = Math.abs(parent[vParent]);
            if(weightU>=weightV) {
                parent[vParent] = uParent;
                parent[uParent]-=weightV;
            }else{
                parent[uParent] = vParent;
                parent[vParent]-=weightU;
            }
        }
        component--;
        return 1;
    }

    public int getSize() {
        return parent.length - 1;
    }

    public boolean isConnected() {
      return component == 1;
    }


}


class Solution {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        DisjointSet alice = new DisjointSet(n);
        DisjointSet bob = new DisjointSet(n);
        int required = 0;
        for(int []edge:edges){
            if(edge[0]==3){
                required+=(alice.union(edge[1],edge[2])|bob.union(edge[1],edge[2]));
            }
        }
        for(int edge[]:edges){
            if(edge[0]==1){
                required+=alice.union(edge[1],edge[2]);
            }else if(edge[0]==2){
                required+=bob.union(edge[1],edge[2]);
            }
        }
        if(alice.isConnected() && bob.isConnected()) {
            return edges.length - required;
        }
        return -1;
    }
}