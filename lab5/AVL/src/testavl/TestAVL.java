
package testavl;

import myExceptions.ExceptionNoFound;
public class TestAVL {
	public static void main(String[] args)throws ExceptionNoFound {
		AVL<Integer> avl = new AVL<>();
		avl.insert(1);
		avl.insert(2);
		avl.insert(3);
		avl.insert(4);
		avl.insert(5);
	}
	public void print(AVL<Integer> avl){
	}

}

