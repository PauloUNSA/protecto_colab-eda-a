import java.util.Arrays;

// Trie node
class TrieNode {
     TrieNode[] children = new TrieNode[26];
    // isEndOfWord is true if the node
    // represents end of a word
     boolean isEndOfWord;

    public TrieNode() {
    }

    public TrieNode(boolean isEndOfWord) {
        this.isEndOfWord = isEndOfWord;
    }

    public TrieNode getChildren(int i) {

            return this.children[i];
    }

    public void insertChildren(int i,boolean eok) {
        if(this.children[i] == null) this.children[i] = new TrieNode(eok);
    }

    public boolean isEndOfWord() {
        return isEndOfWord;
    }

    public void setEndOfWord(boolean endOfWord) {
        isEndOfWord = endOfWord;
    }

    @Override
    public String toString() {
        String resul = "";
        for (int i = 0; i < children.length; i++) {
            if (children[i]!=null)
                resul += i+":"+children[i]+", ";
        }
        return "TrieNode{" +resul+"}";
    }
}
