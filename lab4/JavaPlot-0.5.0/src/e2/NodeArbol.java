package e2;

public class NodeArbol<E> {
    private E dato;
    private NodeArbol<E> izquierdo;
    private NodeArbol<E> derecho;

    public NodeArbol(E dato) {
        this.dato = dato;
        izquierdo = null;
        derecho = null;
    }

    public E getDato() {
        return dato;
    }

    public void setDato(E dato) {
        this.dato = dato;
    }

    public NodeArbol<E> getIzquierdo() {
        return izquierdo;
    }

    public void setIzquierdo(NodeArbol<E> izquierdo) {
        this.izquierdo = izquierdo;
    }

    public NodeArbol<E> getDerecho() {
        return derecho;
    }

    public void setDerecho(NodeArbol<E> derecho) {
        this.derecho = derecho;
    }
}
