public class ArrayInverso{
	public static void main(String[] args){
		
		int[] A={1,2,3};
		
		System.out.println("Matriz original");
		imprimirMatriz(A);
		System.out.println("Matriz invertida");
		imprimirMatriz(invertirArray(A));
	
	}

	public static int[] invertirArray(int[] A){
		int[] Ain=new int[A.length]; 
		for(int i=0;i<A.length;i++){
			Ain[i]=A[A.length-1-i];
		}
		return Ain;
	}	
	public static void imprimirMatriz(int[] matriz ){
		for (int i=0;i<matriz.length;i++){
			
			System.out.print(matriz[i]+" ");
		}
		System.out.println();

	}

}
