class Solution {
    public String reversePrefix(String word, char ch) {
        StringBuilder reverse = new StringBuilder();
        char []words = word.toCharArray();
        int index = 0;
        for(char w:words){
            reverse.append(w);
            if(w==ch) break;
            index++;
        }
        if(index==word.length()) return word;
        reverse = reverse.reverse();
        for(int i = index+1;i<word.length();i++) reverse.append(word.charAt(i));
        return reverse.toString();
    }
}