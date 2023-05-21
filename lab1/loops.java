public class loops{
	public static void main(String args[]){
		//ejercicio 1
		int i=1;
		while(i<6){
			System.out.println(i);
			i++;
		}
		//ejercicio 2
		int j=1;
		do{
			System.out.println(j);
			j++;
		}
		while(j<6);
		//ejercicio 3
		for(int k=0;k<5;k++){
			System.out.println("yes");
		}
		//ejercicio 4
		String[] cars={"volvo","BMW","Ford"};
		for(String m : cars){
			System.out.println(m);
		}
		//ejercicio 5
		for(int n=0;n<10;n++){
			if(n==5){
				break;
			}
			System.out.println(n);
		}
		//ejercicio 6
		for(int l=0;l<10;l++){
			if(l==4){
				continue;
			}
			System.out.println(l);
		}

	}
}
