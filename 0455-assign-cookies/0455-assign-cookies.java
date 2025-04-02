class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int cookie = 0;
        int output = 0;
        for(int i=0;i<g.length;i++){
            while(output<s.length&&s[output]<g[i]){
                output++;
            }
            if(output>=s.length) break;
            if(s[output]>=g[i]){
                cookie++;
                output++;
            }
        }
        return cookie;
    }
}