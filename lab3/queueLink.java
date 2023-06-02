public class queueLink<E> implements cola<E>{
    private Node<E> head;
    private int count;

    public queueLink() {
        this.head = null;
        this.count = 0;
    }
    public boolean inEmpty(){
        return this.head == null;
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
    public void denqueue(){
        if(!inEmpty()){
            this.head=head.getNext();
            this.count--;
        }
    }
    @Override
    public String toString() {
        String str="";
        for(Node<E> aux= this.head;aux != null;aux=aux.getNext())
            str+= aux.toString()+", ";
        return str;
    }
    public String front(){
        String str=head.toString();
        return str;
    }
    public String back(){
        String str="";
        for(Node<E> aux=this.head;aux!=null;aux=aux.getNext()){
            if(aux.getNext()==null)
                str=aux.toString();
        }
        return str;
    }
    
    
}
