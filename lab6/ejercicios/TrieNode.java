public class TrieNode {
    private boolean isEndOfWord;
    private TrieNode nextnode;
    private static final int ALPHABET_SIZE = 26;
    private TrieNode[] children;

    public TrieNode() {
        children = new TrieNode[ALPHABET_SIZE];
        isEndOfWord = false;
    }

    public boolean isIsEndOfWord() {
        return isEndOfWord;
    }

    public void setIsEndOfWord(boolean isEndOfWord) {
        this.isEndOfWord = isEndOfWord;
    }

    public TrieNode getNextnode() {
        return nextnode;
    }

    public void setNextnode(TrieNode nextnode) {
        this.nextnode = nextnode;
    }

    public TrieNode[] getChildren() {
        return children;
    }

    public void setChildren(TrieNode[] children) {
        this.children = children;
    }

}
