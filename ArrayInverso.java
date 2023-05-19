public class ArrayInverso{
	public static void main(String[] args){
		
		int[] A={1,2,3};
		
		for(int i=0;i<A.length;i++){
			System.out.print(invertirArray(A)[i]+", ");
		}	
	
	}

	public static int[] invertirArray(int[] A){
		int[] Ain=new int[A.length]; 
		for(int i=0;i<A.length;i++){
			Ain[i]=A[A.length-1-i];
		}
		return Ain;
	}	


}
