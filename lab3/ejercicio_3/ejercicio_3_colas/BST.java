package ejercicio_3_colas;

public class BST<E extends Comparable<E>> {
    private Node2<E> root;

    public BST() {
        this.root = null;
    }

    public void insert(E x) {
        root = insertRec(root, x);
    }

    private Node2<E> insertRec(Node2<E> currentNode, E x) {
        if (currentNode == null) {
            return new Node2<>(x);
        }

        if (x.compareTo(currentNode.getData()) < 0) {
            currentNode.setLeftNode(insertRec(currentNode.getLeftNode(), x));
        } else if (x.compareTo(currentNode.getData()) > 0) {
            currentNode.setRightNode(insertRec(currentNode.getRightNode(), x));
        }

        return currentNode;
    }

    public void remove(E x) {
        root = removeRec(root, x);
    }

    private Node2<E> removeRec(Node2<E> currentNode, E x) {
        if (currentNode == null) {
            return null;
        }

        if (x.compareTo(currentNode.getData()) < 0) {
            currentNode.setLeftNode(removeRec(currentNode.getLeftNode(), x));
        } else if (x.compareTo(currentNode.getData()) > 0) {
            currentNode.setRightNode(removeRec(currentNode.getRightNode(), x));
        } else {
            if (currentNode.getLeftNode() == null) {
                return currentNode.getRightNode();
            } else if (currentNode.getRightNode() == null) {
                return currentNode.getLeftNode();
            }

            Node2<E> minValueNode = findMinValueNode(currentNode.getRightNode());
            currentNode.setData(minValueNode.getData());
            currentNode.setRightNode(removeRec(currentNode.getRightNode(), minValueNode.getData()));
        }

        return currentNode;
    }

    private Node2<E> findMinValueNode(Node2<E> node) {
        Node2<E> current = node;
        while (current.getLeftNode() != null) {
            current = current.getLeftNode();
        }
        return current;
    }

    public E search(E x) {
        return searchRec(root, x);
    }

    private E searchRec(Node2<E> currentNode, E x) {
        if (currentNode == null || currentNode.getData().equals(x)) {
            return currentNode != null ? currentNode.getData() : null;
        }

        if (x.compareTo(currentNode.getData()) < 0) {
            return searchRec(currentNode.getLeftNode(), x);
        } else {
            return searchRec(currentNode.getRightNode(), x);
        }
    }
    public boolean isEmpty(){
        return root==null;
    }
    public void porNiveles(){
        QueueLink<Element<E>> cola = new QueueLink<>();
        String resul = "";
        if (isEmpty()) System.out.println("arbol vacio");
        else {
            cola.enqueue(new Element<E>(root,0));
            int nivelAnterior = -1;
            while (!cola.inEmpty()){
                Element<E> aux = cola.dequeue();
                Node<E> nodo = aux.node;
                int nivel = aux.nivel;
                if (nivelAnterior != nivel){
                    resul += "\nNivel:"+nivel+" ";
                    nivelAnterior = nivel;
                }
                resul += nodo.toString()+" ";
                if (nodo.getLeft() != null){
                    cola.enqueue(new Element<E>(nodo.getLeft(),nivel+1));
                }
                if (nodo.getRight() != null){
                    cola.enqueue(new Element<E>(nodo.getRight(),nivel+1));
                }
            }
        }
        System.out.println(resul);
    }
}
