public class metodos{

	public static void main(String[] args){
		//ejercicio 1
		myMethod();

		//ejercicio 2
		myMethod();
		myMethod();
		//ejercicio 3
		myMethod("John Doe");
		//ejercicio 4
		System.out.println(myMethod(3));
		//ejercicio 5
		verificar(20);
	}
	static void myMethod() {
 	 System.out.println("I just got executed!");
	}
	static void myMethod(String fname) {
		System.out.println(fname + " Doe");
	}	

	static int myMethod(int x) {
  		return 5 + x;
	}
	static void verificar(int x){
		if(x<18)
			System.out.println("Access denied"); 
		else
			System.out.println("Access granted");
	}

}
