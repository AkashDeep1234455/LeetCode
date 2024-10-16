class TrieNode{
    public char data;
    public boolean isTerminating;
    public TrieNode[] children;
    public int childCount;
    public TrieNode(char data){
        this.data = data;
        isTerminating = false;
        children = new TrieNode[52];
        childCount=0;
    }
}

class Trie {
    private TrieNode root;
    public Trie() {
        root = new TrieNode('\0');
    }
    public void insert(String word) {
        insert(root,word);
    }
    private void insert(TrieNode root,String word){
        if(word.length()==0){
            root.isTerminating = true;
            return;
        }
        char first = word.charAt(0);
        int charIndex;
        if(Character.isUpperCase(first)){
            charIndex = first-'A'+26;
        }else{
            charIndex = first - 'a';
        }
        TrieNode child = root.children[charIndex];
        if(child==null){
            child = new TrieNode(first);
            root.children[charIndex] = child;
            root.childCount++;
        }
        insert(child,word.substring(1));
    }
    
    public boolean search(String word) {
        return search(root,word);
    }
    private boolean search(TrieNode root,String word){
        if(word.length()==0) return root.isTerminating;
        char first = word.charAt(0);
        int charIndex;
        if(Character.isUpperCase(first)){
            charIndex = first-'A'+26;
        }else{
            charIndex = first - 'a';
        }
        TrieNode child = root.children[charIndex];
        if(child==null) return false;
        return search(child,word.substring(1));
    }
    
    public boolean startsWith(String prefix) {
        return startsWith(root,prefix);
    }
    private boolean startsWith(TrieNode root,String prefix){
        if(prefix.length()==0) return true;
        char first = prefix.charAt(0);
        int charIndex;
        if(Character.isUpperCase(first)){
            charIndex = first-'A'+26;
        }else{
            charIndex = first - 'a';
        }
        TrieNode child = root.children[charIndex];
        if(child==null) return false;
        return startsWith(child,prefix.substring(1));
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */