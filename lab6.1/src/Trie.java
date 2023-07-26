//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

public class Trie {
    private TrieNode root = new TrieNode();

    public Trie() {
    }

    public void insert(String palabra) {
        TrieNode actual = this.root;

        int j;
        for(int i = 0; i < palabra.length() - 1; ++i) {
            j = palabra.charAt(i) - 97;
            actual.insertChildren(j, false);
            actual = actual.getChildren(j);
        }

        j = palabra.charAt(palabra.length() - 1) - 97;
        actual.insertChildren(j, true);
    }

    public boolean search(String palabra) {
        TrieNode actual = this.root;

        int j;
        for(int i = 0; i < palabra.length() - 1; ++i) {
            j = palabra.charAt(i) - 97;
            if (actual.getChildren(j) == null) {
                return false;
            }

            actual = actual.getChildren(j);
        }

        j = palabra.charAt(palabra.length() - 1) - 97;
        actual = actual.getChildren(j);
        return actual != null && actual.isEndOfWord();
    }
}
