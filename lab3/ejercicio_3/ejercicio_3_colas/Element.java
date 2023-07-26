package ejercicio_3_colas;

public class Element <E>{
    public Node<E> node;
    public int nivel;

    public Element(E x, int nivel) {
        this.node = new Node<>(x);
        this.nivel = nivel;
    }
}
