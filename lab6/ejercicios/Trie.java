public class Trie<E>{
    private ListLinked<Character> root;

    public Trie(ListLinked<Character> root) {
        this.root = root;
    }
    public Trie() {
        this.root = new ListLinked<Character>();
    }
    public boolean isEmpty() {
	return this.root == null;
    }
    public void insert(String x) {
        ListLinked<Character> aux = this.root;
        for(int i=0;i<x.length();i++){
            if(aux.search(x.charAt(i))) {
                //nodo retornado
                aux=aux.searchData(x.charAt(i)).getHijo();
            }
            else{
                aux.insertLastHermano(x.charAt(i));
                if(i==x.length()-1){
                    aux.searchData(x.charAt(i)).setIsEndOfWord(true);
                }
                aux=aux.searchData(x.charAt(i)).getHijo();
                
            }
            
        }
    }
