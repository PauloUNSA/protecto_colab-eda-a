package e2;
public class LinkedList<E> {
    Node<E> head;

    public LinkedList() {
        this.head = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void insertAtTail(E data) {
        Node<E> newNode = new Node<>(data);
        if (isEmpty()) {
            head = newNode;
        } else {
            Node<E> currentNode = head;
            while (currentNode.getNextNode() != null) {
                currentNode = currentNode.getNextNode();
            }
            currentNode.setNextNode(newNode);
        }
    }
    public Node<E> getHead() {
        return head;
    }

    public void setHead(Node<E> head) {
        this.head = head;
    }

    public void printList() {
        Node<E> currentNode = head;
        while (currentNode != null) {
            System.out.print(currentNode.getData() + " ");
            currentNode = currentNode.getNextNode();
        }
        System.out.println();
    }
}
