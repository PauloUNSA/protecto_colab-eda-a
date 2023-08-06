package sistema;

import trie.Trie;

import java.util.ArrayList;

public class ResulChacker {
    private boolean[] resul;
    String str;

    public ResulChacker(ArrayList<Trie> tries,String str) {
        resul = new boolean[tries.size()];
        this.str = str;
    }

    public boolean[] getResul() {
        for (boolean b :
                resul) {
            b = false;
        }
        return resul;
    }
    private boolean detectplagairism(){
        return false;
    }
}
