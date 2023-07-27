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
            j = palabra.charAt(i) - 'a';
            if (actual.getChildren(j) == null) {
                return false;
            }

            actual = actual.getChildren(j);
        }

        j = palabra.charAt(palabra.length() - 1) - 'a';
        actual = actual.getChildren(j);
        return actual != null && actual.isEndOfWord();
    }
    public boolean delete(String palabra) {
        return delete(root, palabra, 0);
    }
    private boolean delete(TrieNode actual, String palabra, int indice) {
        if (indice == palabra.length()) {
            if (!actual.isEndOfWord()) {
                return false;
            }
            actual.setEndOfWord(false);
            return isEmpty(actual);
        }
        int indiceTrie = palabra.charAt(indice) - 'a';
        TrieNode nodo = actual.getChildren(indiceTrie);
        if (nodo == null) {
            return false;
        }
        boolean deberiaEliminarNodoActual = delete(nodo, palabra, indice + 1);
        if (deberiaEliminarNodoActual) {
            actual.setChildren(null,indiceTrie);
            return isEmpty(actual);
        }
        return false;
    }
    private boolean isEmpty(TrieNode nodo) {
        for (TrieNode hijo : nodo.getChildrens()) {
            if (hijo != null) {
                return false;
            }
        }
        return true;
    }
    public void reemplazar(String palabraAntigua, String palabraNueva) {
        delete(palabraAntigua);
        insert(palabraNueva);
    }
}
