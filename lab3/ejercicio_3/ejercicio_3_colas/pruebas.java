package ejercicio_3_colas;
import myExceptions.ExceptionIsEmpty;

public class pruebas {


    public static void main(String[] args) throws ExceptionIsEmpty {
        BST<String>  bst = new BST<>();
        bst.insert("P");
        bst.insert("K");
        bst.insert("R");
        bst.insert("D");
        bst.insert("L");
        bst.insert("U");
        bst.insert("F");
        bst.porNiveles();
    }
}
