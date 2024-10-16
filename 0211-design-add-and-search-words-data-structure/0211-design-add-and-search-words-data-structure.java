class Node{
    public char word;
    public Node[] children;
    public boolean isTerminating;
    public int wordCount;
    public Node(char c){
        word = c;
        children = new Node[52];
        wordCount = 0;
        isTerminating = false;
    }
}

class WordDictionary {
    private Node root;

    public WordDictionary() {
        root = new Node('\0');
    }
    
    public void addWord(String word) {
        addWord(root,word);
    }
    private void addWord(Node root,String word){
        if(word.length()==0){
            root.isTerminating = true;
            return;
        }
        int childIndex = word.charAt(0) - 'a';
        Node childNode = root.children[childIndex];
        if(childNode==null){
            childNode = new Node(word.charAt(0));
            root.children[childIndex] = childNode;
            root.wordCount++;
        }
        addWord(childNode,word.substring(1));
    }
    
    public boolean search(String word) {
        return search(root,word);
    }
    private boolean search(Node root,String word){
        if(word.length()==0) return root.isTerminating;
        if(word.charAt(0)=='.'){
           for (int i = 0; i < 26; i++) {
            if (root.children[i] != null && search(root.children[i], word.substring(1))) {
                return true;  // If any child leads to a valid word, return true
            }
        }
        return false;
           
        }
        int childIndex = word.charAt(0) - 'a';
        Node childNode = root.children[childIndex];
        if(childNode==null) return false;
        return search(childNode,word.substring(1));
        
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */