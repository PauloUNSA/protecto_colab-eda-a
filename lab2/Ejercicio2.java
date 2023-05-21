public class Ejercicio2 {
    public static void main(String[] args) {
        int[] A = {1,2,3,4,5};
        for (int i :
                A) {
            System.out.println(i);
        }
        A=rotarIzquierdaArray(A);
        for (int i :
                A) {
            System.out.println(i);
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