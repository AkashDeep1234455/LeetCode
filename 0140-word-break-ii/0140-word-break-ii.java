class TrieNode{
    char data;
    boolean isTerminating;
    TrieNode[] children;
    int childCount;

    public TrieNode(char data){
        this.data = data;
        isTerminating = false;
        children = new TrieNode[26];
        childCount = 0;
    }
}

class Trie{
    private TrieNode root;
    public Trie(){ root = new TrieNode('\0');}
    private void add(TrieNode root,String word){
        if(word.length()==0){
            root.isTerminating = true;
            return;
        }
        int childIndex = word.charAt(0) - 'a';
        TrieNode child = root.children[childIndex];
        if(child==null){
            child = new TrieNode(word.charAt(0));
            root.children[childIndex] = child;
            root.childCount++;
        }
        add(child,word.substring(1));
    }
    public void add(String word){
        add(root,word);
    }


    private boolean charSearch(TrieNode root,char c){
        int charIndex = c - 'a';
        TrieNode child = root.children[charIndex];
        if(child == null) return false;
        return true;
    }
    public boolean charSearch(char c){
        return charSearch(root,c);
    }
     private void wordSearch(TrieNode root,List<String> words, String currWord,char c){
        currWord = currWord+c;
        if(root.isTerminating) words.add(currWord);
        for(int i=0;i<26;i++){
            TrieNode child = root.children[i];
            if(child!=null){
               wordSearch(child,words,currWord, child.data);
            }
        }
    }
    public List<String> wordSearch(char c){
        List<String> words = new ArrayList<>();
        int childIndex = c-'a';
        TrieNode child = root.children[childIndex];
        if(child!=null) {
            wordSearch(child, words, "", c);
        }
        return words;
    }
}


class Solution {
    public static boolean wordMatch(String s,String word,int start){
        int totalLength = start+word.length();
        if(totalLength>s.length()) return false;
        for(int i=start;i<totalLength;i++){
            if(s.charAt(i)!=word.charAt(i-start)) return false;
        }
        return true;
    }
    public static void wordBreakHelper(String s,List<String> ans,String inputSentence,String currWord,int start,Trie newTrie){
        if(inputSentence.length()==0) inputSentence += currWord;
        else inputSentence+= " "+currWord;
        if(start>=s.length()){
            ans.add(inputSentence);
            return;
        }
        List<String> words = newTrie.wordSearch(s.charAt(start));
        if(words==null) return;
        for(String word:words){
            int length = word.length();
            if(wordMatch(s,word,start)) {
                wordBreakHelper(s, ans, inputSentence, word, start + length, newTrie);
            }
        }
    }
    public List<String> wordBreak(String s, List<String> wordDict) {
        Trie newTrie =new Trie();
        for(String word:wordDict){
            newTrie.add(word);
        }
        List<String> ans = new ArrayList<>();
        wordBreakHelper(s,ans,"","",0,newTrie);
        return ans;
    }
}