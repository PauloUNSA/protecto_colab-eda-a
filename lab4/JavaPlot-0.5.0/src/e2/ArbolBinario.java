package e2;

public class ArbolBinario<E> {
    private NodeArbol<E> raiz;

    public ArbolBinario() {
        raiz = null;
    }

    public void insertar(E dato) {
        NodeArbol<E> nuevoNodo = new NodeArbol<>(dato);
        if (raiz == null) {
            raiz = nuevoNodo;
        } else {
            NodeArbol<E> nodoActual = raiz;
            boolean insertado = false;
            while (!insertado) {
                if (nodoActual.getIzquierdo() == null) {
                    nodoActual.setIzquierdo(nuevoNodo);
                    insertado = true;
                } else if (nodoActual.getDerecho() == null) {
                    nodoActual.setDerecho(nuevoNodo);
                    insertado = true;
                } else {
                    nodoActual = nodoActual.getIzquierdo();
                }
            }
        }
    }

    public NodeArbol<E> getRaiz() {
        return raiz;
    }

    public void setRaiz(NodeArbol<E> raiz) {
        this.raiz = raiz;
    }

    public static void main(String[] args) {
        ArbolBinario<Integer> arbol = new ArbolBinario<>();
        arbol.insertar(1);
        arbol.insertar(2);
        arbol.insertar(3);
        arbol.insertar(4);
        arbol.insertar(5);
        arbol.insertar(6);
        arbol.insertar(7);

        // Imprimir el árbol en preorden
        System.out.println("Árbol en preorden:");
        preorden(arbol.getRaiz());
    }

    private static void preorden(NodeArbol<?> nodo) {
        if (nodo != null) {
            System.out.print(nodo.getDato() + " ");
            preorden(nodo.getIzquierdo());
            preorden(nodo.getDerecho());
        }
    }
}
