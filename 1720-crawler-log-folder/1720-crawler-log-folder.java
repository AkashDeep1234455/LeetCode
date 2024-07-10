class Solution {
    public int minOperations(String[] logs) {
        int numOfOperations = 0;
        for(int i=0;i<logs.length;i++){
            String curr = logs[i];
            if(curr.equals("../")){
                if(numOfOperations!=0) numOfOperations--;
            }else if(curr.equals("./")) continue;
            else numOfOperations++;
        }
        return numOfOperations;
    }
}