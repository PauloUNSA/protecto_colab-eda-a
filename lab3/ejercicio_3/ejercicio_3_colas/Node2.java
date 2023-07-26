package ejercicio_3_colas;

public class Node2<E extends Comparable<E>> {
    private E data;
    private Node2<E> leftNode;
    private Node2<E> rightNode;

    public Node2(E data) {
        this.data = data;
        this.leftNode = null;
        this.rightNode = null;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

    public Node2<E> getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(Node2<E> leftNode) {
        this.leftNode = leftNode;
    }

    public Node2<E> getRightNode() {
        return rightNode;
    }

    public void setRightNode(Node2<E> rightNode) {
        this.rightNode = rightNode;
    }
}
