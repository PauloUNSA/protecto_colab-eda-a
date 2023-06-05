package clases;

import java.util.Arrays;
import java.util.Vector;
import exepciones.EmptyStackException;
public interface Pila<E>{

	
	public boolean empty();
	public E peek() throws Throwable;
	public E pop() throws Throwable;
	
	public E push(E item) ;
	public int search(Object objeto) throws Throwable;
	@Override
	public String toString();
	

}
