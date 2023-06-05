package clases;

import java.util.Objects;

public class Node <T>{
	
	private T dato;
	private Node<T> nextNode;
	
	public Node(T dato, Node<T> nextNode) {
		this.dato=dato;
		this.nextNode=nextNode;
	}

	public T getDato() {
		return dato;
	}

	public Node<T> getNextNode() {
		return nextNode;
	}

	

	

 
}
