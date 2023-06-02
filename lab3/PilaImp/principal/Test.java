package principal;
import clases.Pila;
public class Test {

	public static void main(String[] args) throws Throwable {
		Pila pila=new Pila();
		
		
		
		pila.push(5);
		
		
		pila.push(5);
		pila.push(7);
		
		pila.push(10);
		pila.peek();
		pila.pop();
		System.out.print(pila);
	}

}
