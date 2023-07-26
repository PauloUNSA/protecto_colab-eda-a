package e2;

public class Node<E> {
    public E data;
    public Node<E> nextNode;

    public Node() {
        this.data = null;
        this.nextNode = null;
    }

    public Node(E data) {
        this.data = data;
        this.nextNode = null;
    }

    public Node(E data, Node<E> nextNode) {
        this.data = data;
        this.nextNode = nextNode;
    }
    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

    public Node<E> getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node<E> nextNode) {
        this.nextNode = nextNode;
    }
}
