package eda_lab4_ej1;


public class NodeLink<E> implements TDAList<E>{
    private Node<E> head;
    private int count;
    
    public NodeLink() {
        this.head = null;
        this.count=0;
    }

    public int getCount() {
        return count;
    }

    public Node<E> getHead() {
        return head;
    }
    
    public boolean IsEmpty(){
        return this.head == null;
    }
    
    public int lenght(){
        return this.count;
    }
    
    public void InserFist(E x){
        this.head=new Node<E>(x,this.head);
        this.count++;
    }
    public void InserLast(E x){
        if(IsEmpty())
            InserFist(x);
        else{
            Node<E> aux=this.head;
            while (aux.getNext()!=null) 
                aux=aux.getNext();
            aux.setNext(new Node<E>(x));
            this.count++;
        }
    }
    
    public void remove(E x){
        if(!IsEmpty()){
            if(this.head.getData().equals(x)){
                this.head=this.head.getNext();
                this.count--;
            }
            else{
                Node<E> aux=this.head;
                while(aux.getNext()!= null && !aux.getNext().getData().equals(x))
                    aux=aux.getNext();
                if(aux.getNext() !=null){
                    aux.setNext(aux.getNext().getNext());
                    this.count--;
                }
            }
        }
    }
    public void remove(int indice) {
        if(indice<count) {
        if(indice==0)
            head=head.getNext();
        else {
            Node<E> anterior=this.get(indice-1);
            anterior.setNext(this.get(indice+1));
        }
        count--;
        }
}

    public Node<E> get(int indice) {
        Node<E> aux=head;
        for(int i=0;i<indice;i++)
            aux=aux.getNext();
        return aux;
            }
    
    @Override
    public String toString() {
        String str="";
        for(Node<E> aux= this.head;aux != null;aux=aux.getNext())
            str+= aux.toString()+", ";
        return str;
    }
}
