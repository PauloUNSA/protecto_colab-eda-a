public class Ejercicio2 {
    public static void main(String[] args) {
        int[] A = {1,2,3,4,5};
        System.out.println("Arreglo original");
        for (int i :
                A) {
            System.out.print(i+",");
        }
        System.out.println();
        A=rotarIzquierdaArray(A);
        System.out.println("Arreglo modificado");
        for (int i :
                A) {
            System.out.print(i+",");
        }
    }
    public static int[] rotarIzquierdaArray(int[] A){
        int[] aiz = new int[A.length];
        int mitad = A.length/2;
        int k=0;
        for (int i = mitad; i < A.length; i++,k++) {
            aiz[k]=A[i] ;
        }
        for (int i = 0; i < mitad; i++,k++) {
            aiz[k]=A[i] ;
        }
    return aiz;
}
}