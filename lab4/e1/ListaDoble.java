import java.util.ArrayList;

public class ListaDoble<E> {
    private Node<E> inicio,fin;

    public ListaDoble() {
        inicio=fin=null;
    }

    public void addFinal(E x){
        if(!isEmpty()){
            fin=new Node<>(x,null,fin);
            fin.getPreviousNode().setNextNode(fin);
        }else {
            inicio=fin= new Node<>(x);
        }
    }
    public void addInicio(E x){
        if(!isEmpty()){
            inicio=new Node<>(x,inicio,null);
            inicio.getNextNode().setPreviousNode(inicio);
        }else {
            inicio=fin= new Node<>(x);
        }
    }

    public boolean isEmpty() {
        return inicio == null;
    }
    @Override
    public String toString() {
        String text="";
        if (!isEmpty()){
            Node<E> aux = inicio;
            while (aux!=null){
                text += aux.getData()+" ";
                aux = aux.getNextNode();
            }
        }
        return  text;
    }
}
