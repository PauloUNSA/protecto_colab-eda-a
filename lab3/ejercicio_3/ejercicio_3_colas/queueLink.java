package ejercicio_3_colas;
import myExceptions.ExceptionIsEmpty;

public class queueLink<E> implements cola<E>{
    private Node<E> head;
    private int count;

    public queueLink() {
        this.head = null;
        this.count = 0;
    }
    public boolean inEmpty(){
        return this.count ==0;
    }
    public void enqueue (E x){
        if(inEmpty()){
            this.head=new Node(x, null);
            this.count++;
        }
        else{
            Node<E> aux=this.head;
            while (aux.getNext()!=null) 
                aux=aux.getNext();
            aux.setNext(new Node<E>(x));
            this.count++;
        }
    }
    public E denqueue() throws ExceptionIsEmpty{
        if (inEmpty())
            throw new ExceptionIsEmpty("la cola esta vacia ...");
        this.head=head.getNext();
        this.count--;
        return (E) head;
    }
    @Override
    public String toString() {
        String str="";
        for(Node<E> aux= this.head;aux != null;aux=aux.getNext())
            str+= aux.toString()+", ";
        return str;
    }
    
    public E front() throws ExceptionIsEmpty{
        if (inEmpty())
            throw new ExceptionIsEmpty("la cola esta vacia ...");
        return (E) head;
    }
    public E back() throws ExceptionIsEmpty{
        if (inEmpty())
            throw new ExceptionIsEmpty("la cola esta vacia ...");
        String str="";
        Node<E> aux;
        for(aux=this.head;aux!=null;aux=aux.getNext()){
            if(aux.getNext()==null){
                break;
            }
        }
        return (E) aux;
    }    
}
