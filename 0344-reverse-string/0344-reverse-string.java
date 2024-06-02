class Solution {
    public void reverseString(char[] s) {
        int size = s.length;
        int start = 0;
        int end = size-1;
        while(start<end){
            char temp = s[end];
            s[end] = s[start];
            s[start] = temp;
            start++;
            end--;
        }
    }
}