import myExceptions.ExceptionNoFound;

public class ListLinked<E> implements TDAList<E>{
	private TrieNode<E> head;
	private int count;
	
	public ListLinked() {
		this.head = null;
		this.count = 0;
	}
	
	public boolean isEmpty() {
		return this.head == null;
	}
	
	public int lenght() {
		return this.count;
	}
	
	public void insertFirstHermano(E x) {
		this.head = new TrieNode<E>(x, this.head);
		this.count ++;
	}
	
	public void insertLastHermano(E x) {
		if (isEmpty())
			insertFirstHermano(x);
		else {
			TrieNode<E> aux = this.head;
			while ( aux.getHermano()!= null)
				aux = aux.getHermano();
			aux.setHermano(new TrieNode<E>(x));
			this.count ++;
		}
	}
        public void inserthijo(E x){
            TrieNode<E> aux = this.head;
            
            while ( aux.getHijo()!= null)
				aux = aux.getHermano();
		aux.setHermano(new TrieNode<E>(x));
        }

	public boolean search(E x) { 
		TrieNode<E> aux = this.head;
		for(; aux != null && !aux.getData().equals(x); aux = aux.getHermano());
                    return aux != null;
	}
        public TrieNode<E> searchData(E x) {
		TrieNode<E> aux = this.head;
		for(; aux != null; aux = aux.getHermano()) {
			if (aux.getData().equals(x)) {
				return aux;
			}
		}
		return null;
	}
	
	public void remove(E x) {
		if (!isEmpty()) {
			if (this.head.getData().equals(x)) {
				this.head = this.head.getHermano();
				this.count --;
			}
			else {
				TrieNode<E> aux = this.head;
				while(aux.getHermano()!=  null && !aux.getHermano().getData().equals(x))
					aux = aux.getHermano();
				if (aux.getHermano()!= null) {
					aux.setHermano(aux.getHermano().getHermano());
					this.count --;
				}
			}
		}
	}
	
	public String toString() {
		String str = "";
		for(TrieNode<E> aux = this.head; aux != null; aux = aux.getHermano())
			str += aux.toString() + ", ";
		return str;
	}
	
	
}
