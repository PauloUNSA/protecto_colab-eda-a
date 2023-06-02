import java.util.ArrayList;
import java.util.Stack;

public class Pila extends Stack {
    private ArrayList<Cilindro> cilindros= new ArrayList<>();
    private int d,hTotal=0;

    public Pila(int d) {
        this.d = d;
    }
}
