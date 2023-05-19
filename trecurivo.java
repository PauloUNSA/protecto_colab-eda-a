public class trecursi{
	public static void main(String args[]){
		int j=5;
        	trianguloRecursivo(j);

    }
    public static void trianguloRecursivo(int base){
        String l;
	if(base>0)
        	trianguloRecursivo(base-1);
        for(int i=0;i<base;i++){
        System.out.print("*");}
	System.out.println();
}
    }
