public class Trie {
    private TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }
    public void insert(String palabra){
        TrieNode actual = root;
        int j;
        for (int i = 0; i < palabra.length()-1; i++) {
            j = palabra.charAt(i) - 'a';
            actual.insertChildren(j,false);
            actual = actual.getChildren(j);
        }

        j = palabra.charAt(palabra.length()-1) - 'a';
        actual.insertChildren(j,true);
    }
    public boolean search(String palabra){
        TrieNode actual = root;
        int j;
        for (int i = 0; i < palabra.length()-1; i++) {
            j = palabra.charAt(i) - 'a';
            if (actual.getChildren(j) == null) {
                return false;
            }
            actual = actual.getChildren(j);
        }
        j = palabra.charAt(palabra.length()-1) - 'a';
        actual = actual.getChildren(j);
        return actual != null && actual.isEndOfWord();
    }
}
