public class TrieNode<E> {
    private boolean isEndOfWord;
    private E data;
    private TrieNode<E> hermano;
    private ListLinked<E> hijo;
    
    public TrieNode(E data, TrieNode<E> hermano) {
        this.data = data;
        this.hermano = hermano;
        this.hijo=new ListLinked<>();
        this.isEndOfWord=false;
    }
    public TrieNode(E data){
        this(data,null);
    }

    public boolean isIsEndOfWord() {
        return isEndOfWord;
    }

    public void setIsEndOfWord(boolean isEndOfWord) {
        this.isEndOfWord = isEndOfWord;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

    public TrieNode<E> getHermano() {
        return hermano;
    }

    public void setHermano(TrieNode<E> hermano) {
        this.hermano = hermano;
    }

    public ListLinked<E> getHijo() {
        return hijo;
    }

    public void setHijo(ListLinked<E> hijo) {
        this.hijo = hijo;
    }
    
    @Override
    public String toString() {
        return this.data.toString();
    }

}

