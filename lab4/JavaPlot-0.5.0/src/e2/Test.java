package e2;
public class Test {
    public static void main(String[] args) {
        LinkedList<LinkedList<Integer>> miLista = new LinkedList<>();
        LinkedList<Integer> linkedList1 = new LinkedList<>();
        LinkedList<Integer> linkedList2 = new LinkedList<>();
        linkedList1.insertAtTail(1);
        linkedList1.insertAtTail(2);
        linkedList1.insertAtTail(3);
        linkedList2.insertAtTail(5);
        linkedList2.insertAtTail(4);
        miLista.insertAtTail(linkedList1);
        miLista.insertAtTail(linkedList2);
        mostrar(miLista);
    }
    public static void mostrar(LinkedList<LinkedList<Integer>> miLista){
        Node<LinkedList<Integer>> fila = miLista.head;
        Node<Integer> entero;
        while (fila != null){
            entero = fila.data.getHead();
            while (entero != null){
                System.out.print(entero.data+" ");
                entero=entero.nextNode;
            }
            System.out.println();
            fila = fila.nextNode;

        }
    }
}
