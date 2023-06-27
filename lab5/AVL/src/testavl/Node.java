
package testavl;

public class Node<E> {
    private E data;
    private Node<E> rigth;
    private Node<E> left;

    public Node() {
        this.data = null;
        this.rigth = null;
        this.left = null;
    }

    public Node(E data) {
        this.data = data;
        this.rigth = null;
        this.left = null;
    }

    public Node(E data, Node<E> rigth) {
        this.data = data;
        this.rigth = rigth;
        this.left = null;
    }

    public Node(E data, Node<E> rigth, Node<E> left) {
        this.data = data;
        this.rigth = rigth;
        this.left = left;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

    public Node<E> getRigth() {
        return rigth;
    }

    public void setRigth(Node<E> rigth) {
        this.rigth = rigth;
    }

    public Node<E> getLeft() {
        return left;
    }

    public void setLeft(Node<E> left) {
        this.left = left;
    }
}

