class Solution {
     public static int scoreCalculator(String word,int[] letterMap,int[] score){
        int scoreOfword = 0;
        for(int i=0;i<word.length();i++){
            char curr = word.charAt(i);
            int index = curr-'a';
            if(letterMap[index]==0) return -1;
            scoreOfword+=score[index];
        }
        return scoreOfword;
    }

    public static void maxScoreWordsHelper(String[]words, char[] letters,int[] score,HashMap<String,Integer> map,int[]letterMap,int[] maxScore,int start,int currScore){
        maxScore[0] = Math.max(currScore,maxScore[0]);
        for(int i=start;i<words.length;i++){
            String currWord = words[i];
            if(!map.containsKey(currWord)) continue;
            boolean canForm = true;
            Stack<Character> changed = new Stack<>();
            for(int j=0;j<currWord.length();j++){
                char currChar = currWord.charAt(j);
                int index = currChar-'a';
                if(letterMap[index]>0){
                    changed.push(currChar);
                    letterMap[index]--;
                }
                else {
                    canForm= false;
                    break;
                }
            }
            if(canForm) {
                currScore = currScore + map.get(currWord);
                maxScoreWordsHelper(words, letters, score, map, letterMap, maxScore, i+1, currScore);
                currScore = currScore - map.get(currWord);
            }
            while (!changed.isEmpty()){
                char curr = changed.pop();
                int index = curr -'a';
                letterMap[index]++;
            }
        }
    }
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        int letterMap[] = new int[26];
        Arrays.fill(letterMap,0);
        for(char letter:letters){
            int index = letter-'a';
            letterMap[index]++;
        }
        HashMap<String,Integer> map = new HashMap<>();
        for(int i=0;i<words.length;i++){
            String currWord = words[i];
            int scoreOfword = scoreCalculator(currWord,letterMap,score);
            if (scoreOfword!=-1) {
                map.put(currWord, scoreOfword);
            }
        }
        int maxScore[] = new int[1];
        maxScoreWordsHelper(words,letters,score,map,letterMap,maxScore,0,0);
        return maxScore[0];
    }
}