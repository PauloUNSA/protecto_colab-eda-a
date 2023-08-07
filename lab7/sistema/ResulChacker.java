package sistema;

import trie.Trie;

import java.util.ArrayList;

public class ResulChacker {
    private boolean[] resul;
    String str;

    public ResulChacker(ArrayList<Trie> tries, String str) {
        resul = new boolean[tries.size()];
        this.str = str;
        detectPlagiarism(tries);
    }

    public boolean[] getResul() {
        return resul;
    }

    private void detectPlagiarism(ArrayList<Trie> tries) {
        String[] words = str.toLowerCase().split(" ");
        for (int i = 0; i < resul.length; i++) {
            int numPalbrasConcidentes =0;
            Trie trie = tries.get(i);
            for (String word : words) {
                if (trie.search(word)) {
                    numPalbrasConcidentes++;
                }
            }
            System.out.println(trie.getSize());
            resul[i] = (int) (0.2 * trie.getSize()) <= numPalbrasConcidentes;
        }
    }
}

