
package testavl;

import myExceptions.ExceptionNoFound;
public class TestAVL {


    public static void main(String[] args)throws ExceptionNoFound {
        AVL<Integer> b = new AVL<Integer>();
	b.insert(20);
		b.inOrden();
		b.insert(30);
		b.inOrden();
		System.out.println("root: " + b.getRoot());
		b.insert(40);
		b.inOrden();
		System.out.println("root: " + b.getRoot());
		b.insert(50);
		b.inOrden();
		b.insert(60);
		b.inOrden();
                b.insert(10);
		b.inOrden();
                b.insert(5);
		b.inOrden();
                b.insert(15);
		b.inOrden();
                

    }

}

