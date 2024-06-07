class TrieNode{
    char data;
    boolean isTerminating;
    TrieNode []children;
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
    public Trie(){
        root = new TrieNode('\0');
    }
    private void add(TrieNode root,String word){
        if(word.length()==0){
            root.isTerminating = true;
            return;
        }
        int childIndex = word.charAt(0) - 'a';       //subtracting ASCII value of a from the   word at 0 index will give index value of that word
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
     private String shortestCommonPrefix(TrieNode root,String word,StringBuilder output){
        if(word.length()==0) return "";
        if(root.isTerminating){
            return output.toString();
        }
        int childIndex = word.charAt(0)-'a';
        TrieNode child = root.children[childIndex];
        if(child==null){
            return "";
        }
        output.append(child.data);
        return shortestCommonPrefix(child,word.substring(1),output);
    }
    public String shortestCommonPrefix(String word){return shortestCommonPrefix(root,word,new StringBuilder(""));}
}


class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        int length = sentence.length();
        Trie newTrie = new Trie();
        StringBuilder output = new StringBuilder();
        for(String word:dictionary){
            newTrie.add(word);
        }
        StringBuilder curr = new StringBuilder();
        for(int i=0;i<length;i++){
            char c = sentence.charAt(i);
            if(c==' '||i==length-1){
                if(i==length-1) curr.append(c);
                String rootWord = newTrie.shortestCommonPrefix(curr.toString());
                if(rootWord=="") output.append(new StringBuilder(curr)+" ");
                else output.append(new StringBuilder(rootWord)+" ");
                curr = new StringBuilder();
            }else  curr.append(c);
        }
        output.deleteCharAt(output.length()-1);
        return output.toString();
    }
}