

class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean isEndOfWord;

    public TrieNode() {
    }

    public TrieNode(boolean isEndOfWord) {
        this.isEndOfWord = isEndOfWord;
    }

    public TrieNode getChildren(int i) {
        if (i>=0&&i<=26) return this.children[i];
        return null;
    }
    public void setChildren(TrieNode trieNode,int i) {
        this.children[i] = trieNode;
    }

    public TrieNode[] getChildrens() {
        return children;
    }

    public void insertChildren(int i, boolean eok) {
        if (i>=0&&i<=26) {
            if (this.children[i] == null) this.children[i] = new TrieNode(eok);
            else if (!this.children[i].isEndOfWord() && eok) this.children[i].setEndOfWord(true);
        }
    }

    public boolean isEndOfWord() {
        return this.isEndOfWord;
    }

    public void setEndOfWord(boolean endOfWord) {
        this.isEndOfWord = endOfWord;
    }

    public String toString() {
        String resul = "";

        for(int i = 0; i < this.children.length; ++i) {
            if (this.children[i] != null) {
                resul = resul + i + ":" + String.valueOf(this.children[i]) + ", ";
            }
        }

        return "TrieNode{" + resul + "}";
    }
}
