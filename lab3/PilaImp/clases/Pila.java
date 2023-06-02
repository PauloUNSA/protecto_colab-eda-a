package clases;

import java.util.Arrays;
import java.util.Vector;
import exepciones.EmptyStackException;
public class Pila<E> extends Vector{

	public Pila() {
		
	}
	
	public boolean empty() {
		return this.size()==0;
	}
	public E peek() throws Throwable {
		if(this.empty()) {
			throw(new EmptyStackException("La pila esta vacia"));
		}
		return  (E) this.get(this.size()-1);
	}
	public E pop() throws Throwable {
		if(this.empty()) {
			throw(new EmptyStackException("La pila esta vacia"));
		}
		E eliminado=(E) this.get(this.size()-1);
		this.remove(this.get(this.size()-1));
		return eliminado;
	}
	
	public E push(E item) {
		this.addElement(item);
		return item;
	}
	public int search(Object objeto) {
		for(int i=0;i<this.size();i++) {
			if(objeto.equals(this.get(i))) {
				return i;
			}
		}
		return -1;
	}

	@Override
	public String toString() {
		String cadena="Pila [" ;
		for(int i=0;i<this.size();i++) {
			if(this.get(i)!=null) {
				cadena+=this.get(i)+" ";
			}
		}
		
		return cadena+"]";
	}
	

}
