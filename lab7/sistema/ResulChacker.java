package sistema;

import trie.Trie;

import java.util.ArrayList;

public class ResulChacker {
    private boolean[] resul;

    public ResulChacker(ArrayList<Trie> tries) {
        resul = new boolean[tries.size()];
    }

    public boolean[] getResul() {
        return resul;
    }
}
