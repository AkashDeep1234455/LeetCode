class Word{
    private char letter;
    private int count;
    public Word(char letter,int count){
        this.letter = letter;
        this.count = count;
    }
    public void incCount(){
        this.count+=1;
    }
    public int getCount(){
        return this.count;
    }
    public char letter(){
        return this.letter;
    }
}

class Solution {
    public int minimumPushes(String word) {
        if(word.length()<=8) return word.length();
        Word arr[] = new Word[26];
        int special = 0;
        for(int i=0;i<word.length();i++){
            char curr = word.charAt(i);
            int index = curr-'a';
            if(curr=='1'||curr=='*'||curr=='0'||curr=='#'){
                special++;
                continue;
            }
            if(arr[index]==null){
                Word newEntry = new Word(curr,1);
                arr[index] = newEntry;
            }else{
                Word existingEntry = arr[index];
                existingEntry.incCount();
            }            
        }
        Word[] filteredArr = Arrays.stream(arr)
                                   .filter(w -> w != null)
                                   .toArray(Word[]::new);

        Arrays.sort(filteredArr,Comparator.comparingInt(Word::getCount).reversed());
        int availablePosition = 8;
        boolean[] position = new boolean[4];
        int output = 0;
        for(int i=0;i<filteredArr.length;i++){
            Word curr = filteredArr[i];
            char chara = curr.letter();
            int count= curr.getCount();
            if(availablePosition!=0){
                int available=0;
                for(int j=0;j<4;j++){
                    if(position[j]==false){
                        available=j;
                        break;
                    }
                }
                output+=((available+1)*count);
                availablePosition--;
                if(availablePosition==0){
                    position[available]=true;
                    availablePosition=8;
                }
            }
        }

        return output;
    }
}