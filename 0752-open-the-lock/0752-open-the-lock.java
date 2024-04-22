class Solution {
     public static char charIncrement(char c){
        return c=='9'?'0':(char)(c+1);
    }
    public static char charDecrement(char c){
        return c=='0'?'9':(char) (c-1);
    }
    public int openLock(String[] deadends, String target) {
          HashSet<String> seen = new HashSet<>(Arrays.asList(deadends));
        if(seen.contains("0000")) return -1;
        if(target.equals("0000")) return 0;
        Queue<String> pendingComb = new LinkedList<>();
        pendingComb.add("0000");
        int step =0;
        while (!pendingComb.isEmpty()){
            int size = pendingComb.size();
            for(int i=0;i<size;i++){
                String curr = pendingComb.poll();
                if(curr.equals(target)) return step;
                for(int j=0;j<4;j++){
                    char[] arr1 = curr.toCharArray();
                    arr1[j] = charIncrement(arr1[j]);
                    String next1 = new String(arr1);
                    if(!seen.contains(next1)){
                        seen.add(next1);
                        pendingComb.add(next1);
                    }
                    char[] arr2 = curr.toCharArray();
                    arr2[j] = charDecrement(arr2[j]);
                    String next2 = new String(arr2);
                    if(!seen.contains(next2)){
                        seen.add(next2);
                        pendingComb.add(next2);
                    }
                }
            }
            step++;
        }
        return -1;
    }
}