//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean isEndOfWord;

    public TrieNode() {
    }

    public TrieNode(boolean isEndOfWord) {
        this.isEndOfWord = isEndOfWord;
    }

    public TrieNode getChildren(int i) {
        return this.children[i];
    }
    public void setChildren(TrieNode trieNode,int i) {
        this.children[i] = trieNode;
    }

    public TrieNode[] getChildrens() {
        return children;
    }

    public void insertChildren(int i, boolean eok) {
        if (this.children[i] == null) {
            this.children[i] = new TrieNode(eok);
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
