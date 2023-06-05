package clases;

import exepciones.EmptyStackException;

public class PilaMatriz<T> implements Pila<T>{
	private Node<T> cabeza;
	private int numeroElementos;
	public PilaMatriz() {
		this.cabeza=null;
		this.numeroElementos=0;
	}
	public boolean empty() {
		return this.cabeza==null;
	}
	public T peek() throws Throwable {
		if(this.empty()) {
			throw(new EmptyStackException("La pila esta vacia"));
		}
		return this.cabeza.getDato();
	}
	public T pop() throws Throwable {
		if(this.empty()) {
			throw(new EmptyStackException("La pila esta vacia"));
		}
		T dato=this.cabeza.getDato();
		this.cabeza=this.cabeza.getNextNode();
		return dato;
	}
	
	public T push(T item) {
	
		this.cabeza=new Node<T>(item,this.cabeza);
	
		numeroElementos++;
		return item;
	}
	public int search(Object objeto) throws Throwable {
		
		if(this.empty()) {
			throw(new EmptyStackException("La pila esta vacia"));
		}
		int contador=1;
		Node<T> aux=this.cabeza;
		while(aux!=null) {
			if(aux.getDato().equals(objeto)) {
				return contador;
			}
			contador++;
			aux=aux.getNextNode();
		}
		return -1;
	}

	@Override
	public String toString() {
		String cadena="Pila [" ;
		if(this.empty()) {
			return cadena+"]";
		}
		Node<T> aux=this.cabeza;
		while(aux!=null) {
			
			cadena+=","+aux.getDato();
			aux=aux.getNextNode();
		}
		cadena+="]";
		return cadena;
		
	}
	
}
