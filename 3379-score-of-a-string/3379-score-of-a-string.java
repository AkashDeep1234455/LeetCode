class Solution {
    public int scoreOfString(String s) {
        int pointer1 = 0;
        int pointer2 = 1;
        int sum = 0;
        while(pointer2!=s.length()){
            sum+=Math.abs(s.charAt(pointer1)-s.charAt(pointer2));
            pointer1++;
            pointer2++;
        }
        return sum;
    }
}