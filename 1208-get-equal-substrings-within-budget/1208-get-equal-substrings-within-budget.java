class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
         int size = s.length();
        int asciiChange[] = new int[size];
        for(int i=0;i<size;i++){
            asciiChange[i] = Math.abs(s.charAt(i)-t.charAt(i));
        }
        int currCost = 0;
        int maxCount =0;
        int start = 0;
        for(int i=0;i<size;i++){
            currCost+=asciiChange[i];
            while (currCost>maxCost){
                currCost-=asciiChange[start];
                start++;
            }
            maxCount = Math.max(maxCount,i-start+1);
        }
        return maxCount;
    }
}