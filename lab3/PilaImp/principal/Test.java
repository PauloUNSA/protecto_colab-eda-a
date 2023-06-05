package principal;
import clases.*;
public class Test {

	public static void main(String[] args) throws Throwable {
		PilaMatriz <Persona> pila=new PilaMatriz<Persona>();
		Persona juan=new Persona("Juan", 24,'M');
		
		
		pila.push(new Persona("Pedro",15,'M'));//añadir un objeto de clase persona
	
		pila.push(new Persona("Juan", 24,'M'));
		pila.push(new Persona("Maria",4,'F'));
		pila.push(new Persona("Tommy",25,'M'));
		System.out.println(pila);//imprimir pila
		pila.push(new Persona("Pedro",15,'M'));
		System.out.println(pila);
		System.out.println(pila.peek());
		
		System.out.println(pila.pop());
		System.out.println(pila);
		System.out.print(pila.search(juan));
		
		
	}

}
